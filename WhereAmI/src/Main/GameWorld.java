package Main;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class GameWorld extends World implements CollisionListener, ActionListener {

    private Hero hero;
    private Enemy enemy;

    private Timer timer;
    private Random rand = new Random();

    public Hero getHero() {
        return hero;
    }

    public Vec2 getHeroPos() {
        return hero.getPosition();
    }

    public void timerStop() {
        timer.stop();
    }

    public GameWorld() {
        //make the invisible walls at the start and end
        Wall wallStart = new Wall(this);
        wallStart.setPosition(new Vec2(0, 25));

        Wall wallEnd = new Wall(this);
        wallEnd.setPosition(new Vec2(500, 25));

        //make the spikes
        Spike.initialize();
        Spike spike1 = new Spike(this);
        Spike spike2 = new Spike(this);
        Spike spike3 = new Spike(this);
        Spike spike4 = new Spike(this);
        Spike spike5 = new Spike(this);
        Spike spike6 = new Spike(this);


        //make the ground
        Ground ground1 = new Ground(this);
        ground1.setPosition(new Vec2(10, -10));
        Ground ground2 = new Ground(this);
        ground2.setPosition(new Vec2(30, -10));

        Ground ground3 = new Ground(this);
        ground3.setPosition(new Vec2(70, -10));

        Stairs stairsUp = new Stairs(this);
        stairsUp.setPosition(new Vec2(105, -6));
        Ground stairsFlatFirst = new Ground(this);
        stairsFlatFirst.setPosition(new Vec2(120, -2));
        Ground stairsFlatSecond = new Ground(this);
        stairsFlatSecond.setPosition(new Vec2(140, -2));
        Stairs stairsDown = new Stairs(this, "");
        stairsDown.setPosition(new Vec2(155, -6));

        Ground ground4 = new Ground(this);
        ground4.setPosition(new Vec2(190, -10));
        Ground ground5 = new Ground(this);
        ground5.setPosition(new Vec2(235, -10));

        Ground ground6 = new Ground(this);
        ground6.setPosition(new Vec2(255, -10));

        Stairs stairsUp2 = new Stairs(this);
        stairsUp2.setPosition(new Vec2(290, -6));
        Ground stairsFlat2 = new Ground(this);
        stairsFlat2.setPosition(new Vec2(305, -2));
        Stairs stairsDown2 = new Stairs(this, "");
        stairsDown2.setPosition(new Vec2(320, -6));

        Ground ground7 = new Ground(this);
        ground7.setPosition(new Vec2(355, -10));

        Ground ground8 = new Ground(this);
        ground8.setPosition(new Vec2(390, -10));

        Stairs stairsUp3 = new Stairs(this);
        stairsUp3.setPosition(new Vec2(425, -6));
        Ground stairsFlat3 = new Ground(this);
        stairsFlat3.setPosition(new Vec2(440, -2));
        Stairs stairsDown3 = new Stairs(this, "");
        stairsDown3.setPosition(new Vec2(455, -6));

        Ground ground9 = new Ground(this);
        ground9.setPosition(new Vec2(490, -10));


        //make the hero
        hero = new Hero(this);
        hero.setPosition(new Vec2(10, 5));
        hero.setGravityScale(5);

        //add collision listener to hero
        hero.addCollisionListener(this);


        //make the demon
        Demon demon = new Demon(this);
        demon.setPosition(new Vec2(50, 40));

        //start timer
        timer = new Timer(1000, this);
        timer.setInitialDelay(1000);
        timer.start();
    }

    public void collide(CollisionEvent e) {
        Vec2 heroPosition = hero.getPosition();
        Body otherBody = e.getOtherBody();
        Vec2 otherPosition = otherBody.getPosition();

        if (otherBody instanceof Ground && heroPosition.y < otherPosition.y + 5) {
            hero.setPosition(new Vec2(heroPosition.x, heroPosition.y + 5));
        } else if (e.getOtherBody() instanceof Spike) {
            EventHandler.callEnd();
        } else if (e.getOtherBody() instanceof Enemy && !HeroController.getAttack()) {
            EventHandler.callEnd();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //make new enemy every 2 seconds
        int randomEnemy = rand.nextInt(3);

        if (randomEnemy == 0) {
            enemy = new Demon(this);
        } else if (randomEnemy == 1) {
            enemy = new Ghost(this);
        } else {
            enemy = new Skeleton(this);
        }

        int randomPosX = rand.nextInt(500);
        int randomPosY = rand.nextInt(50);
        enemy.setPosition(new Vec2(randomPosX, randomPosY));
    }
}