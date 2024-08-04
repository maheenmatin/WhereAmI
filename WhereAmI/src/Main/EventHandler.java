package Main;

import Main.Characters.Enemy;
import Main.Characters.Player;
import Master.GameView;
import org.jbox2d.common.Vec2;

public class EventHandler {
    private static Game game;
    private static GameWorld gameWorld;
    private static GameView gameView;
    private static Player player;

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

    public static void endGame() {
        game.disableCountdown();
        gameWorld.disableEnemyCreation();
        Enemy.destroyAllEnemies();
        gameView.callGameOver(); // display Game Over + enable restart controls
    }

    public static void restartGame() {
        game.enableCountdown();
        gameWorld.enableEnemyCreation();
        gameView.resetGraphics(); // display normal graphics
        player.setPosition(new Vec2(10, 5)); // reset player position
    }
}
