package Prologue.Controllers;

import Prologue.Characters.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private final Player player;
    private int speed = 1;

    public PlayerController(Player player) {
        this.player = player;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_D) {
            if (speed == 0) {
                player.startWalk();
                player.startWalking(0);
            }
            else if (speed == 1) {
                player.startWalk();
                player.startWalking(20);
            }
            else if (speed == 2) {
                player.startWalk();
                player.startWalking(30);
            }
            else if (speed == 3) {
                player.startWalk();
                player.startWalking(40);
            }
            else if (speed == 4) {
                player.startWalk();
                player.startWalking(30);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (ke.getKeyCode() == KeyEvent.VK_D) {
            player.stopWalk();
            player.startWalking(0);
        }
    }

    @Override
    public void keyTyped(KeyEvent ke) {}
}
