package Base_Classes;

import SpeedChange.NoStrat;
import Movement.Speed;
import Movement.Direction;
import Movement.Movable;
import Movement.Positionable;
import Ramp.*;
import Uncategorized.IVehicle;

import java.awt.*;

public class Scania implements Movable, IRotatables {
    IVehicle IVehicle = new IVehicle(300, Color.BLUE, "The Scania");
    private Positionable positionable = new Positionable(0, 0, Direction.NORTH, true, true);
    private Speed speed = new Speed(0,100,new NoStrat());
    Ramp<Scania> ramp = new ScaniaRamp(0, this);
    private boolean isBeingTransported = false;

    public void stopEngine(){ getVehicleProperties().stopEngine(speed); }
    public void startEngine(){ getVehicleProperties().startEngine(speed); }
    public void gas(double amount){getVehicleProperties().gas(amount, speed); }
    public void brake(double amount){getVehicleProperties().brake(amount, speed); }
    IVehicle getVehicleProperties(){ return this.IVehicle; }
    Speed getSpeed(){ return this.speed; }
    Positionable getPositionables(){ return this.positionable; }
    Ramp<Scania> getRamp(){ return this.ramp; }

    @Override
    public boolean getIsMovable() {
        return !isBeingTransported;
    }

    public void move(){ move(getPositionables(), getSpeed()); }
    public void turnLeft(){turnLeft(positionable);}
    public void turnRight(){turnRight(positionable);}
    public void raiseRamp(int angle){ getRamp().raiseRamp(angle, getSpeed());}
}
