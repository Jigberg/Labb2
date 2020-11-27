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
    private Movable movable = new Movable(0, 0, Direction.NORTH, speed)
    private Movable movable = new Movable(0, 0, Direction.NORTH, true, true, true);
    private IVehicle IVehicle;
    private Speed speed = new Speed(0,100,new BasicTrimFactorStrat() );

    public void stopEngine(){ getVehicleProperties().stopEngine(speed); }
    public void startEngine(){ getVehicleProperties().startEngine(speed); }
    public void gas(double amount){getVehicleProperties().gas(amount, speed); }
    public void brake(double amount){getVehicleProperties().brake(amount, speed); }
    IVehicle getVehicleProperties(){ return this.IVehicle; }
    Speed getSpeed(){ return this.speed; }
    public void move(){ getMovable().move(getSpeed()); }
    public void turnRight(){
        getMovable().turnRight();
    }
    public void turnLeft(){
        getMovable().turnLeft();
    }

    Movable getMovable(){ return this.movable; }
}
