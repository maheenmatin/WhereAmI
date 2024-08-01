package Prologue;

import city.cs.engine.*;

public class Student extends Walker {
    private static final Shape studentShape = new PolygonShape(
            -0.19f,3.58f,
            1.31f,2.9f,
            1.39f,-5.0f,
            -0.61f,-5.0f,
            -1.17f,-1.62f,
            -1.35f,1.6f);

    private static final Shape studentShape2 = new PolygonShape(
            1.61f,0.24f,
            1.71f,-4.86f,
            -1.43f,-4.86f,
            -1.47f,1.64f,
            -0.83f,3.62f,
            1.33f,3.1f);

    private static final BodyImage image =
            new BodyImage("data/Characters/Prologue/hat-man-idle.gif", 10f);
    private static final BodyImage image2 =
            new BodyImage("data/Characters/Prologue/hat-man-walk.gif", 10f);

    private SolidFixture fixture;

    public Student(World world) {
        super(world);
        fixture = new SolidFixture(this, studentShape);
        addImage(image);
        //setAlwaysOutline(true);
    }

    public void startWalk() {
        fixture.destroy();
        fixture = new SolidFixture(this, studentShape2);
        removeAllImages();
        addImage(image2);
    }

    public void stopWalk() {
        fixture.destroy();
        fixture = new SolidFixture(this, studentShape);
        removeAllImages();
        addImage(image);
    }
}