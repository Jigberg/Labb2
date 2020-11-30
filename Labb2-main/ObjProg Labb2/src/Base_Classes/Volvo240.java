package Base_Classes;

import SpeedChange.*;
import Movement.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Vehicles.Volvo240
 */

public class Volvo240 extends Vehicle {

    public Volvo240(){
        super(0, 0, Direction.NORTH, true, true, 200.0);
        this.getMovable().setStrat(new BasicTrimFactorStrat(1.25));
    }

}
