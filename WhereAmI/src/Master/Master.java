package Master;

import javax.swing.*;

public class Master {
    private static final int chapter = 0; // 0 = prologue + main game, other = main game
    private static Prologue.Game prologueGame;
    private static Main.Game mainGame;
    private static JFrame jFrame;

    public static void createFrame(boolean isPrologue) {
        jFrame = new JFrame("Where Am I?");
        jFrame.add(isPrologue ? prologueGame.getGameView() : mainGame.getGameView());

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
            createFrame(true);
        }
        else {
            mainGame = new Main.Game();
            createFrame(false);
        }
    }

    public static void callMainGame() {
        mainGame = new Main.Game();
        createFrame(false);
    }

    public static void main(String[] args) {
        callChapter();
    }
}
