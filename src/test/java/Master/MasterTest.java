package Master;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import javax.swing.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

class MasterTest {

    @BeforeEach
    public void setUp() {
        // Any setup code before each test can go here
        Master.callPrologue(); // Call the method to initialize game view
    }

    @AfterEach
    public void tearDown() {
        // Any cleanup code after each test can go here
        // For example, dispose of the JFrame if needed
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(Master.getGameView());
        if (frame != null) {
            frame.dispose(); // Close the JFrame to avoid resource leaks
        }
    }

    @Test
    public void testGameViewIsNotNull() {
        // Test that the game view is initialized and not null
        GameView gameView = Master.getGameView();
        assertNotNull(gameView, "GameView should not be null after calling callPrologue()");
    }

    @Test
    public void testGameAudioIsPlaying() {
        // use Mockito to create a mock of GameAudio
        try (MockedStatic<GameAudio> mockedAudio = Mockito.mockStatic(GameAudio.class)) {
            Master.callMainGame();

            mockedAudio.verify(GameAudio::playSound, times(1));
        }
    }
}
