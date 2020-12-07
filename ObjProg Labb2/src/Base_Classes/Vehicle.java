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
    BufferedImage image;

    /**
     * Constructor that also sets the vehicle to a not-movable state to begin with.
     * Also sets an image, standard Volvo.
     * @param x
     * @param y
     * @param direction
     * @param isMovable
     * @param isTransportable
     * @param power
     * @param maxForwardSpeed
     * @param maxBackwardsSpeed
     * @param maxSpeedIncrease
     * @param maxSpeedDecrease
     * @param speedChangeStrat
     * @param speedChangeStratValue
     */
    public Vehicle (int x, int y, Direction direction, boolean isMovable, boolean isTransportable, Double power, double maxForwardSpeed, double maxBackwardsSpeed,
                    double maxSpeedIncrease , double maxSpeedDecrease, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue){
        movable = new Movable(x, y, direction, isMovable, isTransportable, power, maxForwardSpeed, maxBackwardsSpeed, maxSpeedIncrease, maxSpeedDecrease,
                    speedChangeStrat, speedChangeStratValue);
    }

    /**
     * Constructor that also sets the vehicle to a not-movable state to begin with.
     * Also sets an image, standard Volvo.
     * @param x
     * @param y
     * @param direction
     * @param isMovable
     * @param isTransportable
     * @param power
     * @param speedChangeStrat
     * @param speedChangeStratValue
     */
    public Vehicle (int x, int y, Direction direction, boolean isMovable, boolean isTransportable, Double power, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue){
        movable = new Movable(x, y, direction, isMovable, isTransportable, power, power, 0, 20, 20,  speedChangeStrat, speedChangeStratValue);
        getMovable().getStates().setCanMove(false);

        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            this.image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

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
        else if(amount > 1){getMovable().decreaseSpeed(1);}
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
    public Movable getMovable(){return movable;}
    public BufferedImage getImage(){ return image; }
    void setImage(BufferedImage image){ this.image = image; }
}

