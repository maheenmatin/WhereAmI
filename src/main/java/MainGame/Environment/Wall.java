package MainGame.Environment;

import Master.Utility.Invisible;
import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Wall extends StaticBody {
    private static final Shape shape = new BoxShape(1, 50);

    public Wall(World world, float x, float y) {
        super(world, shape);
        this.setPosition(new Vec2(x, y));
        Invisible.makeInvisible(this);
    }
}
