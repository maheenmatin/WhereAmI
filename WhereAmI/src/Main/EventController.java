package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EventController implements KeyListener {
    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == KeyEvent.VK_R) {
            EventHandler.restart();
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {}

    @Override
    public void keyTyped(KeyEvent keyEvent) {}
}
