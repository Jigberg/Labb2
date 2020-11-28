package Base_Classes;

import Carry.Car_TransportCarry;
import Movement.Direction;
import Movement.Movable;
import Movement.Speed;
import Ramp.Car_TransportRamp;
import SpeedChange.NoStrat;
import Uncategorized.IVehicle;

public class Car_Transport implements IVehicle {
    private final Speed speed = new Speed(0,200, new NoStrat(), 10, 5, 1, 1);
    private final Movable movable = new Movable(0, 0, Direction.NORTH,speed, true, true, true);
    private final Car_TransportCarry carry = new Car_TransportCarry(this);
    private final Car_TransportRamp ramp = new Car_TransportRamp(0, this);

    public void load(Saab95 saab95){ getCarry().load(saab95.getMovable());}
    public void load(Volvo240 volvo240){ getCarry().load(volvo240.getMovable());}

    public void move(){
        for(Movable movable : getCarry().getLoad()){
            movable.move();
        }
        getMovable().move();
    }
    public void turnRight(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnRight();
        }
        getMovable().turnRight();
    }
    public void turnLeft(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnLeft();
        }
        getMovable().turnLeft();
    }

    public Movable getMovable(){ return this.movable; }
    Car_TransportCarry getCarry(){ return this.carry; }


    @Override
    public void stopEngine() {}
    @Override
    public void startEngine() {}
    @Override
    public void gas() {}
    @Override
    public void brake() {}
}
