package Base_Classes;

import Carry.FerryCarry;
import Movement.Direction;
import SpeedChange.NoStrat;

public class Ferry extends Vehicle {

    private final FerryCarry carry = new FerryCarry(this);

    public Ferry(){
        super(0, 0, Direction.NORTH, true, true, 200.0);
    }

    public void load(Saab95 saab95){ getCarry().load(saab95.getMovable()); }
    public void load(Volvo240 volvo240){ getCarry().load(volvo240.getMovable()); }
    public void unload(){ getCarry().unload(); }

    FerryCarry getCarry(){ return this.carry; }

}