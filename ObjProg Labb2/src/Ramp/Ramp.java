package Ramp;

import Movement.Speed;

public abstract class Ramp<A> {
    private int angle;
    private int maxAngle;
    private int minAngle;
    private int loadableAngle;
    private A attachedTo;

    public Ramp(int angle, int maxAngle, int minAngle, int loadableAngle, A attachedTo){
        this.angle = angle;
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;
        this.loadableAngle = loadableAngle;
        this.attachedTo = attachedTo;

    }

    // java.lang.NullPointerException: Cannot invoke
    // "Positions.Movables.getCurrentSpeed()" because the return value of "Ramps.Ramp.getAttachedTo()" is null

    /**
     * Raises ramp.
     * @param angle to raise platform.
     */
    public void raiseRamp(int angle, Speed speed){
        if(speed.getCurrentSpeed()==0) {
            setAngle(Math.min(raisableAngle(), angle));
            /*if(!isSecured()){
                attachedTo.setIsMovable(false);
            }*/
        }
    }
    /**
     * Lowers ramp.
     * @param angle to lower platform.
     */
    public void lowerRamp(int angle, Speed speed) {
        if(speed.getCurrentSpeed()==0) {
            setAngle(Math.min(lowerableAngle(), angle));
            /*if(isSecured()){
                attachedTo.setIsMovable(true);
            }*/
        }
    }
    abstract boolean isSecured();
    void setLoadableAngle(){ setAngle(getLoadableAngle()); }
    int getLoadableAngle(){ return this.loadableAngle; }
    int raisableAngle(){ return getMaxAngle() - getAngle(); }
    int lowerableAngle(){ return getAngle() - getMinAngle(); }
    public int getAngle(){ return this.angle; }
    public void setAngle(int angle){ this.angle = angle; }
    int getMaxAngle(){ return this.maxAngle; }
    int getMinAngle(){ return this.minAngle; }
    A getAttachedTo(){ return this.attachedTo; }
}
