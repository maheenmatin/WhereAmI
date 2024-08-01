package Main;

import city.cs.engine.*;
import city.cs.engine.Shape;
import org.jbox2d.common.Vec2;

public class Spike extends Environment{
    private static final BodyImage image = new BodyImage("data/Objects/spikes100.png", 2);
    private static final int width = 100;
    private static final Shape shape = new BoxShape(width/2f, 1);

    //these values are saved when the game restarts, so initialize using method
    private static int posX;
    private static int posY;

    public Spike(World w) {
        super(w, shape);
        addImage(image);

        //this.setLineColor(Color.white);
        //this.setAlwaysOutline(true);

        this.setPosition(new Vec2(posX, posY));
        posX = posX + width;
    }

    public static void initialize() {
        posX = 0;
        posY = -80;
    }

    @Override
    public Vec2 getPosition() {
        return super.getPosition();
    }
}