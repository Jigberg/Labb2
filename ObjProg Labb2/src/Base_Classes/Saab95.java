package Base_Classes;

import Carry.IHaveWorkshop;
import SpeedChange.BasicTurboStrat;
import Movement.Speed;
import Movement.Direction;
import Movement.Movable;


import java.awt.*;

public class Saab95 implements IHaveWorkshop {
    Speed speed = new Speed(0, 200, new BasicTurboStrat(1.25), 10, 5, 1, 1)
    Movable movable = new Movable(0, 0, Direction.NORTH, speed, true, true, true);


    public Movable getMovable() {return this.movable; }
}
