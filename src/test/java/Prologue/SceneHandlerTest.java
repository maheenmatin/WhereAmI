package Prologue;

import Master.GameAudio;
import Master.GameView;
import Master.Master;
import Prologue.Controllers.SceneController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

class SceneHandlerTest {
    private SceneHandler sceneHandler;
    private GameView mockGameView;
    private GameWorld mockGameWorld;

    @BeforeEach
    public void setUp() {
        mockGameView = mock(GameView.class);
        mockGameWorld = mock(GameWorld.class);
        sceneHandler = new SceneHandler(mockGameView, mockGameWorld);
    }

    @Test
    public void testInitialSceneIs1() {
        assertEquals(1, sceneHandler.getScene());
    }

    @Test
    public void testTimerStopsInScene2() {
        sceneHandler.callNextScene();
        sceneHandler.callNextScene();

        assertFalse(sceneHandler.getTimer().isRunning());
    }

    @Test
    public void testSwordsmanIsCreatedInScene9() {
        sceneHandler.setScene(8);

        try (MockedStatic<GameAudio> mockedAudio = Mockito.mockStatic(GameAudio.class)) {
            sceneHandler.callNextScene();
            System.out.println(sceneHandler.getScene());
            mockedAudio.verify(GameAudio::stopSound);
        }
        verify(mockGameWorld).createSwordsman();
    }

    @Test
    public void testSceneControllerAddedInScene14() {
        sceneHandler.setScene(13);
        sceneHandler.callNextScene();
        verify(mockGameView).addKeyListener(any(SceneController.class));
    }

    @Test
    public void testMainGameIsCalledInScene24() {
        sceneHandler.setScene(23);

        // verify callMainGame using spy
        try (MockedStatic<Master> masterSpy = Mockito.mockStatic(Master.class)) {
            sceneHandler.callNextScene();
            System.out.println(sceneHandler.getScene());
            masterSpy.verify(Master::callMainGame);
        }
        SceneController mockSceneController = mock(SceneController.class);
        verify(mockGameWorld).stop();
    }
}
