package Base_Classes;

import Movement.Movable;

public class WallabyCub{
    Movable movable = new Movable(0, 0, Movement.Direction.NORTH, true, true, 25);

    public Movable getMovable(){ return this.movable; }
}
