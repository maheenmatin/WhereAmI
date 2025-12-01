package MainGame;

import MainGame.Characters.Enemy;
import MainGame.Characters.Player;
import MainGame.Controllers.PlayerController;
import MainGame.Handlers.EventHandler;
import Master.GameView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import static org.mockito.Mockito.*;

public class EventHandlerTest {
    private Game mockGame;
    private GameWorld mockGameWorld;
    private GameView mockGameView;
    private Player mockPlayer;
    private PlayerController mockPlayerController;

    @BeforeEach
    public void setUp() {
        mockGame = mock(Game.class);
        mockGameWorld = mock(GameWorld.class);
        mockGameView = mock(GameView.class);
        mockPlayer = mock(Player.class);
        mockPlayerController = mock(PlayerController.class);

        // set fields with mocks
        EventHandler.setGame(mockGame);
        EventHandler.setGameWorld(mockGameWorld);
        EventHandler.setGameView(mockGameView);
        EventHandler.setPlayer(mockPlayer);
        EventHandler.setPlayerController(mockPlayerController);
    }

    @Test
    public void testEndGame() {
        EventHandler.endGame();

        verify(mockGame).disableCountdown();
        verify(mockGameWorld).disableEnemyCreation();
        verify(mockPlayerController).setActive(false);
        verify(mockPlayer).simulateDeath();
        verify(mockGameView).callGameOver();
    }

    @Test
    public void testRestartGame() {
        EventHandler.restartGame();

        verify(mockGame).enableCountdown();
        verify(mockGameWorld).enableEnemyCreation();
        verify(mockPlayerController).setActive(true);
        verify(mockPlayer).initialize();
        verify(mockPlayer).setGravityScale(10);
        verify(mockGameView).resetGraphics();

        // static mock Enemy
        try (MockedStatic<Enemy> mockedEnemy = mockStatic(Enemy.class)) {
            EventHandler.restartGame();
            mockedEnemy.verify(Enemy::destroyAllEnemies, times(1));
        }
    }
}
