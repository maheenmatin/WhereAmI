package Prologue;

import city.cs.engine.UserView;
import city.cs.engine.World;
import java.awt.*;

public class GameView extends UserView {
    private Image prologueImage;

    public GameView(World world, int width, int height) {
        super(world, width, height);
    }

    public void setPrologueImage(Image prologueImage) {
        this.prologueImage = prologueImage;
    }

    @Override
    protected void paintBackground(Graphics2D graphics2D) {
        graphics2D.drawImage(prologueImage, 0, 0, this);
    }
}
