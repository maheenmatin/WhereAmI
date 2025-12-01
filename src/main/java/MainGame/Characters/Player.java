package MainGame.Characters;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Player extends Walker {
    private Fixture fixture;
    private static final Shape leftIdleShape = new PolygonShape
            (-1.8f, 2.56f, -2.68f, 1.54f, -3.08f, -2.39f, -1.8f, -4.93f,
                    2.24f, -5.0f, 6.27f, -4.86f, 0.75f, 2.22f);
    private static final Shape rightIdleShape = new PolygonShape
            (-6.47f, -4.69f, -0.92f, 2.22f, 1.59f, 2.66f, 2.75f, 1.51f,
                    3.02f, -2.53f, 1.9f, -4.97f, -2.2f, -5.0f);
    private static final Shape leftWalkShape = new PolygonShape
            (-2.34f, 1.71f, -3.22f, -1.0f, -2.58f, -5.0f, 2.64f, -5.0f,
                    6.95f, -4.25f, 2.71f, -0.22f, -1.22f, 1.85f);
    private static final Shape rightWalkShape = new PolygonShape
            (-6.98f, -4.32f, -2.61f, -5.0f, 2.64f, -5.0f, 3.02f, -1.03f,
                    2.24f, 1.71f, 1.08f, 1.92f, -3.8f, -0.66f, -6.95f, -3.98f);
    private static final Shape leftAttackShape = new PolygonShape
            (-7.93f, -0.73f, -1.83f, -5.03f, 3.9f, -5.0f, 4.1f, -4.12f,
                    0.71f, 0.76f, -1.76f, 1.31f);
    private static final Shape rightAttackShape = new PolygonShape
            (-4.03f, -5.0f, 1.9f, -5.0f, 7.97f, -0.69f, 1.97f, 1.31f,
                    -0.95f, 0.76f, -4.14f, -3.88f);

    private static final BodyImage leftIdleImage =
            new BodyImage("data/Characters/Swordsman/idle-left.gif", 10f);
    private static final BodyImage rightIdleImage =
            new BodyImage("data/Characters/Swordsman/idle-right.gif", 10f);
    private static final BodyImage leftRunImage =
            new BodyImage("data/Characters/Swordsman/run-left.gif", 10f);
    private static final BodyImage rightRunImage =
            new BodyImage("data/Characters/Swordsman/run-right.gif", 10f);
    private static final BodyImage leftAttackImage =
            new BodyImage("data/Characters/Swordsman/attack-left.gif", 10f);
    private static final BodyImage rightAttackImage =
            new BodyImage("data/Characters/Swordsman/attack-right.gif", 10f);
    private static final BodyImage deathImage =
            new BodyImage("data/Characters/Swordsman/hero-hurt.png", 10f);

    public Player(World world) {
        super(world);
        initialize();
        setGravityScale(10);
    }

    public void initialize() {
        if (fixture != null) {
            fixture.destroy();
        }
        fixture = new SolidFixture(this, rightIdleShape);
        removeAllImages();
        addImage(rightIdleImage);
        setPosition(new Vec2(0, 5));
    }

    public void simulateDeath() {
        stopWalking();
        fixture.destroy();
        fixture = new SolidFixture(this, rightIdleShape);
        removeAllImages();
        addImage(deathImage);
    }

    public void startWalkLeft() {
        fixture.destroy();
        fixture = new SolidFixture(this, leftWalkShape);
        removeAllImages();
        addImage(leftRunImage);
    }

    public void startWalkRight() {
        fixture.destroy();
        fixture = new SolidFixture(this, rightWalkShape);
        removeAllImages();
        addImage(rightRunImage);
    }

    public void stopWalkLeft() {
        fixture.destroy();
        fixture = new SolidFixture(this, leftIdleShape);
        removeAllImages();
        addImage(leftIdleImage);
    }

    public void stopWalkRight() {
        fixture.destroy();
        fixture = new SolidFixture(this, rightIdleShape);
        removeAllImages();
        addImage(rightIdleImage);
    }

    public void attackLeft() {
        fixture.destroy();
        fixture = new SolidFixture(this, leftAttackShape);
        removeAllImages();
        addImage(leftAttackImage);
    }

    public void attackRight() {
        fixture.destroy();
        fixture = new SolidFixture(this, rightAttackShape);
        removeAllImages();
        addImage(rightAttackImage);
    }
}
