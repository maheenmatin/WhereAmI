package Prologue;

import javax.swing.*;
import java.awt.*;

class SceneHandler {
    private Image image;

    private int chapter = 0;
    private int scene = 0;

    private GameView view;
    private GameWorld world;
    private Game game;

    private static final Image background = new ImageIcon("data/Backgrounds/moon.png").getImage();
    private static final Image press = new ImageIcon("data/Backgrounds/moonPress.png").getImage();
    private static final Image why = new ImageIcon("data/Backgrounds/why.png").getImage();
    private static final Image letMe = new ImageIcon("data/Backgrounds/letMe.png").getImage();
    private static final Image needToBe = new ImageIcon("data/Backgrounds/needToBe.png").getImage();
    private static final Image blank = new ImageIcon("data/Backgrounds/blank.jpg").getImage();
    private static final Image youCan = new ImageIcon("data/Backgrounds/blankYouCan.jpg").getImage();
    private static final Image see = new ImageIcon("data/Backgrounds/blankSee.jpg").getImage();

    public SceneHandler(GameView view, GameWorld world) {
        this.view = view;
        this.world = world;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public int GetScene() {
        return scene;
    }

    public void changeScene() {
        if (scene == 1) {
            view.setImage(press);
        } else if (scene == 2) {
            view.setImage(why);
        } else if (scene == 3) {
            view.setImage(letMe);
        } else if (scene == 4) {
            view.setImage(needToBe);
        } else if (scene == 5) {
            view.setImage(blank);
        } else if (scene == 6) {
            view.setImage(blank);
        } else if (scene == 7) {
            view.setImage(youCan);
        } else if (scene == 8) {
            GameAudio.stopSound();
            world.destroy();
            view.setImage(see);
        } else if (scene == 9) {
            view.setImage(blank);
            chapter++; //1
            scene++; //1
            Master.Master.setChapter(chapter);
            Master.Master.callChapter();
        } else {
            view.setImage(blank);
        }
    }
}