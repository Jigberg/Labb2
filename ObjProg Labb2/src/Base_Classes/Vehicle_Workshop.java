package Base_Classes;

import Carry.Vehicle_WorkshopCarry;
import Movement.Direction;
import Movement.Positionable;

public class Vehicle_Workshop<T extends Vehicle> {
    private final Positionable positionable = new Positionable(0, 0, Direction.NORTH, false, false);
    private final Vehicle_WorkshopCarry carry = new Vehicle_WorkshopCarry(this);

    public void load(T t){ getCarry().load(t.getMovable());}
    public void unload(T t){ getCarry().unload(t.getMovable()); }

    public Vehicle_WorkshopCarry getCarry() { return carry; }
}
