package Base_Classes;

import Graphical.DrawPanel;
import SpeedChange.*;
import Movement.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Vehicles.Volvo240
 */

public class Volvo240 extends Vehicle {

    /**
     * Constructor for Volvo240.
     * Sets an image for the Volvo.
     */
    public Volvo240(){
        super(0, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.BASIC_TRIMFACTOR_STRAT, 1.3);
        try{
            setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg")));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }
}
