package Prologue;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image image;
    private Image initial = new ImageIcon("data/Backgrounds/blankWhere.jpg").getImage();

    public GameView(World w, int width, int height) {
        super(w, width, height);
        image = initial;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(image, 0, 0, this);
    }

    public void setImage(Image image) {
        this.image = image;
    }
}