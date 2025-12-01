package MainGame.Controllers;

import MainGame.Characters.Player;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerController implements KeyListener {
    private final Player player;
    private boolean left = false;
    private boolean walking = false;
    private boolean attacking = false;
    private boolean active = true;

    public PlayerController(Player player) {
        this.player = player;
    }

    public boolean isAttacking() {
        return attacking;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        if (active) {
            int key = ke.getKeyCode();

            if (key == KeyEvent.VK_W) {
                player.jump(40);
            }
            else if (key == KeyEvent.VK_A) {
                left = true;
                walking = true;
                player.startWalkLeft();
                player.startWalking(-30);
            }
            else if (key == KeyEvent.VK_D) {
                left = false;
                walking = true;
                player.startWalkRight();
                player.startWalking(30);
            }
            else if (key == KeyEvent.VK_S) {
                attacking = true;
                if (left) {
                    player.attackLeft();
                }
                else {
                    player.attackRight();
                }
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
        if (active) {
            int key = ke.getKeyCode();

            if (key == KeyEvent.VK_A) {
                walking = false;
                player.stopWalkLeft();
                player.startWalking(0);
            }
            else if (key == KeyEvent.VK_D) {
                walking = false;
                player.stopWalkRight();
                player.startWalking(0);
            }
            else if (key == KeyEvent.VK_S) {
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

    @Override
    public void keyTyped(KeyEvent ke) {}
}
