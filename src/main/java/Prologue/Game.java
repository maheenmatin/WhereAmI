package Prologue;

import Master.GameView;
import Master.Utility.GiveFocus;

public class Game {
    private final GameWorld gameWorld;
    private final GameView gameView;

    public Game() {
        // create game components
        gameWorld = new GameWorld();
        gameView = new GameView(gameWorld, 800, 600);
        gameView.setZoom(10);
        gameWorld.setGameView(gameView);
        gameWorld.setSceneHandler(new SceneHandler(gameView, gameWorld));

        // enable key press detection when mouse is in view
        gameView.addMouseListener(new GiveFocus(gameView));
        // enable response to key presses
        gameView.requestFocus();

        gameWorld.start();
    }

    public GameWorld getGameWorld() {
        return gameWorld;
    }

    public GameView getGameView() {
        return gameView;
    }
}
