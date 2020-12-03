package Base_Classes;

import Graphical.DrawPanel;
import SpeedChange.NoStrat;
import Movement.*;
import Ramp.*;
import SpeedChange.SpeedChangeStrat;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Scania extends Vehicle {
    BufferedImage image;

    public Scania(){
        super(400, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.NO_STRAT, 0);

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

    Ramp ramp = new Ramp(0, 70, 0);

    /**
     * Raises ramp.
     * @param angle to raise platform.
     */
    public void raiseRamp(int angle){
        if(!getMovable().getStates().getCurrentlyHasSpeed()) {
            getRamp().setAngle(getRamp().getAngle() + Math.min(getRamp().raisableAngle(), angle));
            if(!isSecured()){
                getMovable().getStates().setCanMove(false);
            }
        }
    }

    /**
     * Lowers ramp.
     * @param angle to lower platform.
     */
    public void lowerRamp(int angle) {
        if(!getMovable().getStates().getCurrentlyHasSpeed()) {
            getRamp().setAngle(getRamp().getAngle() - Math.min(getRamp().lowerableAngle(), angle));
            if(isSecured()){
                getMovable().getStates().setCanMove(true);
            }
        }
    }

    @Override
    public void startEngine(){
        if(isSecured()){
            getMovable().getStates().setCanMove(true);
        }
    }


    boolean isSecured() { return getRamp().getAngle() == getRamp().getMinAngle(); }

    private boolean isBeingTransported = false;
    Ramp getRamp(){ return this.ramp; }
    public boolean getIsMovable() { return !isBeingTransported; }
    public BufferedImage getImage(){return image; }

}
