package Master.Utility;

import city.cs.engine.UserView;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GiveFocus implements MouseListener {
    private final UserView userView;

    public GiveFocus(UserView userView) {
        this.userView = userView;
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        userView.requestFocus();
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {}

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {}

    @Override
    public void mousePressed(MouseEvent mouseEvent) {}

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {}
}
