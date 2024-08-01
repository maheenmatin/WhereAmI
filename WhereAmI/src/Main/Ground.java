package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Ground extends Environment{
    private static final BodyImage image = new BodyImage("data/Objects/damaged20.png", 2);
    private static final int width = 20;
    private static final Shape shape = new BoxShape(width/2f, 1);

    public Ground(World w) {
        super(w, shape);
        addImage(image);
    }

    @Override
    public Vec2 getPosition() {
        return super.getPosition();
    }
}