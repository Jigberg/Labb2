package Base_Classes;

import SpeedChange.BasicTurboStrat;
import Movement.Speed;
import Movement.Direction;
import Movement.Movable;
import Movement.Positionable;
import Uncategorized.IVehicle;


import java.awt.*;

public class Saab95 implements Movable, IRotatables {
    private Positionable positionable = new Positionable(0, 0, Direction.NORTH, true, true);
    private IVehicle IVehicle = new IVehicle(200, Color.YELLOW, "Saab95");
    private Speed speed = new Speed(0,100,new BasicTurboStrat(1.3, getVehicleProperties()) );

    void stopEngine(){ getVehicleProperties().stopEngine(speed); }
    void startEngine(){ getVehicleProperties().startEngine(speed); }
    void gas(double amount){getVehicleProperties().gas(amount, speed); }
    void brake(double amount){getVehicleProperties().brake(amount, speed); }

    IVehicle getVehicleProperties(){ return this.IVehicle; }
    Speed getSpeed(){ return this.speed; }
    Positionable getPositionables(){ return this.positionable; }

    @Override
    public boolean getIsMovable() {
        return false;
    }

    public void move(){
        move(getPositionables(), getSpeed());
    }
    public void turnLeft(){turnLeft(positionable);}
    public void turnRight(){turnRight(positionable);}

}
