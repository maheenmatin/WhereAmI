package MainGame.Characters;

import city.cs.engine.*;

public class Skeleton extends Enemy {
    public Skeleton(World world) {
        super(world);
    }

    @Override
    public void initialize() {
        leftShape = new PolygonShape(-2.99f, -1.06f, -1.83f, 2.1f, -1.07f, 3.68f,
                -0.31f, 3.66f, 2.21f, 0.3f, 2.67f, -4.92f, -0.99f, -4.9f);
        rightShape = new PolygonShape(-2.93f, -4.94f, -2.37f, 0.34f, 0.25f, 3.52f,
                1.13f, 3.62f, 1.75f, 2.64f, 2.89f, -1.16f, 1.09f, -4.98f);
        leftImage = new BodyImage(
                "data/Characters/Enemies/skeleton-left.gif", 10f);
        rightImage = new BodyImage(
                "data/Characters/Enemies/skeleton-right.gif", 10f);
        yLimit = -3;
    }
}
