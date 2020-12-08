package Base_Classes;
import SpeedChange.*;
import Movement.Direction;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Lukas, Emil, Martin.
 * Class for Saab95.
 */
public class Saab95 extends Vehicle {

    /**
     * Constructor for Saab95.
     * Sets an image for the Saab.
     */
    public Saab95(){
        super(200, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.BASIC_TURBO_STRAT, 10);
    }

    /**
     * Turns the turbo on
     */
    public void turboON(){
        getMovable().getSpeedChangeStratFactory().getStrat().getTurbo().setTurboOn(true);
    }

    /**
     * Turns the turbo off
     */
    public void turboOFF(){ getMovable().getSpeedChangeStratFactory().getStrat().getTurbo().setTurboOn(false); }
}
