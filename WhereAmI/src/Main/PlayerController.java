package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private final Player player;
    private boolean left = false;
    private boolean walking = false;
    private boolean attacking = false;

    public PlayerController(Player player) {
        this.player = player;
    }

    public boolean isAttacking() {
        return attacking;
    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {}

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();

        if (code == KeyEvent.VK_W) {
            player.jump(25);
        }
        else if (code == KeyEvent.VK_A) {
            left = true;
            walking = true;
            player.startWalkLeft();
            player.startWalking(-25);
        }
        else if (code == KeyEvent.VK_D) {
            left = false;
            walking = true;
            player.startWalkRight();
            player.startWalking(25);
        }
        else if (code == KeyEvent.VK_S) {
            attacking = true;
            if (left) {
                player.attackLeft();
            }
            else {
                player.attackRight();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        int code = keyEvent.getKeyCode();
        if (code == KeyEvent.VK_A) {
            walking = false;
            player.stopWalkLeft();
            player.startWalking(0);
        }
        else if (code == KeyEvent.VK_D) {
            walking = false;
            player.stopWalkRight();
            player.startWalking(0);
        }
        else if (code == KeyEvent.VK_S) {
            attacking = false;
            if (left && walking) {
                player.startWalkLeft();
            }
            else if (!left && walking) {
                player.startWalkRight();
            }
            else if (left) {
                player.stopWalkLeft();
            }
            else {
                player.stopWalkRight();
            }
        }
    }
}
