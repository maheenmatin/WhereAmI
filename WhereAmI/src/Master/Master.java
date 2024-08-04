package Master;

import javax.swing.*;

public class Master {
    private static Prologue.Game prologueGame;
    private static Main.Game mainGame;
    private static GameView gameView;
    private static JFrame jFrame;

    public static void callPrologue() {
        prologueGame = new Prologue.Game();
        gameView = prologueGame.getGameView();
        jFrame = new JFrame("Where Am I?");
        jFrame.add(gameView);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationByPlatform(true);
        jFrame.setResizable(false);
        jFrame.pack(); // adjust frame size to fit the game view
        jFrame.setLocationRelativeTo(null); // center the frame
        jFrame.setVisible(true);
    }

    public static void callMainGame() {
        gameView.setPrologue(false);
        mainGame = new Main.Game(gameView);
    }

    public static void main(String[] args) {
        callPrologue();
    }
}
