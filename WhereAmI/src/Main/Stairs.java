package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Stairs extends Environment{
    private static final BodyImage left = new BodyImage("data/Objects/stairs-left.png", 10);
    private static final BodyImage right = new BodyImage("data/Objects/stairs-right.png", 10);
    private static final Shape shapeLeft =
            new PolygonShape(-5.0f,-5.0f, 4.98f,-4.98f, 4.98f,5.0f, -4.96f,-4.92f);
    private static final Shape shapeRight =
            new PolygonShape(-4.98f,4.98f, 4.98f,-4.98f, -4.98f,-5.0f, -5.0f,4.76f);

    public Stairs(World w) {
        super(w, shapeLeft);
        addImage(left);
    }

    public Stairs(World w, String s) {
        super(w, shapeRight);
        addImage(right);
    }

    @Override
    public Vec2 getPosition() {
        return super.getPosition();
    }
}