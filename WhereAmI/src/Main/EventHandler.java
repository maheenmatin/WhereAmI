package Main;

public class EventHandler {
    private static Game game;
    private static GameWorld world;
    private static GameView view;
    private static Hero hero;
    private static HeroController controller;
    private static EventController controlRestart;

    private static int highScore = 0;

    public static void setFields(Game g) {
        game = g;
    }

    public static void setFields(GameWorld w, GameView v) {
        world = w;
        view = v;
        hero = world.getHero();
    }

    public static void callEnd() {
        game.timerStop();
        world.timerStop();
        Enemy.destroyAllEnemies();

        view.removeKeyListener(controller);
        hero.destroy();

        if (view.getScore() > highScore) {
            highScore = view.getScore();
        }
        view.setHighScore(highScore);

        view.setActiveGame(false);

        EventController controlRestart = new EventController();
        view.addKeyListener(controlRestart);
    }

    public static void updateTime() {
        if (view.getTime() > 0) {
            view.setTime(view.getTime() - 1);
        } else if (view.getTime() <= 0 ) {
            callEnd();
        }
    }

    public static void updateScore() {
        view.setScore(view.getScore() + 1);
    }

    public static void restart() {
        GameAudio.stopSound();

        Enemy.initialize();
        world.stop();

        Master.Master.callChapter();
    }
}