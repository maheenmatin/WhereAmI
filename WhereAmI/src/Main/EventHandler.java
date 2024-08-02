package Main;

public class EventHandler {
    private static Game game;
    private static GameWorld gameWorld;
    private static GameView gameView;
    private static Player player;
    private static PlayerController playerController;
    private static int highScore = 0;

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

    public static void callEnd() {
        game.stopTimer();
        gameWorld.stopTimer();
        Enemy.setDestroyAllEnemies(true);

        gameView.removeKeyListener(playerController);
        player.destroy();

        if (gameView.getScore() > highScore) {
            highScore = gameView.getScore();
        }
        gameView.setHighScore(highScore);

        gameView.setActiveGame(false);

        EventController controlRestart = new EventController();
        gameView.addKeyListener(controlRestart);
    }

    public static void updateTime() {
        if (gameView.getTime() > 0) {
            gameView.setTime(gameView.getTime() - 1);
        } else if (gameView.getTime() <= 0 ) {
            callEnd();
        }
    }

    public static void updateScore() {
        gameView.setScore(gameView.getScore() + 1);
    }

    public static void restart() {
        GameAudio.stopSound();
        Enemy.setDestroyAllEnemies(false);
        gameWorld.stop();

        Master.Master.callChapter();
    }
}
