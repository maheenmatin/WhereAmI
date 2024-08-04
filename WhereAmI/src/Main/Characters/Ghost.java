package Main.Characters;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class Ghost extends Enemy {
    public Ghost(World world) {
        super(world);
    }

    @Override
    public void initialize() {
        leftShape = new PolygonShape(-1.1f, -2.2f, 0.3f, -1.8f, 2.3f, -6.8f, 0.2f,
                -9.6f, -2.3f, -7.2f, -1.6f, -2.6f);
        rightShape = new PolygonShape(0.2f, -9.9f, 2.4f, -6.6f, 1.1f, -1.8f, -0.6f,
                -2.3f, -2.4f, -6.1f);
        leftImage = new BodyImage(
                "data/Characters/Enemies/ghost-left.gif", 30f);
        rightImage = new BodyImage(
                "data/Characters/Enemies/ghost-right.gif", 30f);
    }

    @Override
    public void preStep(StepEvent se) {
        if (getPosition().y < 2) {
            setPosition(new Vec2(getPosition().x, 2));
        }
    }
}
