package Prologue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneHandler implements ActionListener {
    private static final Image initial = new ImageIcon("data/Backgrounds/blankWhere.jpg").getImage();
    private static final Image press = new ImageIcon("data/Backgrounds/moonPress.png").getImage();
    private static final Image why = new ImageIcon("data/Backgrounds/why.png").getImage();
    private static final Image letMe = new ImageIcon("data/Backgrounds/letMe.png").getImage();
    private static final Image needToBe = new ImageIcon("data/Backgrounds/needToBe.png").getImage();
    private static final Image blank = new ImageIcon("data/Backgrounds/blank.jpg").getImage();
    private static final Image youCan = new ImageIcon("data/Backgrounds/blankYouCan.jpg").getImage();
    private static final Image see = new ImageIcon("data/Backgrounds/blankSee.jpg").getImage();

    private final GameView view;
    private final GameWorld world;
    private final Timer timer;
    private int scene = 0;

    public SceneHandler(GameView view, GameWorld world) {
        this.view = view;
        this.world = world;

        timer = new Timer(4500, this);
        timer.setInitialDelay(3900);
        timer.start();

        callNextScene();
    }

    public int getScene() {
        return scene;
    }

    public void callNextScene() {
        scene++;
        if (scene == 1) {
            GameAudio.playSound();
            view.setImage(initial);
        }
        else if (scene == 2) {
            world.enableKeyboardControls();
            timer.stop();
            view.setImage(press);
        }
        else if (scene == 3) {
            view.setImage(why);
        }
        else if (scene == 4) {
            view.setImage(letMe);
        }
        else if (scene == 5) {
            view.setImage(needToBe);
        }
        else if (scene == 6) {
            view.setImage(blank);
        }
        else if (scene == 7) {
            view.setImage(blank);
        }
        else if (scene == 8) {
            view.setImage(youCan);
        }
        else if (scene == 9) {
            GameAudio.stopSound();
            world.destroyCharacters();
            view.setImage(see);
        }
        else if (scene == 10) {
            timer.stop();
            view.setImage(blank);

            Master.Master.setChapter(1);
            Master.Master.callChapter();
        }
        else {
            view.setImage(blank);
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
