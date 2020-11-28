package Base_Classes;

import Carry.Car_TransportCarry;
import Movement.Direction;
import Movement.Movable;
import Ramp.Car_TransportRamp;
import SpeedChange.NoStrat;

public class Car_Transport extends Vehicle {
    private final Car_TransportCarry carry = new Car_TransportCarry(this);
    private final Car_TransportRamp ramp = new Car_TransportRamp(0, this);

    public Car_Transport(){
        super(0, 0, Direction.NORTH, true, true, 200.0, new NoStrat());
    }

    public void load(Saab95 saab95){ getCarry().load(saab95.getMovable()); }
    public void load(Volvo240 volvo240){ getCarry().load(volvo240.getMovable()); }
    public void unload(){ getCarry().unload(); }

    @Override
    public void move(){
        for(Movable movable : getCarry().getLoad()){
            movable.move();
        }
        getMovable().move();
    }
    @Override
    public void turnRight(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnRight();
        }
        super.turnRight();
    }
    @Override
    public void turnLeft(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnLeft();
        }
        super.turnLeft();
    }
    public void raiseRamp(int angle){ getRamp().raiseRamp(angle); }
    public void lowerRamp(int angle){ getRamp().lowerRamp(angle); }

    private Car_TransportCarry getCarry(){ return this.carry; }
    private Car_TransportRamp getRamp(){ return this.ramp; }

}
