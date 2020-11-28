package Base_Classes;

import Carry.Car_WorkshopCarry;
import Carry.IHaveWorkshop;
import Movement.Direction;
import Movement.Movable;
import Movement.Positionable;

public class Car_Workshop<T extends IHaveWorkshop> {
    Positionable positionable = new Positionable(0, 0, Direction.NORTH, false, false, false);
    Car_WorkshopCarry carry = new Car_WorkshopCarry(this);

    public void load(T t){ getCarry().load(t.getMovable());}

    public Car_WorkshopCarry getCarry() { return carry; }
}
