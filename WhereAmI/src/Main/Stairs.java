package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;

public class Stairs extends StaticBody {
    private static final Shape leftShape =
            new PolygonShape(-5.0f, -5.0f, 4.98f, -4.98f, 4.98f, 5.0f,
                    -4.96f, -4.92f);
    private static final Shape rightShape =
            new PolygonShape(-4.98f, 4.98f, 4.98f, -4.98f, -4.98f, -5.0f,
                    -5.0f, 4.76f);

    private static final BodyImage leftImage = new BodyImage(
            "data/Objects/stairs-left.png", 10);
    private static final BodyImage rightImage = new BodyImage(
            "data/Objects/stairs-right.png", 10);

    public Stairs(World world) {
        super(world, leftShape);
        addImage(leftImage);
    }

    public Stairs(World world, Boolean reverse) {
        super(world, reverse ? rightShape : leftShape);
        addImage(reverse ? rightImage : leftImage);
    }
}
