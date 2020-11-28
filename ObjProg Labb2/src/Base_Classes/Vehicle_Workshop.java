package Base_Classes;

import Carry.Vehicle_WorkshopCarry;
import Movement.Direction;
import Movement.Positionable;
import Uncategorized.IVehicle;

public class Vehicle_Workshop<T extends IVehicle> {
    Positionable positionable = new Positionable(0, 0, Direction.NORTH, false, false, false);
    Vehicle_WorkshopCarry carry = new Vehicle_WorkshopCarry(this);

    public void load(T t){ getCarry().load(t.getMovable());}

    public Vehicle_WorkshopCarry getCarry() { return carry; }
}
