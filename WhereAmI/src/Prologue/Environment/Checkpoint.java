package Prologue.Environment;

import Master.Invisible;
import city.cs.engine.BoxShape;
import city.cs.engine.Shape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class Checkpoint extends StaticBody {
    private static final Shape shape = new BoxShape(0.01f,10);

    public Checkpoint(World world, boolean invisible) {
        super(world, shape);

        if (invisible) {
            Invisible.makeInvisible(this);
        }
    }
}
