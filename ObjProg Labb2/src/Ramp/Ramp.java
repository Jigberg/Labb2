package Ramp;

import Movement.Speed;

/**
 * @author Lukas, Emil, Martin.
 * A class for a ramp.
 */
public class Ramp{
    private int angle;
    private final int maxAngle;
    private final int minAngle;

    public Ramp(int angle, int maxAngle, int minAngle){
        this.angle = angle;
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;

    }

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
    public int getAngle(){ return this.angle; }
    public void setAngle(int angle){ this.angle = angle; }
    public int getMaxAngle(){ return this.maxAngle; }
    public int getMinAngle(){ return this.minAngle; }
}
