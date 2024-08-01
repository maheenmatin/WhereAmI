package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Skeleton extends Enemy {
    private static final BodyImage imageLeft =
            new BodyImage("data/Characters/Enemies/skeleton-left.gif", 10f);

    private static final Shape shapeLeft = new PolygonShape
            (-2.99f,-1.06f, -1.83f,2.1f, -1.07f,3.68f,
                    -0.31f,3.66f, 2.21f,0.3f, 2.67f,-4.92f, -0.99f,-4.9f);

    private static final BodyImage imageRight =
            new BodyImage("data/Characters/Enemies/skeleton-right.gif", 10f);

    private static final Shape shapeRight = new PolygonShape
            (-2.93f,-4.94f, -2.37f,0.34f, 0.25f,3.52f, 1.13f,3.62f,
                    1.75f,2.64f, 2.89f,-1.16f, 1.09f,-4.98f);

    private SolidFixture fixture;

    public Skeleton(World world) {
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
        if (getPosition().y < -3) {
            setPosition(new Vec2(getPosition().x, -3));
        }
    }
}