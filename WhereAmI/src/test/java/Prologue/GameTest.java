package Prologue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private static Game game;

    @BeforeAll
    public static void setUp() {
        game = new Game();
    }

    @Test
    public void testGameInit() {
        assertNotNull(game.getGameView(), "GameView should be initialized");
        assertNotNull(game.getGameWorld(), "GameWorld should be initialized");
    }
}
