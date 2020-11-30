package Base_Classes;
import Movement.Movable;
import Movement.Speed;
import SpeedChange.NoStrat;
import SpeedChange.SpeedChangeStrategy;
import Movement.*;

import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A superclass for vehicles reflecting a car.
 */

public abstract class Vehicle {
    private final Movable movable;

    public Vehicle (int x, int y, Direction direction, boolean isMovable, boolean isTransportable, Double power, double maxForwardSpeed, double maxBackwardsSpeed, double maxSpeedIncrease , double maxSpeedDecrease){
        movable = new Movable(x, y, direction, isMovable, isTransportable, power, maxForwardSpeed, maxBackwardsSpeed, maxSpeedIncrease, maxSpeedDecrease);
    }

    public Vehicle (int x, int y, Direction direction, boolean isMovable, boolean isTransportable, Double power){
        movable = new Movable(x, y, direction, isMovable, isTransportable, power, power, 0, 20, 20);

    }

    public void move(){getMovable().move();}

    public void turnRight(){getMovable().turnRight();}

    public void turnLeft(){getMovable().turnLeft();}

    public void stopEngine(){getMovable().setCurrentSpeed(0);}
    public void startEngine(){getMovable().setCurrentSpeed(0.1);}
    public void gas(double amount){ if(0 <= amount && amount <= 1){getMovable().increaseSpeed(amount);} }
    public void brake(double amount){ if(0 <= amount && amount <= 1){getMovable().decreaseSpeed(amount);}}

    public Movable getMovable(){return movable;}
}

