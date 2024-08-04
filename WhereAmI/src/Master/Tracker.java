package Master;

import Main.Characters.Player;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private final GameView gameView;
    private final Player player;

    public Tracker(GameView gameView, Player player) {
        this.player = player;
        this.gameView = gameView;
    }

    public void postStep(StepEvent stepEvent) {
        gameView.setCentre(new Vec2(player.getPosition()));
    }

    public void preStep(StepEvent stepEvent) {}
}
