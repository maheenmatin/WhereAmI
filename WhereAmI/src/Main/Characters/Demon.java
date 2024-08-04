package Main.Characters;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Demon extends Enemy {
    private SolidFixture fixture;

    private static final Shape leftShape = new PolygonShape
            (-2.44f, 3.55f, 2.24f, 3.89f, 4.57f, -0.53f, -0.9f, -3.35f, -2.97f,
                    -2.48f, -4.16f, 0.05f);
    private static final Shape rightShape = new PolygonShape
            (-2.24f, 3.87f, 2.44f, 3.57f, 4.19f, 0.03f, 2.07f, -3.12f, -0.32f,
                    -3.12f, -4.45f, 0.03f);

    private static final BodyImage leftImage =
            new BodyImage("data/Characters/Enemies/demon-left.gif", 10f);
    private static final BodyImage rightImage =
            new BodyImage("data/Characters/Enemies/demon-right.gif", 10f);

    public Demon(World world) {
        super(world);
    }

    @Override
    public void assignShapeLeft() {
        fixture = new SolidFixture(this, leftShape);
    }
    @Override
    public void assignShapeRight() {
        fixture = new SolidFixture(this, rightShape);
    }
    @Override
    public void assignImageLeft() {
        addImage(leftImage);
    }
    @Override
    public void assignImageRight() {
        addImage(rightImage);
    }

    @Override
    public void preStep(StepEvent se) {
        if (getPosition().y < -5) {
            setPosition(new Vec2(getPosition().x, -5));
        }
    }
}
