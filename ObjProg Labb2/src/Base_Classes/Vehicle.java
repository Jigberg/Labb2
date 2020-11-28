package Base_Classes;
import Movement.Movable;
import Movement.Speed;
import SpeedChange.SpeedChangeStrategy;
import Movement.*;

import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A superclass for vehicles reflecting a car.
 */

public abstract class Vehicle {
    private final Movable movable;

    public Vehicle (int x, int y, Direction direction, boolean isMovable, boolean isTransportable, Double power, SpeedChangeStrategy strat, double maxForwardSpeed, double maxBackwardsSpeed, double maxSpeedIncrease , double maxSpeedDecrease){
        movable = new Movable(x, y, direction, isMovable, isTransportable, power, strat, maxForwardSpeed, maxBackwardsSpeed, maxSpeedIncrease, maxSpeedDecrease);
    }

    public Vehicle (int x, int y, Direction direction, boolean isMovable, boolean isTransportable, Double power, SpeedChangeStrategy strat){
        movable = new Movable(x, y, direction, isMovable, isTransportable, power, strat);
    }

    public void move(){getMovable().move();}

    public void turnRight(){getMovable().turnRight();}

    public void turnLeft(){getMovable().turnLeft();}

    public void stopEngine(){getMovable().setCurrentSpeed(0);}
    public void startEngine(){getMovable().setCurrentSpeed(0.1);}
    public void gas(double amount){getMovable().increaseSpeed(amount); }
    public void brake(double amount){getMovable().decreaseSpeed(amount);}

    public Movable getMovable(){return movable;}
}

