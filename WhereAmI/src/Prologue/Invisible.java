package Prologue;

import city.cs.engine.Body;

import java.awt.*;

public class Invisible {
    private static final Color invisible = new Color(00,00,00,00);

    public static void makeInvisible(Body body) {
        body.setFillColor(invisible);
        body.setLineColor(invisible);
        //body.setLineColor(Color.white);
        body.setAlwaysOutline(false);
    }
}