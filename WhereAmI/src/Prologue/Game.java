package Prologue;

public class Game {
    private final GameView gameView;

    public Game() {
        // create game components
        GameWorld gameWorld = new GameWorld();
        gameView = new GameView(gameWorld, 800, 600);
        gameView.setZoom(10);
        gameWorld.setSceneHandler(new SceneHandler(gameView, gameWorld));

        // enable key press detection when mouse is in view
        gameView.addMouseListener(new GiveFocus(gameView));
        // enable response to key presses
        gameView.requestFocus();

        gameWorld.start();
    }

    public GameView getGameView() {
        return gameView;
    }
}
