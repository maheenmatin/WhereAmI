package Main;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameWorld extends World implements CollisionListener, ActionListener {
    private final Player player;
    private final Timer timer;
    private final Random rand = new Random();
    private PlayerController playerController;

    public GameWorld() {
        // create invisible walls at start and end
        Wall wallStart = new Wall(this);
        Wall wallEnd = new Wall(this);
        wallStart.setPosition(new Vec2(0, 25));
        wallEnd.setPosition(new Vec2(500, 25));

        // create spikes
        Spike.initialize();
        for (int i = 0; i < 6; i++) {
            new Spike(this);
        }

        // create the ground
        Ground ground1 = new Ground(this);
        Ground ground2 = new Ground(this);
        Ground ground3 = new Ground(this);
        ground1.setPosition(new Vec2(10, -10));
        ground2.setPosition(new Vec2(30, -10));
        ground3.setPosition(new Vec2(70, -10));

        Stairs stairsUp = new Stairs(this);
        Ground stairsFlatFirst = new Ground(this);
        Ground stairsFlatSecond = new Ground(this);
        Stairs stairsDown = new Stairs(this, true);
        stairsUp.setPosition(new Vec2(105, -6));
        stairsFlatFirst.setPosition(new Vec2(120, -2));
        stairsFlatSecond.setPosition(new Vec2(140, -2));
        stairsDown.setPosition(new Vec2(155, -6));

        Ground ground4 = new Ground(this);
        Ground ground5 = new Ground(this);
        Ground ground6 = new Ground(this);
        ground4.setPosition(new Vec2(190, -10));
        ground5.setPosition(new Vec2(235, -10));
        ground6.setPosition(new Vec2(255, -10));

        Stairs stairsUp2 = new Stairs(this);
        Ground stairsFlat2 = new Ground(this);
        Stairs stairsDown2 = new Stairs(this, true);
        stairsUp2.setPosition(new Vec2(290, -6));
        stairsFlat2.setPosition(new Vec2(305, -2));
        stairsDown2.setPosition(new Vec2(320, -6));

        Ground ground7 = new Ground(this);
        Ground ground8 = new Ground(this);
        ground7.setPosition(new Vec2(355, -10));
        ground8.setPosition(new Vec2(390, -10));

        Stairs stairsUp3 = new Stairs(this);
        Ground stairsFlat3 = new Ground(this);
        Stairs stairsDown3 = new Stairs(this, true);
        stairsUp3.setPosition(new Vec2(425, -6));
        stairsFlat3.setPosition(new Vec2(440, -2));
        stairsDown3.setPosition(new Vec2(455, -6));

        Ground ground9 = new Ground(this);
        ground9.setPosition(new Vec2(490, -10));

        // create the hero
        player = new Player(this);
        player.setPosition(new Vec2(10, 5));
        player.setGravityScale(5);
        player.addCollisionListener(this);

        // create a demon
        Demon demon = new Demon(this);
        demon.setPosition(new Vec2(50, 40));

        timer = new Timer(1000, this);
        timer.setInitialDelay(1000);
        timer.start();
    }

    public Player getPlayer() {
        return player;
    }

    public void stopTimer() {
        timer.stop();
    }

    public void collide(CollisionEvent e) {
        Vec2 heroPosition = player.getPosition();
        Body otherBody = e.getOtherBody();
        Vec2 otherPosition = otherBody.getPosition();

        if (otherBody instanceof Ground && heroPosition.y < otherPosition.y + 5) {
            player.setPosition(new Vec2(heroPosition.x, heroPosition.y + 5));
        }
        else if (otherBody instanceof Enemy && playerController.isAttacking()) {
            otherBody.destroy();
            EventHandler.updateScore();
        }
        else if (otherBody instanceof Spike || otherBody instanceof Enemy) {
            EventHandler.callEnd();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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
        enemy.setPosition(new Vec2(rand.nextInt(500), rand.nextInt(50)));
    }

    public void enableKeyboardControls(GameView gameView) {
        playerController = new PlayerController(player);
        gameView.addKeyListener(playerController);
    }
}
