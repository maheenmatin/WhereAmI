package MainGame.Environment;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Ground extends StaticBody {
    private static final Shape shape = new BoxShape(10, 1);
    private static final BodyImage image = new BodyImage(
            "data/Objects/damaged20.png", 2);

    public Ground(World world, float x, float y) {
        super(world, shape);
        addImage(image);
        this.setPosition(new Vec2(x, y));
    }
}
