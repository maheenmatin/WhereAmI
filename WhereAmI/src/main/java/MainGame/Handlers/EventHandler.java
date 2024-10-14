package MainGame.Handlers;

import MainGame.Characters.Enemy;
import MainGame.Characters.Player;
import MainGame.Controllers.PlayerController;
import MainGame.Game;
import MainGame.GameWorld;
import Master.GameView;

public class EventHandler {
    private static Game game;
    private static GameWorld gameWorld;
    private static GameView gameView;
    private static Player player;
    private static PlayerController playerController;

    public static void setGame(Game game) {
        EventHandler.game = game;
    }

    public static void setGameWorld(GameWorld gameWorld) {
        EventHandler.gameWorld = gameWorld;
    }

    public static void setGameView(GameView gameView) {
        EventHandler.gameView = gameView;
    }

    public static void setPlayer(Player player) {
        EventHandler.player = player;
    }

    public static void setPlayerController(PlayerController playerController) {
        EventHandler.playerController = playerController;
    }

    public static void endGame() {
        game.disableCountdown();
        gameWorld.disableEnemyCreation();

        // stop player movement
        playerController.setActive(false);
        player.simulateDeath();

        // display Game Over + enable restart controls
        gameView.callGameOver();
    }

    public static void restartGame() {
        Enemy.destroyAllEnemies();
        game.enableCountdown();
        gameWorld.enableEnemyCreation();

        // display normal graphics
        playerController.setActive(true);
        player.initialize();
        player.setGravityScale(10);

        // start player movement
        gameView.resetGraphics();
    }
}
