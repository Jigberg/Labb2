package Base_Classes;
import Movement.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A superclass for vehicles.
 */

public abstract class Vehicle {
    private final Movable movable;

    /**
     * Constructor that also sets the vehicle to a not-movable state to begin with.
     * Also sets an image, standard Volvo.
     * @param x position on x-axis
     * @param y position on y-axis.
     * @param direction direction facing.
     * @param maxForwardSpeed max speed forward.
     * @param maxBackwardsSpeed max speed backwards.
     * @param power the engine power.
     * @param maxAcceleration max acceleration.
     * @param maxDeceleration max deceleration.
     */
    public Vehicle (double x, double y, Direction direction,double maxForwardSpeed, double maxBackwardsSpeed, double power, double maxAcceleration, double maxDeceleration){
        this.movable = new Movable(x, y, direction, false, maxForwardSpeed, maxBackwardsSpeed, power, maxAcceleration, maxDeceleration);
    }

    public void addFactor(Enum_AccelerationFactor enum_accelerationFactor, double value){ getMovable().addFactor(enum_accelerationFactor, value); }
    public void removeFactor(int index){ getMovable().removeFactor(index); }
    public void removeFactor(Enum_AccelerationFactor enum_accelerationFactor){ getMovable().removeFactor(enum_accelerationFactor); }


    /**
     * Calls the methods "move", "turnRight" and "turnLeft" in the class movable.
     */
    public void move(){getMovable().move();}
    public void turnRight(){getMovable().turnRight();}
    public void turnLeft(){getMovable().turnLeft();}

    /**
     * Stops the engine of the vehicle, haling its speed and making it unable to move.
     */
    public void stopEngine(){
        getMovable().setCurrentSpeed(0);
        getMovable().getStates().setCanMove(false);
    }

    /**
     * Makes the vehicle able to move.
     */
    public void startEngine(){
        getMovable().getStates().setCanMove(true);
    }


    /**
     * Calls "IncreaseSpeed" in Speed, with a factor 0 - 1 called amount.
     * @param amount A factor chosen by the user.
     */
    public void gas(double amount){
        if(0 <= amount && amount <= 1){ getMovable().increaseSpeed(amount); }
        else if(amount > 1){getMovable().increaseSpeed(1);}
    }

    /**
     * Calls "decreaseSpeed" in Speed, with a factor 0 - 1 called amount.
     * @param amount A factor chosen by the user.
     */
    public void brake(double amount){
        if(0 <= amount && amount <= 1){ getMovable().decreaseSpeed(amount); }
        else if(amount > 1){ getMovable().decreaseSpeed(1); }
    }

    /**
     * The vehicles current position in y.
     */
    public double positionY(){
        return getMovable().gety();
    }

    /**
     * The vehicles current position in x.
     */
    public double positionX(){
        return getMovable().getx();
    }

    /**
     * @return the direction the vehicle is facing.
     */
    public Direction direction(){
        return getMovable().getDirection();
    }

    /**
     *
     * @return the current speed of the vehicle.
     */
    public double currentSpeed(){
        return getMovable().getCurrentSpeed();
    }

    /**
     * Getters and setters below.
     */
    public Movable getMovable(){ return this.movable; }

}

