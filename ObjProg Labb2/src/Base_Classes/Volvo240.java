package Base_Classes;

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
    public Volvo240(double x, double y, Direction direction){
        super(x, y, direction, 200, 0, 200, 1, 1);
        addFactor(Enum_AccelerationFactor.TRIMFACTOR, 1.3);
    }
    public Volvo240(){
        super(0, 0, Direction.NORTH, 200, 0, 200, 1, 1);
        addFactor(Enum_AccelerationFactor.TRIMFACTOR, 1.3);
    }
}
