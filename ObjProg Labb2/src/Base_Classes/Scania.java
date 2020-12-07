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
    public Scania(){
        super(400, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.NO_STRAT, 0);

        try {
            setImage(ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Scania.jpg")));
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
            System.out.println("Angle: " + getRamp().getAngle());
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
            System.out.println("Angle: " + getRamp().getAngle());
            if(isSecured()){
                getMovable().getStates().setCanMove(true);
            }
        }
    }

    /**
     * Starts the engine, but only when the ramp is secured
     */
    @Override
    public void startEngine(){
        if(isSecured()){
            getMovable().getStates().setCanMove(true);
        }
    }

    /**
     * @return if the ramp is secured, which in this case is when the ramp is in its minimum angle.
     */
    boolean isSecured() { return getRamp().getAngle() == getRamp().getMinAngle(); }

    private boolean isBeingTransported = false;

    /**
     * Getters and setters below.
     */
    private Ramp getRamp(){ return this.ramp; }
    public boolean getIsMovable() { return !isBeingTransported; }
    public BufferedImage getImage(){return image; }

}
