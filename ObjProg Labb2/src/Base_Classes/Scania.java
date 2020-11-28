package Base_Classes;

import SpeedChange.NoStrat;
import Movement.Speed;
import Movement.Direction;
import Movement.Movable;
import Movement.Positionable;
import Ramp.*;
import Uncategorized.IVehicle;

import java.awt.*;

public class Scania implements IVehicle {
    private final Movable movable = new Movable(0, 0, Direction.NORTH, true, true, 200, new NoStrat());

    Ramp<Scania> ramp = new ScaniaRamp(0, this);
    private boolean isBeingTransported = false;

    Ramp<Scania> getRamp(){ return this.ramp; }

    public void move(){getMovable().move();}

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


    public Movable getMovable() {return this.movable; }

    public boolean getIsMovable() {
        return !isBeingTransported;
    }

}
