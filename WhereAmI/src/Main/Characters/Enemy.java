package Main.Characters;

import Main.Handlers.EnemyCollHandler;
import city.cs.engine.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public abstract class Enemy extends Walker implements
        ActionListener, StepListener {
    private static final Random rand = new Random();
    private static final ArrayList<Enemy> enemyList = new ArrayList<>();
    private final Timer timer;

    protected Boolean left;
    protected SolidFixture fixture;
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
        if (rand.nextBoolean()) {
            walkLeft();
        }
        else {
            walkRight();
        }
        enemyList.add(this);
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
        destroy();
        timer.stop();
    }
    @Override
    public void postStep(StepEvent se) {}
}
