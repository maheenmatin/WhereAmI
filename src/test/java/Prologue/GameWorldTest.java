package Prologue;

import Master.GameView;
import org.jbox2d.common.Vec2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class GameWorldTest {
    private GameWorld gameWorld;
    private GameView mockGameView;
    private SceneHandler mockSceneHandler;

    @BeforeEach
    public void setUp() {
        gameWorld = new GameWorld();
        mockGameView = mock(GameView.class);
        mockSceneHandler = mock(SceneHandler.class);
        gameWorld.setGameView(mockGameView);
        gameWorld.setSceneHandler(mockSceneHandler);
    }

    @Test
    public void testPlayerIsCreated() {
        assertNotNull(gameWorld.getPlayer(), "Player should be created");
        assertEquals(new Vec2(-35, -15), gameWorld.getPlayer().getPosition(),
                "Player position should be set correctly");
    }

    @Test
    public void testSwordsmanIsCreated() {
        gameWorld.createSwordsman();
        assertNotNull(gameWorld.getSwordsman(), "Swordsman should be created");
        assertEquals(new Vec2(-30, -15), gameWorld.getSwordsman().getPosition(),
                "Player position should be set correctly");
    }

    @Test
    public void testEnemyIsCreated() {
        gameWorld.createEnemy();
        assertNotNull(gameWorld.getEnemy(), "Enemy should be created");
        assertEquals(new Vec2(35, 35), gameWorld.getEnemy().getPosition(),
                "Enemy position should be set correctly");
    }
}
