package Base_Classes;

import Movement.Direction;
import Movement.Movable;

public class KangarooCub {
    Movable movable = new Movable(0, 0, Movement.Direction.NORTH, true, true, 25);

    public Movable getMovable(){ return this.movable; }
}
