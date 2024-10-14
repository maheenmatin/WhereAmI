package Master;

import MainGame.Controllers.RestartController;
import city.cs.engine.UserView;
import city.cs.engine.World;
import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private Image prologueImage;
    private static final Image mainImage = new ImageIcon(
            "data/Backgrounds/Main/mainLevel.png").getImage();
    private static final Image endImage = new ImageIcon(
            "data/Backgrounds/Main/blank.jpg").getImage();
    private static final Font font = new Font("Monospaced", Font.PLAIN, 20);
    private static final Font fontEnd = new Font("Monospaced", Font.PLAIN, 40);

    private int time = 60;
    private int score = 0;
    private int highScore = 0;
    private boolean prologue = true;
    private boolean activeMain = true;
    private final RestartController restartController;

    public GameView(World world, int width, int height) {
        super(world, width, height);
        this.restartController = new RestartController();
        this.addKeyListener(restartController);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setPrologueImage(Image prologueImage) {
        this.prologueImage = prologueImage;
    }

    public void setPrologue(boolean prologue) {
        this.prologue = prologue;
    }

    public void updateScore() {
        score++;
    }

    public void callGameOver() {
        if (score > highScore) {
            highScore = score;
        }
        activeMain = false;
        restartController.setEnabled(true);
    }

    public void resetGraphics() {
        time = 60;
        score = 0;
        activeMain = true;
        restartController.setEnabled(false);
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (prologue) {
            g.drawImage(prologueImage, 0, 0, this);
        }
        else if (activeMain) {
            g.drawImage(mainImage, 0, 0, this);
        }
        else {
            g.drawImage(endImage, 0, 0, this);
        }
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        if (!prologue && activeMain) {
            g.setColor(new Color(200, 150, 150));
            g.setFont(font);
            g.drawString("TIME  " + time, 10, 25);
            g.drawString("SCORE " + score, 10, 50);
        }
        else if (!prologue) {
            g.setColor(new Color(255, 255, 255));
            g.setFont(fontEnd);
            g.drawString("GAME OVER", 285, 150);
            g.setFont(font);
            g.drawString("FINAL SCORE " + score, 315, 200);
            g.drawString("HIGH  SCORE " + highScore, 315, 225);
            g.drawString("PRESS R TO RESTART", 290, 275);
        }
    }
}
