package Base_Classes;

import Uncategorized.IVehicle;
import java.awt.*;
import SpeedChange.*;
import Movement.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Vehicles.Volvo240
 */

public class Volvo240 implements IVehicle{
    private Movable movable = new Movable(0, 0, Direction.NORTH, true, true, 200, new BasicTrimFactorStrat(1.25));


    public void move(){ getMovable().move(); }
    public void turnRight(){getMovable().turnRight();}
    public void turnLeft(){getMovable().turnLeft();}

    @Override
    public void stopEngine(){getMovable().setCurrentSpeed(0);}

    @Override
    public void startEngine(){getMovable().setCurrentSpeed(0.1);}

    @Override
    public void gas(double amount){getMovable().increaseSpeed(amount); }

    @Override
    public void brake(double amount){getMovable().decreaseSpeed(amount);}

    public Movable getMovable(){ return this.movable; }
}
