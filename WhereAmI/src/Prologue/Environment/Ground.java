package Prologue.Environment;

import Master.Invisible;
import city.cs.engine.*;

public class Ground extends StaticBody {
    public Ground(World world, float halfWidth, boolean invisible) {
        super(world, new BoxShape(halfWidth, 0.1f));

        if (invisible) {
            Invisible.makeInvisible(this);
        }
    }
}
