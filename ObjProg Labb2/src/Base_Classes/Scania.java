package Base_Classes;

import Movement.*;
import Ramp.*;
import SpeedChange.SpeedChangeStrat;


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
    public Scania(){
        super(400, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.NO_STRAT, 0);

    }

    Ramp ramp = new Ramp(0, 70, 0, 0);

    /**
     * Starts the engine, but only when the ramp is secured
     */
    @Override
    public void startEngine(){
        if(getRamp().isSecured()){
            getMovable().getStates().setCanMove(true);
        }
    }

    /**
     * Getters and setters below.
     */
    public Ramp getRamp(){ return this.ramp; }

}
