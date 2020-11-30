package Base_Classes;

import SpeedChange.NoStrat;
import Movement.*;
import Ramp.*;

public class Scania extends Vehicle {

    public Scania(){
        super(400, 0, Direction.NORTH, true, true, 200.0);
    }

    Ramp<Scania> ramp = new ScaniaRamp(0, this);

    private boolean isBeingTransported = false;

    Ramp<Scania> getRamp(){ return this.ramp; }

    public boolean getIsMovable() {
        return !isBeingTransported;
    }

}
