package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class HeroController implements KeyListener {

    private static Hero hero;

    private static boolean left = false;

    private static boolean run = false;

    private static boolean attack = false;

    public static boolean getAttack() {
        return attack;
    }

    public HeroController(Hero s) {
        hero = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_W) {
            hero.jump(25);
        } else if (code == KeyEvent.VK_A) {
            left = true;
            run = true;

            hero.startWalkLeft();
            hero.startWalking(-25);
        } else if (code == KeyEvent.VK_D) {
            left = false;
            run = true;

            hero.startWalkRight();
            hero.startWalking(25);
        } else if (code == KeyEvent.VK_S) {
            attack = true;
            if (left) {
                hero.attackLeft();
            }
            else {
                hero.attackRight();
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            run = false;

            hero.stopWalkLeft();
            hero.startWalking(0);
        } else if (code == KeyEvent.VK_D) {
            run = false;

            hero.stopWalkRight();
            hero.startWalking(0);
        } else if (code == KeyEvent.VK_S) {
            attack = false;

            if (left && !run) {
                hero.stopWalkLeft();
            }
            else if (!left && !run){
                hero.stopWalkRight();
            }
            else if (left && run) {
                hero.startWalkLeft();
            }
            else if (!left && run) {
                hero.startWalkRight();
            }
        }
    }
}