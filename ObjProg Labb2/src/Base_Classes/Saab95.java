package Base_Classes;
import Movement.Enum_AccelerationFactor;
import Movement.Turbo;
import Movement.Direction;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map;

/**
 * @author Lukas, Emil, Martin.
 * Class for Saab95.
 */
public class Saab95 extends Vehicle {

    /**
     * Constructor for Saab95.
     * Sets an image for the Saab.
     */
    public Saab95(double x, double y, Direction direction){
        super(x, y, direction, 200, 0, 200, 1, 1);
        addFactor(Enum_AccelerationFactor.TURBO, 1.25);
    }
    public Saab95(){
        super(0, 0, Direction.NORTH, 200, 0, 200, 1, 1);
        addFactor(Enum_AccelerationFactor.TURBO, 1.25);
    }

    /**
     * Turns the turbo on
     */
    public void turboON(){
        turboOFF();
        addFactor(Enum_AccelerationFactor.TURBO, 1.25);
    }

    /**
     * Turns the turbo off
     */
    public void turboOFF(){ removeFactor(Enum_AccelerationFactor.TURBO);  }
}
