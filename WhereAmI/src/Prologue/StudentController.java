package Prologue;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StudentController implements KeyListener {

    private Student student;
    private int situation = 1;

    public StudentController(Student s) {
        student = s;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        // other key commands omitted
        if (code == KeyEvent.VK_D && situation == 0) {
            student.startWalk();
            student.startWalking(0); //0
        }
        else if (code == KeyEvent.VK_D && situation == 1) {
            student.startWalk();
            student.startWalking(20); //20
        }
        else if (code == KeyEvent.VK_D && situation == 2) {
            student.startWalk();
            student.startWalking(30); //30
        }
        else if (code == KeyEvent.VK_D && situation == 3) {
            student.startWalk();
            student.startWalking(40); //40
        }
        else if (code == KeyEvent.VK_D && situation >= 4) {
            student.startWalk();
            student.startWalking(30); //30
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_D) {
            student.stopWalk();
            student.startWalking(0);
        }
    }

    public void setSituation(int i) {
        this.situation = i;
    }

    public int getSituation() {
        return situation;
    }

    public void remove() {
        situation = 0;
    }
}