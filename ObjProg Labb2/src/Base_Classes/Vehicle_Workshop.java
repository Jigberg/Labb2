package Base_Classes;

import Carry.Carry;
import Movement.Direction;
import Movement.Movable;
import Movement.Positionable;

import java.util.ArrayList;

/**
 * A vehicle workshop that can load vehicles.
 * @param <T> the specific type of vehicle the workshop is for.
 */
public class Vehicle_Workshop<T extends Vehicle> {
    private final Positionable positionable = new Positionable(0, 0, Direction.NORTH, false, false);
    private final Carry carry = new Carry(3, new ArrayList<>());

    /**
     * Loads the movable if it is loadable.
     * @param t object to load.
     */
    public void load(T t){
        if(getCarry().isLoadable(t.getMovable())){
            getCarry().getLoad().add(t.getMovable());
            t.getMovable().getStates().setCanMove(false);
            t.getMovable().getStates().setIsTransportable(false);
        }
    }

    /**
     * Unloads the movable if it is unloadable.
     * @param t object to unload.
     */
    public void unload(T t){
        if(isUnloadable(t.getMovable())){
            Movable unloaded = getCarry().getLoad().get(getCarry().getLoad().indexOf(t.getMovable()));
            unloaded.getStates().setCanMove(true);

        }
    }

    /**
     *
     * @param movable to check.
     * @return if the movable is unloadable.
     */
    private boolean isUnloadable(Movable movable){
        return getCarry().getLoad().contains(movable) && getCarry().isUnloadable();
    }

    /**
     * Getters and setters below.
     */
    private Carry getCarry(){ return this.carry; }
    public Positionable getPositionable(){ return this.positionable;}

}
