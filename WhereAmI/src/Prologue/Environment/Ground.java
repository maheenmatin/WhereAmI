package Prologue.Environment;

import Master.Utility.Invisible;
import city.cs.engine.*;

public class Ground extends StaticBody {

    public Ground(World world, float halfWidth) {
        super(world, new BoxShape(halfWidth, 0.1f));
        Invisible.makeInvisible(this);
    }
}
