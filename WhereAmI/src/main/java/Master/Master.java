package Master;

import javax.swing.*;

public class Master {
    private static GameView gameView;

    public static GameView getGameView() {
        return gameView;
    }

    public static void callPrologue() {
        Prologue.Game prologueGame = new Prologue.Game();
        gameView = prologueGame.getGameView();
        GameAudio.playSound();

        JFrame jFrame = new JFrame("Where Am I?");
        jFrame.add(gameView);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationByPlatform(true);
        jFrame.setResizable(false);
        jFrame.pack(); // adjust frame size to fit the game view
        jFrame.setLocationRelativeTo(null); // center the frame
        jFrame.setVisible(true);
    }

    public static void callMainGame() {
        GameAudio.playSound();
        gameView.setPrologue(false);
        new MainGame.Game(gameView);
    }

    public static void main(String[] args) {
        callPrologue();
    }
}
