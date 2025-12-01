package Prologue.Characters;

import city.cs.engine.*;

public class Player extends Walker {
    private SolidFixture solidFixture;
    private static final Shape idleShape = new PolygonShape(
            -0.19f, 3.58f, 1.31f, 2.9f, 1.39f, -5.0f, -0.61f, -5.0f, -1.17f,
            -1.62f, -1.35f, 1.6f);
    private static final Shape walkShape = new PolygonShape(
            1.61f, 0.24f, 1.71f, -4.86f, -1.43f, -4.86f, -1.47f, 1.64f, -0.83f,
            3.62f, 1.33f, 3.1f);

    private static final BodyImage idleImage =
            new BodyImage("data/Characters/Prologue/hat-man-idle.gif", 10f);
    private static final BodyImage walkImage =
            new BodyImage("data/Characters/Prologue/hat-man-walk.gif", 10f);

    public Player(World world) {
        super(world);
        solidFixture = new SolidFixture(this, idleShape);
        addImage(idleImage);
    }

    public void startWalk() {
        solidFixture.destroy();
        solidFixture = new SolidFixture(this, walkShape);
        removeAllImages();
        addImage(walkImage);
    }

    public void stopWalk() {
        solidFixture.destroy();
        solidFixture = new SolidFixture(this, idleShape);
        removeAllImages();
        addImage(idleImage);
    }
}
