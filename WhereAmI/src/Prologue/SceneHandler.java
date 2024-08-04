package Prologue;

import Master.GameAudio;
import Master.Master;
import Master.GameView;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneHandler implements ActionListener {
    private static final Image initial = new ImageIcon(
            "data/Backgrounds/blankWhere.jpg").getImage();
    private static final Image press = new ImageIcon(
            "data/Backgrounds/moonPress.png").getImage();
    private static final Image why = new ImageIcon(
            "data/Backgrounds/why.png").getImage();
    private static final Image letMe = new ImageIcon(
            "data/Backgrounds/letMe.png").getImage();
    private static final Image needToBe = new ImageIcon(
            "data/Backgrounds/needToBe.png").getImage();
    private static final Image blank = new ImageIcon(
            "data/Backgrounds/blank.jpg").getImage();
    private static final Image youCan = new ImageIcon(
            "data/Backgrounds/blankYouCan.jpg").getImage();
    private static final Image see = new ImageIcon(
            "data/Backgrounds/blankSee.jpg").getImage();

    private final GameView gameView;
    private final GameWorld gameWorld;
    private final Timer timer;
    private int scene = 0;

    public SceneHandler(GameView gameView, GameWorld gameWorld) {
        this.gameView = gameView;
        this.gameWorld = gameWorld;
        timer = new Timer(4500, this);
        timer.setInitialDelay(3900);

        timer.start();
        callNextScene();
    }

    public int getScene() {
        return scene;
    }

    public void callNextScene() {
        switch (++scene) {
            case 1 -> gameView.setPrologueImage(initial);
            case 2 -> {
                gameWorld.enableKeyboardControls(gameView);
                timer.stop();
                gameView.setPrologueImage(press);
            }
            case 3 -> gameView.setPrologueImage(why);
            case 4 -> gameView.setPrologueImage(letMe);
            case 5 -> gameView.setPrologueImage(needToBe);
            case 6, 7 -> gameView.setPrologueImage(blank);
            case 8 -> gameView.setPrologueImage(youCan);
            case 9 -> {
                GameAudio.stopSound();
                gameWorld.destroyCharacters();
                gameView.setPrologueImage(see);
            }
            case 10 -> {
                timer.stop();
                gameView.setPrologueImage(blank);
                Master.callMainGame();
            }
        }
    }

    public void startTimer() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        callNextScene();
    }
}
