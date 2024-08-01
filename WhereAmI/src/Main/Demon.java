package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Demon extends Enemy {
    private static final BodyImage imageLeft =
            new BodyImage("data/Characters/Enemies/demon-left.gif", 10f);

    private static final Shape shapeLeft = new PolygonShape
            (-2.44f, 3.55f, 2.24f, 3.89f, 4.57f, -0.53f, -0.9f, -3.35f, -2.97f, -2.48f, -4.16f, 0.05f);

    private static final BodyImage imageRight =
            new BodyImage("data/Characters/Enemies/demon-right.gif", 10f);

    private static final Shape shapeRight = new PolygonShape
            (-2.24f, 3.87f, 2.44f, 3.57f, 4.19f, 0.03f, 2.07f, -3.12f, -0.32f, -3.12f, -4.45f, 0.03f);

    private SolidFixture fixture;

    public Demon(World world) {
        super(world);
    }


    @Override
    public void giveShapeRight() {
        fixture = new SolidFixture(this, shapeRight);
    }

    @Override
    public void giveImageRight() {
        addImage(imageRight);
    }

    @Override
    public void giveShapeLeft() {
        fixture = new SolidFixture(this, shapeLeft);
    }

    @Override
    public void giveImageLeft() {
        addImage(imageLeft);
    }

    @Override
    public void preStep(StepEvent stepEvent) {
        if (getPosition().y < -5) {
            setPosition(new Vec2(getPosition().x, -5));
        }
    }
}