package Carry;
import java.util.List;

public abstract class Carry<A, L>{
    private int capacity;
    private List<L> load;
    private A attachedTo;

    public Carry(int capacity, List<L> load, A attachedTo){
        this.capacity = capacity;
        this.load = load;
        this.attachedTo = attachedTo;
    }

    public boolean isLoadable(L l){
        if(getVolume() == getCapacity()){ return false; }
        if(getLoad().contains(l)){ return false; }
        return true;
    }
    public boolean isUnloadable(){
        if(getVolume() == 0){ return false; }
        return true;
    }

    public List<L> getLoad(){ return this.load; }
    public int getCapacity(){ return this.capacity; }
    public int getVolume(){ return getLoad().size(); }
    public A getAttachedTo(){ return this.attachedTo; }
    public Object getObj(int index){ return getLoad().get(index); }

}