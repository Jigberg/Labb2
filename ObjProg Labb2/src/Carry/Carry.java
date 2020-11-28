package Carry;
import Movement.Movable;

import java.util.List;

public abstract class Carry<A>{
    private int capacity;
    private List<Movable> load;
    private A attachedTo;

    public Carry(int capacity, List<Movable> load, A attachedTo){
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

    public List<Movable> getLoad(){ return this.load; }
    public int getCapacity(){ return this.capacity; }
    public int getVolume(){ return getLoad().size(); }
    public A getAttachedTo(){ return this.attachedTo; }
    public Object getObj(int index){ return getLoad().get(index); }

}