package MainGame.Characters;

import MainGame.Handlers.EnemyCollHandler;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public abstract class Enemy extends Walker implements
        ActionListener, StepListener {
    private static final Random random = new Random();
    private static final ArrayList<Enemy> enemyList = new ArrayList<>();
    private final Timer timer;

    protected int yLimit;
    protected Boolean left;
    protected Boolean dead = false;
    protected Fixture fixture;
    protected Shape leftShape;
    protected Shape rightShape;
    protected BodyImage leftImage;
    protected BodyImage rightImage;

    public Enemy(World world) {
        super(world);
        initialize();
        new EnemyCollHandler(this);
        world.addStepListener(this);

        // destroy after 20 seconds
        timer = new Timer(20000, this);
        timer.setInitialDelay(20000);
        timer.start();

        // assign random direction
        if (random.nextBoolean()) {
            walkLeft();
        }
        else {
            walkRight();
        }
        enemyList.add(this);
    }

    public Boolean isDead() {
        return dead;
    }

    public static void destroyAllEnemies() {
        for (Enemy enemy : enemyList) {
            enemy.destroy();
            enemy.timer.stop();
        }
        enemyList.clear();
    }

    public void reverseDirection() {
        if (left) {
            walkRight();
        }
        else {
            walkLeft();
        }
    }

    public void walkLeft() {
        if (fixture != null) {
            fixture.destroy();
        }
        fixture = new SolidFixture(this, leftShape);
        removeAllImages();
        addImage(leftImage);
        startWalking(-10);
        left = true;
    }

    public void walkRight() {
        if (fixture != null) {
            fixture.destroy();
        }
        fixture = new SolidFixture(this, rightShape);
        removeAllImages();
        addImage(rightImage);
        startWalking(10);
        left = false;
    }

    public abstract void initialize();

    @Override
    public void actionPerformed(ActionEvent ae) {
        timer.stop();
        destroy(); // do not animate if death by time-out
    }

    public void animateDeath() {
        dead = true;
        fixture.destroy();
        fixture = new GhostlyFixture(this, leftShape);
        removeAllImages();
        addImage(new BodyImage("data/Characters/Enemies/death.gif", 10));
        startWalking(0);

        Timer timer = new Timer(500, ae -> destroy()); // destroy after 0.5 seconds
        timer.setRepeats(false);
        timer.start();
    }

    @Override
    public void preStep(StepEvent se) {
        // do not allow enemy to fall to spikes
        if (getPosition().y < yLimit) {
            setPosition(new Vec2(getPosition().x, yLimit));
        }
    }

    @Override
    public void postStep(StepEvent se) {}
}
