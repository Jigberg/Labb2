package Ramps;

import Base_Classes.Car_Transport;

public class Car_TransportRamp extends Ramp<Car_Transport> {
    public Car_TransportRamp(int angle, Car_Transport attachedTo) {
        super(angle, 90, 0, 45, attachedTo);
    }

    @Override
    boolean isSecured() {
        return getAngle() == getMaxAngle();
    }
}
