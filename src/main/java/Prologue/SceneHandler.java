package Prologue;

import Master.GameAudio;
import Master.Master;
import Master.GameView;
import Prologue.Controllers.SceneController;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SceneHandler implements ActionListener {
    private final GameView gameView;
    private final GameWorld gameWorld;
    private final SceneContainer sceneContainer;
    private SceneController sceneController;

    public Timer getTimer() {
        return timer;
    }

    private final Timer timer;
    private int scene = 0;

    public SceneHandler(GameView gameView, GameWorld gameWorld) {
        this.gameView = gameView;
        this.gameWorld = gameWorld;
        sceneContainer = new SceneContainer();

        timer = new Timer(4500, this);
        timer.setInitialDelay(3900);
        timer.start();
        callNextScene();
    }

    public int getScene() {
        return scene;
    }

    public void setScene(int scene) {
        this.scene = scene;
    }

    public void callNextScene() {
        gameView.setPrologueImage(sceneContainer.getSceneImage(++scene));

        if (scene == 2) {
            timer.stop();
            gameWorld.enablePlayerControls();
        }
        else if (scene == 9) {
            timer.setDelay(2500);
            GameAudio.stopSound();
            gameWorld.createSwordsman();
        }
        else if (scene == 11) {
            timer.setDelay(4500);
        }
        else if (scene == 13) {
            gameWorld.destroyCharacters();
        }
        else if (scene == 14) {
            timer.stop();
            sceneController = new SceneController(this);
            gameView.addKeyListener(sceneController);
        }
        else if (scene == 24) {
            gameView.removeKeyListener(sceneController);
            gameWorld.stop();
            Master.callMainGame();
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
