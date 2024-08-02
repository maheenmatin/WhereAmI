package Prologue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GiveFocus implements MouseListener {
    private final GameView gameView;

    public GiveFocus(GameView gameView) {
        this.gameView = gameView;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        gameView.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
