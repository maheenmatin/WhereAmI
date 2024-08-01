package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Ghost extends Enemy {
    private static final BodyImage imageLeft =
            new BodyImage("data/Characters/Enemies/ghost-left.gif", 30f);

    private static final Shape shapeLeft = new PolygonShape
            (-1.1f,-2.2f, 0.3f,-1.8f, 2.3f,-6.8f, 0.2f,-9.6f, -2.3f,-7.2f, -1.6f,-2.6f);

    private static final BodyImage imageRight =
            new BodyImage("data/Characters/Enemies/ghost-right.gif", 30f);

    private static final Shape shapeRight = new PolygonShape
            (0.2f,-9.9f, 2.4f,-6.6f, 1.1f,-1.8f, -0.6f,-2.3f, -2.4f,-6.1f);

    private SolidFixture fixture;

    public Ghost(World world) {
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
        if (getPosition().y < 2) {
            setPosition(new Vec2(getPosition().x, 2));
        }
    }
}