package MainGame;

import MainGame.Characters.*;
import MainGame.Controllers.PlayerController;
import MainGame.Environment.*;
import MainGame.Handlers.EventHandler;
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
    private final int endX;

    public GameWorld(GameView gameView) {
        this.gameView = gameView;
        this.endX = new Platform(this, 2).getEndX() - 50; // create environment
        createPlayer();
        enableKeyboardControls();
        enableEnemyCreation();
    }

    public Timer getTimer() {
        return timer;
    }

    public Player getPlayer() {
        return player;
    }

    private void createPlayer() {
        player = new Player(this);
        player.addCollisionListener(this);
    }

    public void enableKeyboardControls() {
        playerController = new PlayerController(player);
        gameView.addKeyListener(playerController);
        EventHandler.setPlayerController(playerController);
    }

    public void enableEnemyCreation() {
        timer = new Timer(500, this);
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
        else if (otherBody instanceof Enemy) {
            if (!((Enemy) otherBody).isDead()) { // if enemy is not dead
                if (playerController.isAttacking()) {
                    ((Enemy) otherBody).animateDeath();
                    gameView.updateScore();
                }
                else {
                    EventHandler.endGame();
                }
            }
        }
        else if (otherBody instanceof Spike) {
            EventHandler.endGame();
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // create new enemy every 0.5 seconds
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
        enemy.setPosition(new Vec2(rand.nextInt(endX), rand.nextInt(50)));
    }
}
