package Ramp;

import Movement.Movable;

import javax.sound.midi.SysexMessage;

/**
 * @author Lukas, Emil, Martin.
 * A class for a ramp.
 */
public class Ramp{
    private int angle;
    private final int maxAngle;
    private final int minAngle;
    private Movable attachedToMovable;
    private int securedAngle;

    public Ramp(int angle, int maxAngle, int minAngle, int securedAngle, Movable attachedToMovable){
        this.angle = angle;
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;
        this.securedAngle = securedAngle;
        this.attachedToMovable = attachedToMovable;

    }
    /**
     * Raises ramp.
     * @param angle to raise platform.
     */
    public void raiseRamp(int angle){
        if(getAttachedToMovable().getCurrentSpeed() == 0) {
            setAngle(getAngle() + Math.min(raisableAngle(), angle));
            getAttachedToMovable().getStates().setCanMove(isSecured());
            System.out.println("Raising ramp, angle is: " + getAngle());
        }
    }
    /**
     * Lowers ramp.
     * @param angle to lower platform.
     */
    public void lowerRamp(int angle) {
        if(getAttachedToMovable().getCurrentSpeed() == 0) {
            setAngle(getAngle() - Math.min(lowerableAngle(), angle));
            getAttachedToMovable().getStates().setCanMove(isSecured());
            System.out.println("Lowering ramp, angle is: " + getAngle());
        }
    }
    /**
     * If ramp is secured, starts the engine by setting canMove to true.
     */
    /**
     *
     * @return the angle that is possible to raise based on maxangle, specified when constructing the ramp.
     */
    public int raisableAngle(){ return getMaxAngle() - getAngle(); }


    /**
     *
     * @return the angle that is possible to lower based on minangle, specified when constructing the ramp.
     */
    public int lowerableAngle(){ return getAngle() - getMinAngle(); }

    /**
     * Getters and setters below.
     */

    /**
     * @return if ramp angle is at max.
     */
    public boolean isSecured() { return getAngle() == getSecuredAngle(); }

    public int getSecuredAngle(){ return this.securedAngle; }
    public Movable getAttachedToMovable(){ return this.attachedToMovable; }
    public int getAngle(){ return this.angle; }
    public void setAngle(int angle){ this.angle = angle; }
    public int getMaxAngle(){ return this.maxAngle; }
    public int getMinAngle(){ return this.minAngle; }
}
