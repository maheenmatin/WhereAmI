package Main.Environment;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Ground extends StaticBody {
    private static final BodyImage image = new BodyImage(
            "data/Objects/damaged20.png", 2);
    private static final Shape shape = new BoxShape(10, 1);

    public Ground(World world, float x, float y) {
        super(world, shape);
        addImage(image);
        this.setPosition(new Vec2(x, y));
    }
}
