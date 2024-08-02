package Prologue;

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

    //TODO: duplicate else if bodies
    public void callNextScene() {
        scene++;
        if (scene == 1) {
            GameAudio.playSound();
            gameView.setImage(initial);
        }
        else if (scene == 2) {
            gameWorld.enableKeyboardControls(gameView);
            timer.stop();
            gameView.setImage(press);
        }
        else if (scene == 3) {
            gameView.setImage(why);
        }
        else if (scene == 4) {
            gameView.setImage(letMe);
        }
        else if (scene == 5) {
            gameView.setImage(needToBe);
        }
        else if (scene == 6) {
            gameView.setImage(blank);
        }
        else if (scene == 7) {
            gameView.setImage(blank);
        }
        else if (scene == 8) {
            gameView.setImage(youCan);
        }
        else if (scene == 9) {
            GameAudio.stopSound();
            gameWorld.destroyCharacters();
            gameView.setImage(see);
        }
        else if (scene == 10) {
            timer.stop();
            gameView.setImage(blank);

            Master.Master.setChapter(1);
            Master.Master.callChapter();
        }
        else {
            gameView.setImage(blank);
        }
    }

    public void startTimer() {
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        callNextScene();
    }
}
