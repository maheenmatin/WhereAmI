package Main;

import Main.Characters.*;
import Main.Controllers.PlayerController;
import Main.Environment.Ground;
import Main.Environment.Spike;
import Main.Environment.Stairs;
import Main.Environment.Wall;
import Main.Handlers.EventHandler;
import Master.GameView;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameWorld extends World implements CollisionListener, ActionListener {
    private Timer timer;
    private Player player;
    private PlayerController playerController;
    private final GameView gameView;
    private final Random rand = new Random();

    public GameWorld(GameView gameView) {
        this.gameView = gameView;
        createEnvironment();
        createPlayer();
        enableKeyboardControls();
        enableEnemyCreation();
    }

    public Player getPlayer() {
        return player;
    }

    private void createEnvironment() {
        // create invisible walls at start and end
        new Wall(this, 0, 25);
        new Wall(this, 500, 25);

        // create spikes
        Spike.reinitialize();
        for (int i = 0; i < 6; i++) {
            new Spike(this);
        }

        // create the ground
        new Ground(this, 10, -10);
        new Ground(this, 30, -10);
        new Ground(this, 70 , -10);

        new Stairs(this, 105, -6, false);
        new Ground(this, 120, -2);
        new Ground(this, 140, -2);
        new Stairs(this, 155, -6, true);

        new Ground(this, 190, -10);
        new Ground(this, 235, -10);
        new Ground(this, 255, -10);

        new Stairs(this, 290, -6, false);
        new Ground(this, 305, -2);
        new Stairs(this, 320, -6, true);

        new Ground(this, 355, -10);
        new Ground(this, 390, -10);

        new Stairs(this, 425, -6, false);
        new Ground(this, 440, -2);
        new Stairs(this, 455, -6, true);

        new Ground(this, 490, -10);
    }

    private void createPlayer() {
        player = new Player(this);
        player.setPosition(new Vec2(10, 5));
        player.setGravityScale(5);
        player.addCollisionListener(this);
    }

    public void enableKeyboardControls() {
        playerController = new PlayerController(player);
        gameView.addKeyListener(playerController);
    }

    public void enableEnemyCreation() {
        timer = new Timer(1000, this);
        timer.setInitialDelay(0);
        timer.start();
    }
    public void disableEnemyCreation() {
        timer.stop();
    }

    public void collide(CollisionEvent ce) {
        Vec2 playerPosition = player.getPosition();
        Body otherBody = ce.getOtherBody();
        Vec2 otherPosition = otherBody.getPosition();

        if (otherBody instanceof Ground && playerPosition.y < otherPosition.y + 5) {
            player.setPosition(new Vec2(playerPosition.x, playerPosition.y + 5));
        }
        else if (otherBody instanceof Enemy && playerController.isAttacking()) {
            otherBody.destroy();
            gameView.updateScore();
        }
        else if (otherBody instanceof Spike || otherBody instanceof Enemy) {
            EventHandler.endGame();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // create new enemy every 1 second
        int enemyType = rand.nextInt(3);
        Enemy enemy;

        if (enemyType == 0) {
            enemy = new Demon(this);
        }
        else if (enemyType == 1) {
            enemy = new Ghost(this);
        }
        else {
            enemy = new Skeleton(this);
        }
        enemy.setPosition(new Vec2(rand.nextInt(480) + 10,
                rand.nextInt(50)));
    }
}
