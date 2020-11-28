package Ramp;

import Base_Classes.Scania;

public class ScaniaRamp extends Ramp<Scania>{
    public ScaniaRamp(int angle, Scania attachedTo) {
        super(angle, 70, 0, attachedTo);
    }

    /**
     * Raises ramp.
     * @param angle to raise platform.
     */
    public void raiseRamp(int angle){
        if(!getAttachedTo().getMovable().getStates().getCurrentlyHasSpeed()) {
            setAngle(Math.min(raisableAngle(), angle));
            if(!isSecured()){
                getAttachedTo().getMovable().getStates().setCanMove(false);
            }
        }
    }

    /**
     * Lowers ramp.
     * @param angle to lower platform.
     */
    public void lowerRamp(int angle) {
        if(!getAttachedTo().getMovable().getStates().getCurrentlyHasSpeed()) {
            setAngle(Math.min(lowerableAngle(), angle));
            if(isSecured()){
                getAttachedTo().getMovable().getStates().setCanMove(true);
            }
        }
    }

    @Override
    boolean isSecured() { return getAngle() == getMinAngle(); }
}
