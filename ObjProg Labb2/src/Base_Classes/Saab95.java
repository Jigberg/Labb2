package Base_Classes;
import Graphical.FrameDrawPanel;
import SpeedChange.*;
import Movement.Direction;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Saab95 extends Vehicle {
    BasicTurboStrat basicTurboStrat; // this is bad. we don't want an instance of this.

    public Saab95(){
        super(200, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.BASIC_TURBO_STRAT, 10);

        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.

            this.image = ImageIO.read(FrameDrawPanel.class.getResourceAsStream("pics/Saab95.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public void turboON(){
        getMovable().getSpeedChangeStratFactory().getStrat().getTurbo().setTurboOn(true);
    }

    public void turboOFF(){
        getMovable().getSpeedChangeStratFactory().getStrat().getTurbo().setTurboOn(false);

    }

    public BufferedImage getImage(){ return image; }


}
