package Prologue.Characters;

import city.cs.engine.*;

public class Swordsman extends Walker {
    private static final Shape shape = new PolygonShape
            (-6.47f, -4.69f, -0.92f, 2.22f, 1.59f, 2.66f, 2.75f, 1.51f,
                    3.02f, -2.53f, 1.9f, -4.97f, -2.2f, -5.0f);
    private static final BodyImage image =
            new BodyImage("data/Characters/Swordsman/idle-right.gif", 10f);

    public Swordsman(World world) {
        super(world);
        new SolidFixture(this, shape);
        addImage(image);
    }
}
