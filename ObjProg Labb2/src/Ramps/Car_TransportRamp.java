package Ramps;

import Vehicles.Car_Transport;

public class Car_TransportRamp extends Ramp {
    public Car_TransportRamp(int angle, Car_Transport attachedTo) {
        super(angle, 90, 0, 45, attachedTo);
    }

    @Override
    boolean isSecured() {
        return getAngle() == getMaxAngle();
    }
}
