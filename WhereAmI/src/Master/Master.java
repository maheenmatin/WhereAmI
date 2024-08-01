package Master;

import javax.swing.*;

public class Master {

    private static int chapter = 0; //0 for prologue + main game or 2 for main game only
    private static Prologue.Game game0;
    private static Main.Game game1;
    private static JFrame frame;

    public static void setChapter(int i) {
        Master.chapter = i;
    }

    public static void makeFrame() {
        //create a Java window/frame and add the game view to it
        frame = new JFrame("Where Am I?");
        frame.add(game0.getView());

        //make the frame quit the application when x is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);

        frame.setResizable(false); //disable frame resizing
        frame.pack(); //size the frame to fit the world view
        frame.setLocationRelativeTo(null); //center the frame
        frame.setVisible(true); //make the frame visible

        //JFrame debugView = new DebugViewer(world, 500, 500); //enable debug-view
    }

    public static void callChapter() {
        if (chapter == 0) {
            game0 = new Prologue.Game();
            makeFrame();
        }

        else if (chapter == 1) {
            frame.setVisible(false);
            frame.dispose();

            game1 = new Main.Game();
            Main.EventHandler.setFields(game1);

            frame.remove(game0.getView());
            frame.add(game1.getView());
            frame.setVisible(true);

            chapter = 2;
        }

        else if (chapter == 2) {
            game1 = new Main.Game();
            Main.EventHandler.setFields(game1);
        }
    }

    public static void main(String[] args) {
        //run the game
        callChapter();
    }
}