package Carry;

import Movement.Movable;
import java.util.List;

public abstract class Carry{
    private int capacity;
    private List<Movable> load;
    private Movable attachedTo;

    public Carry(int capacity, List<Movable> load, Movable attachedTo){
        this.capacity = capacity;
        this.load = load;
        this.attachedTo = attachedTo;
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

    boolean isRightPosition(Movable movable, Movable attachedMovable){
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
    boolean isDistanceInRange(int range, double biggerAbs, double smallerAbs){ return Math.abs(biggerAbs) - Math.abs(smallerAbs) < range; }

    public List<Movable> getLoad(){ return this.load; }
    public int getCapacity(){ return this.capacity; }
    public int getVolume(){ return getLoad().size(); }
    public Movable getAttachedTo(){ return this.attachedTo; }

}