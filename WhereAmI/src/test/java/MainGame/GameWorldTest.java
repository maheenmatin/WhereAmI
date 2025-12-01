package MainGame;

import Master.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.event.ActionEvent;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class GameWorldTest {
    private GameWorld gameWorld;

    @BeforeEach
    public void setUp() {
        GameView mockGameView = mock(GameView.class);
        gameWorld = spy(new GameWorld(mockGameView));
    }

    @Test
    public void testCreatePlayer() {
        assertNotNull(gameWorld.getPlayer());
    }

    @Test
    public void testEnableEnemyCreation() {
        // simulate timer event
        ActionEvent mockActionEvent = mock(ActionEvent.class);
        gameWorld.actionPerformed(mockActionEvent);
        verify(gameWorld, times(1)).actionPerformed(mockActionEvent);
    }

    @Test
    public void testDisableEnemyCreation() {
        gameWorld.disableEnemyCreation();
        assertFalse(gameWorld.getTimer().isRunning());
    }
}
