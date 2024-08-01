package Prologue;

import city.cs.engine.Shape;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameWorld extends World implements ActionListener, CollisionListener {

    private Student student;
    private Professor professor;
    private GameView view;
    private SceneHandler handler;
    private StudentController controller;
    private int event = 0;
    private Timer timer;

    public GameWorld() {

        //make the ground
        Shape shape1 = new BoxShape(18.8f, 0.1f);
        StaticBody ground1 = new StaticBody(this, shape1);
        ground1.setPosition(new Vec2(-21.2f,-19f));
        ground1.setName("ground1");

        Shape shape2 = new BoxShape(10.4f, 0.1f);
        StaticBody ground2 = new StaticBody(this, shape2);
        ground2.setPosition(new Vec2(4.6f,-9));
        ground2.rotateDegrees(new Vec2(16,-9), 28);
        ground2.setName("ground2");

        Shape shape3 = new BoxShape(12.49f, 0.1f);
        StaticBody ground3 = new StaticBody(this, shape3);
        ground3.setPosition(new Vec2(27.51f,-9.5f));
        ground3.setName("ground3");

        Checkpoint checkpoint1 = new Checkpoint(this);
        checkpoint1.setPosition(new Vec2(39.99f, 0));
        checkpoint1.setName("checkpoint1");

        //make the ground and the checkpoint invisible
        Invisible.makeInvisible(ground1);
        Invisible.makeInvisible(ground2);
        Invisible.makeInvisible(ground3);
        Invisible.makeInvisible(checkpoint1);

        //make the student
        student = new Student(this);
        student.setPosition(new Vec2(-35,-15));
        student.setGravityScale(10);

        //add collision listener
        student.addCollisionListener(this);

        //add audio
        GameAudio.playSound();
    }

    public void getFields(GameView view, SceneHandler handler, Timer timer) {
        this.view = view;
        this.handler = handler;
        this.timer = timer;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (event == 0) { //only once at the start
            //add keyboard control after 5 seconds
            controller = new StudentController(student);
            view.addKeyListener(controller);
            event = 1;

            handler.setScene(handler.GetScene()+1);
            handler.changeScene();
        }
        else if (event == 1) {

        }
        else if (event >= 2 && handler.GetScene() == 11) {
            timer.stop();
        }
        else if (event >= 2) {
            handler.changeScene();
            handler.setScene(handler.GetScene()+1);
        }
    }

    public void collide(CollisionEvent e) {
        //System.out.println(e.getOtherBody());
        if (e.getOtherBody() instanceof Checkpoint && handler.GetScene() != 4) {
            student.setPosition(new Vec2(-35,-15));
            controller.setSituation(controller.getSituation()+1);

            handler.setScene(handler.GetScene()+1);
            handler.changeScene();
        }
        else if (e.getOtherBody() instanceof Checkpoint && handler.GetScene() == 4) {
            student.setPosition(new Vec2(-35,-15));

            handler.setScene(handler.GetScene()+1);
            handler.changeScene();

            professor = new Professor(this);
            professor.setPosition(new Vec2(35,35));
            professor.setGravityScale(0.35f);
            controller.remove();

            handler.setScene(handler.GetScene()+1);
            event = 2;
        }
    }

    public void destroy() {
        student.destroy();
        professor.destroy();
    }
}