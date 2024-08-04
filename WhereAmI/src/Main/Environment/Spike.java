package Main.Environment;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Spike extends StaticBody {
    private static final BodyImage image = new BodyImage(
            "data/Objects/spikes100.png", 2);
    private static final int width = 100;
    private static final Shape shape = new BoxShape(width/2f, 1);
    private static int posX;
    private static int posY;

    public Spike(World world) {
        super(world, shape);
        addImage(image);
        this.setPosition(new Vec2(posX, posY));
        posX += width;
    }

    // reinitialize coordinates before creating new game world
    public static void reinitialize() {
        posX = 0;
        posY = -80;
    }
}
