package MainGame;

import Master.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameTest {
    private Game mockGame;
    private GameView mockGameView;

    @BeforeEach
    public void setUp() {
        mockGameView = mock(GameView.class);
        mockGame = new Game(mockGameView);
    }

    @Test
    public void testGameInit() {
        assertNotNull(mockGame.getGameView(), "GameView should be initialized");
        assertNotNull(mockGame.getGameWorld(), "GameWorld should be initialized");
    }

    @Test
    public void testEnableCountdown() {
        mockGame.enableCountdown();
        assertTrue(mockGame.getTimer().isRunning());
    }

    @Test
    public void testDisableCountdown() {
        mockGame.disableCountdown();
        assertFalse(mockGame.getTimer().isRunning());
    }
}
