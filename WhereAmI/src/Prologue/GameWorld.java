package Prologue;

import city.cs.engine.Shape;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World implements CollisionListener {
    private SceneHandler sceneHandler;
    private GameView gameView;
    private PlayerController playerController;
    private final Player player;
    private Enemy enemy;

    public GameWorld() {
        // create environment
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

        Checkpoint checkpoint = new Checkpoint(this);
        checkpoint.setPosition(new Vec2(39.99f, 0));
        checkpoint.setName("checkpoint");

        Invisible.makeInvisible(ground1);
        Invisible.makeInvisible(ground2);
        Invisible.makeInvisible(ground3);
        Invisible.makeInvisible(checkpoint);

        // create player
        player = new Player(this);
        player.setPosition(new Vec2(-35,-15));
        player.setGravityScale(10);
        player.addCollisionListener(this);
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public void setSceneHandler(SceneHandler sceneHandler) {
        this.sceneHandler = sceneHandler;
    }

    public void collide(CollisionEvent e) {
        if (e.getOtherBody() instanceof Checkpoint && sceneHandler.getScene() != 5) {
            player.setPosition(new Vec2(-35,-15));
            playerController.setSpeed(playerController.getSpeed()+1);
            sceneHandler.callNextScene();
        }
        else if (e.getOtherBody() instanceof Checkpoint && sceneHandler.getScene() == 5) {
            player.setPosition(new Vec2(-35,-15));
            playerController.setSpeed(0);
            sceneHandler.callNextScene();
            sceneHandler.startTimer();

            // create enemy
            enemy = new Enemy(this);
            enemy.setPosition(new Vec2(35,35));
            enemy.setGravityScale(0.35f);
        }
    }

    public void enableKeyboardControls() {
        playerController = new PlayerController(player);
        gameView.addKeyListener(playerController);
    }

    public void destroyCharacters() {
        player.destroy();
        enemy.destroy();
    }
}
