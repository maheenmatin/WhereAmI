package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public abstract class Environment extends StaticBody{

    public Environment(World w, Shape shape) {
        super(w, shape);
        //setLineColor(Color.white);
        //setAlwaysOutline(true);
    }

    @Override
    public Vec2 getPosition() {
        return super.getPosition();
    }
}