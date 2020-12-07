package Base_Classes;


public class KangarooCub {
    /**
     * Movable object for all moving functionality.
     */
    private final Movable movable = new Movable(0, 0, Movement.Direction.NORTH, true, true, 25, SpeedChangeStrat.NO_STRAT, 0);

    /**
     * Getters and setters below.
     */
    public Movable getMovable(){ return this.movable; }
}
