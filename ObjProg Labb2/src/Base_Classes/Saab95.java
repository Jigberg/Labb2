package Base_Classes;
import SpeedChange.BasicTurboStrat;
import Movement.Direction;

public class Saab95 extends Vehicle {
    public Saab95(){
        super(0, 0, Direction.NORTH, true, true, 200.0, new BasicTurboStrat(1.3));
    }

}
