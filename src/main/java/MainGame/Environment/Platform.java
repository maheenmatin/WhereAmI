package MainGame.Environment;

import city.cs.engine.World;

public class Platform {
    private final World world;
    int endX = -10;

    public Platform(World world, int count) {
        this.world = world;
        new Wall(world, endX - 10, 25);

        for (int i = count * 6; i > 0; i--) {
            new Spike(world);
        }
        for (; count > 0; count--) {
            endX = createGround(endX) + 35;
        }
        new Wall(world, endX - 25, 25);
    }

    public int getEndX() {
        return endX;
    }

    public int createGround(int startX) {
        new Ground(world, startX, -10);
        new Ground(world, startX + 20, -10);
        new Ground(world, startX + 60, -10);

        new Stairs(world, startX + 95, -6, false);
        new Ground(world, startX + 110, -2);
        new Ground(world, startX + 130, -2);
        new Stairs(world, startX + 145, -6, true);

        new Ground(world, startX + 180, -10);
        new Ground(world, startX + 225, -10);
        new Ground(world, startX + 245, -10);

        new Stairs(world, startX + 280, -6, false);
        new Ground(world, startX + 295, -2);
        new Stairs(world, startX + 310, -6, true);

        new Ground(world, startX + 345, -10);
        new Ground(world, startX + 380, -10);

        new Stairs(world, startX + 415, -6, false);
        new Ground(world, startX + 430, -2);
        new Stairs(world, startX + 445, -6, true);

        new Ground(world, startX + 480, -10);

        return startX + 480;
    }
}
