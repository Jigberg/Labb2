package Base_Classes;

import Carry.Car_TransportCarry;
import Movement.Direction;
import Movement.Movable;
import Movement.Speed;
import Ramp.Car_TransportRamp;
import SpeedChange.NoStrat;
import Uncategorized.IVehicle;

public class Car_Transport implements IVehicle {
    private Speed speed = new Speed(0,200, new NoStrat(), 10, 5, 1, 1);
    private Movable movable = new Movable(0, 0, Direction.NORTH,speed, true, true, true);
    private Car_TransportCarry carry = new Car_TransportCarry(this);
    private Car_TransportRamp ramp = new Car_TransportRamp(0, this);

    public void move(){
        for(Object o : getCarry().getLoad()){
            o.getMovable().move();
        }
        getMovable().move();
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
