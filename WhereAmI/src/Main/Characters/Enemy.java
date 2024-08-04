package Main.Characters;

import city.cs.engine.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public abstract class Enemy extends Walker implements ActionListener, StepListener {
    private final Timer timer;
    private static final Random rand = new Random();
    private static final ArrayList<Enemy> enemyList = new ArrayList<>();

    public Enemy(World world) {
        super(world);
        world.addStepListener(this);
        timer = new Timer(10000, this);
        timer.setInitialDelay(10000);
        timer.start();

        if (rand.nextBoolean()) {
            assignShapeRight();
            assignImageRight();
            startWalking(10);
        }
        else {
            assignShapeLeft();
            assignImageLeft();
            startWalking(-10);
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

    @Override
    public void actionPerformed(ActionEvent ae) {
        destroy();
        timer.stop();
    }

    public abstract void assignShapeLeft();
    public abstract void assignShapeRight();
    public abstract void assignImageLeft();
    public abstract void assignImageRight();
    @Override
    public void postStep(StepEvent se) {}
}
