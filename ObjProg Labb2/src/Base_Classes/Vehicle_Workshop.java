package Base_Classes;

import Carry.Carry;
import Movement.Direction;
import Movement.Movable;
import Movement.Positionable;

import java.util.ArrayList;

public class Vehicle_Workshop<T extends Vehicle> {
    private final Positionable positionable = new Positionable(0, 0, Direction.NORTH, false, false);
    private Carry carry = new Carry(3, new ArrayList<>());

    public void load(Movable movable){
        if(getCarry().isLoadable(movable)){
            getCarry().getLoad().add(movable);
            movable.getStates().setCanMove(false);
            movable.getStates().setIsTransportable(false);
        }

    }
    public void unload(Movable movable){
        if(isUnloadable(movable)){
            Movable unloaded = getCarry().getLoad().get(getCarry().getLoad().indexOf(movable));
            unloaded.getStates().setCanMove(true);

        }
    }
    boolean isUnloadable(Movable movable){
        return getCarry().getLoad().contains(movable) && getCarry().isUnloadable();
    }

    private Carry getCarry(){ return this.carry; }
}
