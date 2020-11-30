package Base_Classes;
import SpeedChange.*;
import Movement.Direction;

public class Saab95 extends Vehicle {
    BasicTurboStrat basicTurboStrat;

    public Saab95(){
        super(200, 0, Direction.NORTH, true, true, 200.0);
        this.basicTurboStrat = new BasicTurboStrat(10.0);
        getMovable().setStrat(basicTurboStrat);
    }

    public void turboON(){
        getBasicTurboStrat().getTurbo().setTurboOn(true);
    }

    public void turboOFF(){
        getBasicTurboStrat().getTurbo().setTurboOn(false);
    }


  BasicTurboStrat getBasicTurboStrat(){ return this.basicTurboStrat; }

}
