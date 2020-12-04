package Base_Classes;

import Movement.Movable;
import SpeedChange.SpeedChangeStrat;

public class WallabyCub{
    Movable movable = new Movable(0, 0, Movement.Direction.NORTH, true, true, 25, SpeedChangeStrat.NO_STRAT, 0);

    public Movable getMovable(){ return this.movable; }
}
