package Master;

import Main.Characters.Player;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private final GameView gameView;
    private final Player player;

    public Tracker(GameView gameView, Player player) {
        this.gameView = gameView;
        this.player = player;
    }

    @Override
    public void postStep(StepEvent se) {
        gameView.setCentre(new Vec2(player.getPosition()));
    }
    @Override
    public void preStep(StepEvent se) {}
}
