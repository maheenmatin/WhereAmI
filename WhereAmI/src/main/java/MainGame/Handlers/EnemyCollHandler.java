package MainGame.Handlers;

import MainGame.Characters.Enemy;
import MainGame.Environment.Wall;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnemyCollHandler implements ActionListener, CollisionListener {
    private final Enemy enemy;
    private boolean lock = false;
    private final Timer timer;

    public EnemyCollHandler(Enemy enemy) {
        this.enemy = enemy;
        enemy.addCollisionListener(this);
        timer = new Timer(1000, this);
    }

    public void collide(CollisionEvent ce) {
        if (ce.getOtherBody() instanceof Wall ||
                ce.getOtherBody() instanceof Enemy) {
            if (!lock) {
                // disable reverse direction for 1 second
                enemy.reverseDirection();
                lock = true;
                timer.start();
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        lock = false;
        timer.stop();
    }
}
