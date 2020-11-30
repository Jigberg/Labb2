package Ramp;

import Movement.Speed;

public abstract class Ramp<A> {
    private int angle;
    private int maxAngle;
    private int minAngle;
    private A attachedTo;

    public Ramp(int angle, int maxAngle, int minAngle, A attachedTo){
        this.angle = angle;
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;
        this.attachedTo = attachedTo;

    }

    /**
     * Raises ramp.
     * @param angle to raise platform.
     */
    abstract void raiseRamp(int angle);

    /**
     * Lowers ramp.
     * @param angle to lower platform.
     */
    abstract void lowerRamp(int angle) ;

    abstract boolean isSecured();
    int raisableAngle(){ return getMaxAngle() - getAngle(); }
    int lowerableAngle(){ return getAngle() - getMinAngle(); }
    public int getAngle(){ return this.angle; }
    public void setAngle(int angle){ this.angle = angle; }
    int getMaxAngle(){ return this.maxAngle; }
    int getMinAngle(){ return this.minAngle; }
    A getAttachedTo(){ return this.attachedTo; }
}
