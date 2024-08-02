package Master;

import javax.swing.*;

public class Master {
    private static int chapter = 0; // 0 = prologue + main game, 2 = main game
    private static Prologue.Game prologueGame;
    private static Main.Game mainGame;
    private static JFrame jFrame;

    public static void setChapter(int chapter) {
        Master.chapter = chapter;
    }

    public static void createFrame() {
        jFrame = new JFrame("Where Am I?");
        jFrame.add(prologueGame.getGameView());

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationByPlatform(true);
        jFrame.setResizable(false);
        jFrame.pack(); // adjust frame size to fit the game view
        jFrame.setLocationRelativeTo(null); // center the frame
        jFrame.setVisible(true);
    }

    public static void callChapter() {
        if (chapter == 0) {
            prologueGame = new Prologue.Game();
            createFrame();
        }
        else if (chapter == 1) {
            jFrame.setVisible(false);
            jFrame.dispose();

            mainGame = new Main.Game();

            jFrame.remove(prologueGame.getGameView());
            jFrame.add(mainGame.getGameView());
            jFrame.setVisible(true);

            chapter = 2;
        }
        else if (chapter == 2) {
            mainGame = new Main.Game();
        }
    }

    public static void main(String[] args) {
        callChapter();
    }
}
