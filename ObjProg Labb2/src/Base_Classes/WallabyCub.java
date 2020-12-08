package Base_Classes;

import Movement.Direction;
import Movement.Movable;

public class WallabyCub{
    private final Movable movable;
    /**
     * Movable object for all moving functionality.
     */
    public WallabyCub(double x, double y, Direction direction){ this.movable = new Movable(x, y, direction, true, 25, 25, 1, 1, 1); }
    public WallabyCub(){ this.movable = new Movable(0, 0, Direction.NORTH, true, 0, 25, 1, 1, 1); }

    /**
     * Getters and setters below.
     */
    public Movable getMovable(){ return this.movable; }
}
