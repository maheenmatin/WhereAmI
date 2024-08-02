package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;

import java.awt.*;

public class Wall extends StaticBody {
    private static final Shape shape = new BoxShape(1, 50);
    private static final Color invisible = new Color(00, 00, 00, 00);

    public Wall(World w) {
        super(w, shape);
        setFillColor(invisible);
        setLineColor(invisible);
    }
}
