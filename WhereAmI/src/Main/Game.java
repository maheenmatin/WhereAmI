package Main;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game implements ActionListener {

    private GameWorld world;
    private GameView view;
    private Timer timer;
    private HeroController controller;

    public Game() {

        //make game world
        world = new GameWorld();

        //make game view and link it to the game world
        view = new GameView(world, 800, 600);
        //view.setGridResolution(1); //draw a 1-meter grid
        view.setZoom(10);

        //add keyboard control to hero
        controller = new HeroController(world.getHero());
        view.addKeyListener(controller);

        //enable key press detection when mouse is in view
        GiveFocus focus = new GiveFocus(view);
        view.addMouseListener(focus);

        //fix view to student
        world.addStepListener(new Tracker(view, world.getHero()));

        //add audio
        GameAudio.playSound();

        //enable response to key presses
        view.requestFocus();

        //give fields to EventHandler
        EventHandler.setFields(world, view);

        //start the game world simulation
        world.start();

        //start timer
        timerStart();

        //create a Java window/frame and add the game view to it
        JFrame frame = new JFrame("Where Am I?");
        frame.add(view);

        //make the frame quit the application when x is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false); //disable frame resizing
        frame.pack(); //size the frame to fit the world view
        frame.setLocationRelativeTo(null); //center the frame
        frame.setVisible(true); //make the frame visible

        //JFrame debugView = new DebugViewer(world, 500, 500); //enable debug-view
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        EventHandler.updateTime();
    }

    public GameView getView() {
        return view;
    }

    public void timerStart() {
        timer = new Timer(1000, this);
        timer.setInitialDelay(1500);
        timer.start();
    }

    public void timerStop() {
        timer.stop();
    }
}