package Main;

import Master.GameView;
import Master.Tracker;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {
    private final GameView gameView;
    private Timer timer;

    public Game(GameView view) {
        // create game components
        this.gameView = view;
        GameWorld gameWorld = new GameWorld(gameView);
        gameView.setWorld(gameWorld);
        gameView.setZoom(10);

        EventHandler.setGame(this);
        EventHandler.setGameWorld(gameWorld);
        EventHandler.setGameView(gameView);
        EventHandler.setPlayer(gameWorld.getPlayer());

        // fix view to player
        gameWorld.addStepListener(new Tracker(gameView, gameWorld.getPlayer()));

        enableCountdown();
        gameWorld.start();
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
