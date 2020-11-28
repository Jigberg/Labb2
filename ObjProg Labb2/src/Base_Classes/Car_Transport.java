package Base_Classes;

import Carry.Car_TransportCarry;
import Movement.Direction;
import Movement.Movable;
import Ramp.Car_TransportRamp;
import SpeedChange.NoStrat;
import Uncategorized.IVehicle;

public class Car_Transport implements IVehicle {
    private final Movable movable = new Movable(0, 0, Direction.NORTH, true, true, 200, new NoStrat());
    private final Car_TransportCarry carry = new Car_TransportCarry(this);
    private final Car_TransportRamp ramp = new Car_TransportRamp(0, this);

    public void load(Saab95 saab95){ getCarry().load(saab95.getMovable()); }
    public void load(Volvo240 volvo240){ getCarry().load(volvo240.getMovable()); }
    public void unload(){ getCarry().unload(); }

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

    public void raiseRamp(int angle){ getRamp().raiseRamp(angle); }
    public void lowerRamp(int angle){ getRamp().lowerRamp(angle); }

    Car_TransportCarry getCarry(){ return this.carry; }

    @Override
    public void stopEngine(){getMovable().setCurrentSpeed(0);}
    @Override
    public void startEngine(){getMovable().setCurrentSpeed(0.1);}
    @Override
    public void gas(double amount){getMovable().increaseSpeed(amount); }
    @Override
    public void brake(double amount){getMovable().decreaseSpeed(amount);}
    public Movable getMovable() {return this.movable; }
    public Car_TransportRamp getRamp(){ return this.ramp; }

}
