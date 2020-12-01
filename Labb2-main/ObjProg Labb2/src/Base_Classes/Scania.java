package Base_Classes;

import Graphical.DrawPanel;
import SpeedChange.NoStrat;
import Movement.*;
import Ramp.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scania extends Vehicle {
    BufferedImage image;

    public Scania(){
        super(400, 0, Direction.NORTH, true, true, 200.0);

        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            this.image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void raiseRamp(int angle){ getRamp().raiseRamp(angle); System.out.println("raising ramp!" + "  " + getRamp().getAngle()); }
    public void lowerRamp(int angle){ getRamp().lowerRamp(angle); System.out.println("lowering ramp!" + "  " + getRamp().getAngle());}

    ScaniaRamp ramp = new ScaniaRamp(0, this);
    private boolean isBeingTransported = false;
    ScaniaRamp getRamp(){ return this.ramp; }
    public boolean getIsMovable() { return !isBeingTransported; }
    public BufferedImage getImage(){return image; }


}
