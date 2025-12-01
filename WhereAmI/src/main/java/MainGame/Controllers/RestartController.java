package MainGame.Controllers;

import MainGame.Handlers.EventHandler;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class RestartController implements KeyListener {
    private boolean enabled = false;

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_R && enabled) {
            EventHandler.restartGame();
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {}

    @Override
    public void keyTyped(KeyEvent ke) {}
}
