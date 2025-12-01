package Master;

import javax.sound.sampled.*;
import java.io.File;

public class GameAudio {
    private static Clip clip;

    public static void playSound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(
                    new File("data/Audio/music.wav").getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
            clip.start();
        }
        catch(Exception ex) {
            System.out.println("Audio error");
            ex.printStackTrace();
        }
    }

    public static void stopSound() {
        clip.stop();
    }
}
