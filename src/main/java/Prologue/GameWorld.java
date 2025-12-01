package Prologue;

import Master.GameView;
import Prologue.Characters.Enemy;
import Prologue.Characters.Player;
import Prologue.Characters.Swordsman;
import Prologue.Controllers.PlayerController;
import Prologue.Environment.Checkpoint;
import Prologue.Environment.Ground;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

public class GameWorld extends World implements CollisionListener {
    private GameView gameView;
    private SceneHandler sceneHandler;
    private PlayerController playerController;
    private Player player;
    private Swordsman swordsman;
    private Enemy enemy;

    public GameWorld() {
        createEnvironment();
        createPlayer();
    }

    public Player getPlayer() {
        return player;
    }

    public Swordsman getSwordsman() {
        return swordsman;
    }

    public Enemy getEnemy() {
        return enemy;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }

    public void setSceneHandler(SceneHandler sceneHandler) {
        this.sceneHandler = sceneHandler;
    }

    private void createEnvironment() {
        Ground ground1 = new Ground(this, 18.8f);
        ground1.setPosition(new Vec2(-21.2f, -19f));

        Ground ground2 = new Ground(this, 10.4f);
        ground2.setPosition(new Vec2(4.6f,-9));
        ground2.rotateDegrees(new Vec2(16,-9), 28);

        Ground ground3 = new Ground(this, 12.49f);
        ground3.setPosition(new Vec2(27.51f,-9.5f));

        Checkpoint checkpoint = new Checkpoint(this);
        checkpoint.setPosition(new Vec2(39.99f, 0));
    }

    private void createPlayer() {
        player = new Player(this);
        player.setPosition(new Vec2(-35,-15));
        player.setGravityScale(10);
        player.addCollisionListener(this);
    }

    public void createSwordsman() {
        player.destroy();
        gameView.removeKeyListener(playerController);
        swordsman = new Swordsman(this);
        swordsman.setPosition(new Vec2(-30,-15));
    }

    public void createEnemy() {
        enemy = new Enemy(this);
        enemy.setPosition(new Vec2(35,35));
        enemy.setGravityScale(0.35f);
    }

    public void destroyCharacters() {
        swordsman.destroy();
        enemy.destroy();
    }

    public void collide(CollisionEvent ce) {
        if (ce.getOtherBody() instanceof Checkpoint &&
                sceneHandler.getScene() != 5) {
            player.setPosition(new Vec2(-35,-15));
            playerController.setSpeed(playerController.getSpeed()+1);
            sceneHandler.callNextScene();
        }
        else if (ce.getOtherBody() instanceof Checkpoint &&
                sceneHandler.getScene() == 5) {
            player.setPosition(new Vec2(-35,-15));
            playerController.setSpeed(0);
            sceneHandler.callNextScene();
            sceneHandler.startTimer();

            createEnemy();
        }
    }

    public void enablePlayerControls() {
        playerController = new PlayerController(player);
        gameView.addKeyListener(playerController);
    }
}
