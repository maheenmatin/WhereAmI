package Prologue;

import javax.sound.sampled.*;
import java.io.File;

public class GameAudio {

    private static AudioInputStream audioInputStream;
    private static Clip clip;
    private static String audio = "data/Audio/music1.wav";

    public static void playSound() {
        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File(audio).getAbsoluteFile());
            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        }
        catch(Exception ex) {
            System.out.println("Error with playing sound.");
            ex.printStackTrace();
        }
    }

    public static void stopSound() {
        clip.stop();
    }
}