package Ramp;

import Base_Classes.Car_Transport;

public class Car_TransportRamp extends Ramp<Car_Transport> {
    public Car_TransportRamp(int angle, Car_Transport attachedTo) {
        super(angle, 90, 0, attachedTo);
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
    boolean isSecured() { return getAngle() == getMaxAngle(); }
}
