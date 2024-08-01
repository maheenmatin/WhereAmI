package Prologue;

import city.cs.engine.*;

public class Professor extends Walker {
    private static final Shape professorShape = new PolygonShape(
            0.24f,3.82f,
            -1.04f,3.3f,
            -2.4f,-3.0f,
            -1.66f,-4.98f,
            1.36f,-5.0f,
            2.38f,-4.06f,
            1.26f,3.68f);

    private static final BodyImage image =
            new BodyImage("data/Characters/Prologue/woman-idle.gif", 10f);

    public Professor(World world) {
        super(world, professorShape);
        addImage(image);
        //setAlwaysOutline(true);
    }
}