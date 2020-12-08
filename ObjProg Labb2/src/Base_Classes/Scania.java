package Base_Classes;

import Movement.*;
import Ramp.*;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Lukas, Emil, Martin.
 * Class for Scania.
 */
public class Scania extends Vehicle {

    /**
     * Constructor for Scania.
     * Sets an image for the Scania.
     */
    public Scania(double x, double y, Direction direction){ super(x, y, direction, 200, 0, 200, 1, 1); }
    public Scania(){ super(0, 0, Direction.NORTH, 200, 0, 200, 1, 1); }

    Ramp ramp = new Ramp(0, 70, 0, 0, getMovable());

    /**
     * Starts the engine, but only when the ramp is secured
     */
    @Override
    public void startEngine(){
        if(getRamp().isSecured()){
            getMovable().getStates().setCanMove(true);
        }
    }
    public void raiseRamp(int angle){ getRamp().raiseRamp(angle); }
    public void lowerRamp(int angle){ getRamp().lowerRamp(angle); }

    /**
     * Getters and setters below.
     */
    public Ramp getRamp(){ return this.ramp; }

}
