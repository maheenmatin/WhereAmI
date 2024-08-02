package Main;

import city.cs.engine.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public abstract class Enemy extends Walker implements ActionListener, StepListener {
    private static final Random rand = new Random();
    private static boolean destroyAllEnemies;

    public Enemy(World world) {
        super(world);
        world.addStepListener(this);

        Timer timer = new Timer(10000, this);
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
    }

    public static void setDestroyAllEnemies(boolean destroyAllEnemies) {
        Enemy.destroyAllEnemies = destroyAllEnemies;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        destroy();
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (destroyAllEnemies) {
            destroy();
        }
    }

    @Override
    public void postStep(StepEvent stepEvent) {}

    public abstract void assignShapeLeft();
    public abstract void assignShapeRight();
    public abstract void assignImageLeft();
    public abstract void assignImageRight();
}
