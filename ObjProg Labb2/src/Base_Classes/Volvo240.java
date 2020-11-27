package Base_Classes;

import Uncategorized.IVehicle;
import java.awt.*;
import SpeedChange.*;
import Movement.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Vehicles.Volvo240
 */

public class Volvo240{
    private Movable movable = new Movable(0, 0, Direction.NORTH, true, true, true);
    private IVehicle IVehicle;
    private Speed speed = new Speed(0,100,new BasicTrimFactorStrat(1.3, getVehicleProperties()) );

    public Volvo240(){
        this.IVehicle = new IVehicle(200, Color.ORANGE, "Volvo240");
    }
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
