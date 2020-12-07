package Carry;


import javax.sound.midi.SysexMessage;
import java.util.List;

/**
 * @author Lukas, Emil, Martin.
 * A class for a carry function.
 */
public class Carry{
    private final int capacity;
    private final List<Movable> load;

    public Carry(int capacity, List<Movable> load){
        this.capacity = capacity;
        this.load = load;
    }

    /**
     * Loads the movable in the front of the carry.
     * @param movable to load.
     */
    public void loadInFront(Movable movable){ if(isLoadable(movable)){getLoad().add(movable); }}

    /**
     * Loads the movable in the back of the carry.
     * @param movable to load.
     */
    public void loadInBack(Movable movable){ if(isLoadable(movable)){getLoad().add(0, movable); }}

    /**
     * Unloads the first movable in the "front" of the carry.
     * @return the movable.
     */
    public Movable unloadFront(){
        if(isUnloadable()){
            Movable unloaded = getLoad().remove(getVolume() - 1);
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
            return unloaded;
        }
        return null;
    }

    /**
     * Unloads the first movable in the "back" of the carry.
     * @return the movable.
     */
    public Movable unloadBack(){
        if(isUnloadable()){
            Movable unloaded = getLoad().remove(0);
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
            return unloaded;
        }
        return null;
    }

    /**
     * @param movable to check.
     * @return if the movable is loadable.
     */
    public boolean isLoadable(Movable movable){
        if(getVolume() == getCapacity()){ return false; }
        if(getLoad().contains(movable)){ return false; }
        return true;
    }

    /**
     * @return if there is something to unload.
     */
    public boolean isUnloadable(){
        if(getVolume() == 0){ return false; }
        return true;
    }

    /**
     * @param movable to check.
     * @param attachedMovable is the object that has the carry function and tries to load the movable.
     * @return if the movable is in the right position to be loaded to the attachedMovable.
     */
    public boolean isRightPosition(Movable movable, Movable attachedMovable){
        int range = 3;
        switch (movable.getDirection()){
            case NORTH, SOUTH:
                if(isDistanceInRange(range, attachedMovable.gety(), movable.gety())){
                    return true; }
                break;
            case EAST, WEST:
                if(isDistanceInRange(range, attachedMovable.getx(), movable.getx())){ return true; }
                break;
        }
        return false;
    }

    /**
     * @param range is the max range from which something can be loaded.
     * @param biggerAbs the bigger absolute value.
     * @param smallerAbs the smaller absolute value.
     * @return if something is in range.
     */
    public boolean isDistanceInRange(int range, double biggerAbs, double smallerAbs){ return Math.abs(Math.abs(biggerAbs) - Math.abs(smallerAbs)) < range; }

    /**
     * Getters and setters below.
     */
    public int getVolume(){ return getLoad().size(); }
    public List<Movable> getLoad(){ return this.load; }
    public int getCapacity(){ return this.capacity; }
}