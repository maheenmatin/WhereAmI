package Main;

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
        gameWorld.enableKeyboardControls(gameView);
        GameAudio.playSound();
        startTimer();

        // fix view to player
        gameWorld.addStepListener(new Tracker(gameView, gameWorld.getPlayer()));

        // enable key press detection when mouse is in view
        gameView.addMouseListener(new GiveFocus(gameView));
        // enable response to key presses
        gameView.requestFocus();

        EventHandler.setGame(this);
        EventHandler.setGameWorld(gameWorld);
        EventHandler.setGameView(gameView);
        EventHandler.setPlayer(gameWorld.getPlayer());
        gameWorld.start();

        // create a Java window/frame and add the game view to it
        JFrame frame = new JFrame("Where Am I?");
        frame.add(gameView);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false); // disable frame resizing
        frame.pack(); // size the frame to fit the world view
        frame.setLocationRelativeTo(null); // center the frame
        frame.setVisible(true); // make the frame visible
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        EventHandler.updateTime();
    }

    public GameView getGameView() {
        return gameView;
    }

    public void startTimer() {
        timer = new Timer(1000, this);
        timer.setInitialDelay(1500);
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }
}
