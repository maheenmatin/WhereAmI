package Prologue.Environment;

import Master.Utility.Invisible;
import city.cs.engine.BoxShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

public class Checkpoint extends StaticBody {

    public Checkpoint(World world) {
        super(world, new BoxShape(0.01f,10));
        Invisible.makeInvisible(this);
    }
}
