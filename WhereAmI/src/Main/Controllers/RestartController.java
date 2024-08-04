package Main.Controllers;

import Main.EventHandler;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RestartController implements KeyListener {
    private boolean enabled = false;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_R && enabled) {
            EventHandler.restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {}
    @Override
    public void keyTyped(KeyEvent keyEvent) {}
}
