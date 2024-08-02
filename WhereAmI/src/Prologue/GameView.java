package Prologue;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.*;

public class GameView extends UserView {
    private Image image;

    public GameView(World world, int width, int height) {
        super(world, width, height);
    }

    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    protected void paintBackground(Graphics2D graphics2D) {
        graphics2D.drawImage(image, 0, 0, this);
    }
}
