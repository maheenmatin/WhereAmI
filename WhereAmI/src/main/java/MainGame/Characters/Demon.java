package MainGame.Characters;

import city.cs.engine.*;

public class Demon extends Enemy {
    public Demon(World world) {
        super(world);
    }

    @Override
    public void initialize() {
        leftShape = new PolygonShape(-2.44f, 3.55f, 2.24f, 3.89f, 4.57f, -0.53f,
                -0.9f, -3.35f, -2.97f, -2.48f, -4.16f, 0.05f);
        rightShape = new PolygonShape(-2.24f, 3.87f, 2.44f, 3.57f, 4.19f, 0.03f,
                2.07f, -3.12f, -0.32f, -3.12f, -4.45f, 0.03f);
        leftImage = new BodyImage(
                "data/Characters/Enemies/demon-left.gif", 10f);
        rightImage = new BodyImage(
                "data/Characters/Enemies/demon-right.gif", 10f);
        yLimit = -5;
    }
}
