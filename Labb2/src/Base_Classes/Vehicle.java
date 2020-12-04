package Base_Classes;
import Graphical.DrawPanel;
import Movement.*;
import SpeedChange.SpeedChangeStrat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A superclass for vehicles reflecting a car.
 */

public abstract class Vehicle {
    private final Movable movable;
    BufferedImage image;

    public Vehicle (int x, int y, Direction direction, boolean isMovable, boolean isTransportable, Double power, double maxForwardSpeed, double maxBackwardsSpeed,
                    double maxSpeedIncrease , double maxSpeedDecrease, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue){
        movable = new Movable(x, y, direction, isMovable, isTransportable, power, maxForwardSpeed, maxBackwardsSpeed, maxSpeedIncrease, maxSpeedDecrease,
                    speedChangeStrat, speedChangeStratValue);
    }

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

    public void move(){getMovable().move();}

    public void turnRight(){getMovable().turnRight();}

    public void turnLeft(){getMovable().turnLeft();}

    public void stopEngine(){
        getMovable().setCurrentSpeed(0);
        getMovable().getStates().setCanMove(false);
    }
    public void startEngine(){
        getMovable().getStates().setCanMove(true);
    }

    public void gas(double amount){
        if(0 <= amount && amount <= 1){ getMovable().increaseSpeed(amount); }
        else if(amount > 1){getMovable().increaseSpeed(1);}
    }
    public void brake(double amount){
        if(0 <= amount && amount <= 1){ getMovable().decreaseSpeed(amount); }
        else if(amount > 1){getMovable().decreaseSpeed(1);}
    }

    public double positionY(){
        return getMovable().gety();
    }

    public double positionX(){
        return getMovable().getx();
    }

    public Direction direction(){
        return getMovable().getDirection();
    }


    public double currentSpeed(){
        return getMovable().getCurrentSpeed();
    }
    public Movable getMovable(){return movable;}
    public BufferedImage getImage(){ return image; }
}

