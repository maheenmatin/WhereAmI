package Main;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class GameView extends UserView {
    private static Image background = new ImageIcon("data/Backgrounds/mainlevel.png").getImage();
    private static Image backgroundEnd = new ImageIcon("data/Backgrounds/blank.jpg").getImage();
    private static Image foreground = new ImageIcon("data/Backgrounds/mainlevel.png").getImage();

    private static Font font = new Font("Monospaced", Font.PLAIN, 20);
    private static Font fontEnd = new Font("Monospaced", Font.PLAIN, 40);

    private int time = 60;
    private int score = 0;
    private int highScore = 0;

    private boolean activeGame = true;

    public GameView(World w, int width, int height) {
        super(w, width, height);
    }

    public void setTime(int i) {
        time = i;
    }

    public int getTime() {
        return time;
    }

    public void setScore(int i) {
        score = i;
    }

    public int getScore() {
        return score;
    }

    @Override
    protected void paintBackground(Graphics2D g) {
        if (activeGame) {
            g.drawImage(background, 0, 0, this);
        } else {
            g.drawImage(backgroundEnd, 0, 0, this);
        }
    }

    @Override
    protected void paintForeground(Graphics2D g) {
        if (activeGame) {
            g.setColor(new Color(200, 150, 150));
            g.setFont(font);
            g.drawString("TIME  " + time, 10, 25);
            g.drawString("SCORE " + score, 10, 50);
        } else {
            g.setColor(new Color(255, 255, 255));
            g.setFont(font);
            g.drawString("FINAL SCORE " + score, 315, 200);
            g.drawString("HIGH  SCORE " + highScore, 315, 225);

            g.drawString("PRESS R TO RESTART", 290, 350);
            g.setFont(fontEnd);
            g.drawString("GAME OVER", 285, 150);
        }
    }

    public void setActiveGame(boolean bool) {
        activeGame = bool;
    }

    public void setHighScore (int i) {
        highScore = i;
    }
}