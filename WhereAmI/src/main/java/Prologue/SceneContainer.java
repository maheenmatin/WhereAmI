package Prologue;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class SceneContainer {
    private static final HashMap<Integer, Image> sceneMap = new HashMap<>();

    public SceneContainer() {
        sceneMap.put(1, new ImageIcon(
                "data/Backgrounds/Main/whereAmI.jpg").getImage());
        sceneMap.put(2, new ImageIcon(
                "data/Backgrounds/Graveyard/pressDToMove.png").getImage());
        sceneMap.put(3, new ImageIcon(
                "data/Backgrounds/Graveyard/whyCantILeave.png").getImage());
        sceneMap.put(4, new ImageIcon(
                "data/Backgrounds/Graveyard/letMeLeave.png").getImage());
        sceneMap.put(5, new ImageIcon(
                "data/Backgrounds/Graveyard/cantStayHere.png").getImage());
        sceneMap.put(6, new ImageIcon(
                "data/Backgrounds/Main/blank.jpg").getImage());
        sceneMap.put(7, new ImageIcon(
                "data/Backgrounds/Main/blank.jpg").getImage());
        sceneMap.put(8, new ImageIcon(
                "data/Backgrounds/Limbo/butYouCanLeave.jpg").getImage());
        sceneMap.put(9, new ImageIcon(
                "data/Backgrounds/Limbo/blankSee.jpg").getImage());
        sceneMap.put(10, new ImageIcon(
                "data/Backgrounds/Main/blank.jpg").getImage());
        sceneMap.put(11, new ImageIcon(
                "data/Backgrounds/Limbo/youWantedThis.jpg").getImage());
        sceneMap.put(12, new ImageIcon(
                "data/Backgrounds/Limbo/wantedToLeave.jpg").getImage());
        sceneMap.put(13, new ImageIcon(
                "data/Backgrounds/Limbo/wontHelpYou.jpg").getImage());
        sceneMap.put(14, new ImageIcon(
                "data/Backgrounds/Controls/pressC.jpg").getImage());
        sceneMap.put(15, new ImageIcon(
                "data/Backgrounds/Controls/pressAD.jpg").getImage());
        sceneMap.put(16, new ImageIcon(
                "data/Backgrounds/Controls/pressW.jpg").getImage());
        sceneMap.put(17, new ImageIcon(
                "data/Backgrounds/Controls/pressS.jpg").getImage());
        sceneMap.put(18, new ImageIcon(
                "data/Backgrounds/Controls/killAsManyDemons.jpg").getImage());
        sceneMap.put(19, new ImageIcon(
                "data/Backgrounds/Controls/ifYouAreCaught.jpg").getImage());
        sceneMap.put(20, new ImageIcon(
                "data/Backgrounds/Controls/ifYouFall.jpg").getImage());
        sceneMap.put(21, new ImageIcon(
                "data/Backgrounds/Controls/after60Seconds.jpg").getImage());
        sceneMap.put(22, new ImageIcon(
                "data/Backgrounds/Controls/thereIsNoRest.jpg").getImage());
        sceneMap.put(23, new ImageIcon(
                "data/Backgrounds/Controls/pressCToBegin.jpg").getImage());
        sceneMap.put(24, new ImageIcon(
                "data/Backgrounds/Main/blank.jpg").getImage());
    }

    public Image getSceneImage(int scene) {
        return sceneMap.get(scene);
    }
}
