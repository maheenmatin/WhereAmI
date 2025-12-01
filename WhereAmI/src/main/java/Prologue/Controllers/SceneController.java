package Prologue.Controllers;

import Prologue.SceneHandler;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SceneController implements KeyListener {
    private final SceneHandler sceneHandler;

    public SceneController(SceneHandler sceneHandler) {
        this.sceneHandler = sceneHandler;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_C) {
            sceneHandler.callNextScene();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {}

    @Override
    public void keyTyped(KeyEvent ke) {}
}
