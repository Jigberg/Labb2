package Ramps;

import Base_Classes.Scania;

public class ScaniaRamp extends Ramp{
    public ScaniaRamp(int angle, Scania attachedTo) {
        super(angle, 70, 0, 0, attachedTo);
    }

    @Override
    boolean isSecured() { return getAngle() == getMinAngle();
    }
}
