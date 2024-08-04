package Main;

import Master.GameAudio;
import Master.GiveFocus;
import Master.Tracker;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private final GameView gameView;
    private Timer timer;

    public Game() {
        // create game components
        GameWorld gameWorld = new GameWorld();
        gameView = new GameView(gameWorld, 800, 600);
        gameView.setZoom(10);
        gameWorld.setGameView(gameView);
        gameWorld.enableKeyboardControls();
        GameAudio.playSound();

        EventHandler.setGame(this);
        EventHandler.setGameWorld(gameWorld);
        EventHandler.setGameView(gameView);
        EventHandler.setPlayer(gameWorld.getPlayer());

        // fix view to player
        gameWorld.addStepListener(new Tracker(gameView, gameWorld.getPlayer()));
        // enable key press detection when mouse is in view
        gameView.addMouseListener(new GiveFocus(gameView));
        // enable response to key presses
        gameView.requestFocus();

        enableCountdown();
        gameWorld.start();
    }

    public GameView getGameView() {
        return gameView;
    }

    public void enableCountdown() {
        timer = new Timer(1000, this);
        timer.setInitialDelay(1500);
        timer.start();
    }

    public void disableCountdown() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        int time = gameView.getTime();
        if (time > 0) {
            gameView.setTime(--time);
        }
        else if (time == 0 ) {
            EventHandler.endGame();
        }
    }
}
