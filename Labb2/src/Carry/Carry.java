package Carry;

import Movement.Movable;
import java.util.List;

public class Carry{
    private int capacity;
    private List<Movable> load;

    public Carry(int capacity, List<Movable> load){
        this.capacity = capacity;
        this.load = load;
    }

    public void loadInFront(Movable movable){ if(isLoadable(movable)){getLoad().add(movable); }}
    public void loadInBack(Movable movable){ if(isLoadable(movable)){getLoad().add(0, movable); }}

    public Movable unloadFront(){
        if(isUnloadable()){
            Movable unloaded = getLoad().remove(getVolume() - 1);
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
            return unloaded;
        }
        return null;
    }

    public Movable unloadBack(){
        if(isUnloadable()){
            Movable unloaded = getLoad().remove(0);
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
            return unloaded;
        }
        return null;
    }

    public boolean isLoadable(Movable movable){
        if(getVolume() == getCapacity()){ return false; }
        if(getLoad().contains(movable)){ return false; }
        return true;
    }
    public boolean isUnloadable(){
        if(getVolume() == 0){ return false; }
        return true;
    }

    public boolean isRightPosition(Movable movable, Movable attachedMovable){
        int range = 3;
        switch (movable.getDirection()){
            case NORTH:
                if(isDistanceInRange(range, attachedMovable.gety(), movable.gety())){ return true; }
            case EAST:
                if(isDistanceInRange(range, attachedMovable.getx(), movable.getx())){ return true; }
            case SOUTH:
                if(isDistanceInRange(range, attachedMovable.gety(), movable.gety())){ return true; }
            case WEST:
                if(isDistanceInRange(range, attachedMovable.getx(), movable.getx())){ return true; }
        }
        return false;
    }
    public boolean isDistanceInRange(int range, double biggerAbs, double smallerAbs){ return Math.abs(biggerAbs) - Math.abs(smallerAbs) < range; }

    public List<Movable> getLoad(){ return this.load; }
    public int getCapacity(){ return this.capacity; }
    public int getVolume(){ return getLoad().size(); }
//    public Movable getAttachedTo(){ return this.attachedTo; }

}