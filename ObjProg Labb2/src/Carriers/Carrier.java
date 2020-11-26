package Carriers;
import java.util.List;

public abstract class Carrier<A>{
    private int capacity;
    private List<Object> load;
    private A attachedTo;

    public Carrier(int capacity, List<Object> load, A attachedTo){
        this.capacity = capacity;
        this.load = load;
        this.attachedTo = attachedTo;
    }

    public boolean isLoadable(Object o){
        if(getVolume() == getCapacity()){ return false; }
        if(getLoad().contains(o)){ return false; }
        return true;
    }
    public boolean isUnloadable(){
        if(getVolume() == 0){ return false; }
        return true;
    }

    public List<Object> getLoad(){ return this.load; }
    public int getCapacity(){ return this.capacity; }
    public int getVolume(){ return getLoad().size(); }
    public A getAttachedTo(){ return this.attachedTo; }
    public Object getObj(int index){ return getLoad().get(index); }

}