package Prologue;

import javax.swing.*;

public class Game {

    private Student student;
    private static GameWorld world;
    private GameView view;
    private SceneHandler handler;
    private static JFrame frame;
    private Timer timer;

    public JFrame getFrame() {
        return frame;
    }

    public Game() {

        //make game world
        world = new GameWorld();

        //make game view and link it to the game world
        view = new GameView(world, 800, 600);
        //view.setGridResolution(1); //draw a 1-meter grid
        view.setZoom(10);

        //get fields for scene handling
        handler = new SceneHandler(view, world);
        timerHandle();
        world.getFields(view, handler, timer);

        //enable key press detection when mouse is in view
        GiveFocus focus = new GiveFocus(view);
        view.addMouseListener(focus);

        world.start(); //start the game world simulation

        view.requestFocus(); //enable response to key presses
    }

    public void timerHandle() {
        timer = new Timer(4500, world);
        timer.setInitialDelay(3900);
        timer.start();
    }

    public GameView getView() {
        return view;
    }
}