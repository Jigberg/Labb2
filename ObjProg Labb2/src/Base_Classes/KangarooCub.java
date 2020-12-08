package Base_Classes;
import Movement.*;

public class KangarooCub {
    /**
     * Movable object for all moving functionality.
     */
    private final Movable movable;

    public KangarooCub(double x, double y, Direction direction){ this.movable = new Movable(x, y, direction, true, 50, 50, 1, 1, 1); }
    public KangarooCub(){ this.movable = new Movable(0, 0, Direction.NORTH, true, 0, 50, 1, 1, 1); }

    /**
     * Getters and setters below.
     */
    public Movable getMovable(){ return this.movable; }
}
