package Carriers;

import Base_Classes.Car_Workshop;

import java.util.ArrayList;


public class WorkshopCarrier<T> extends Carrier<Car_Workshop<T>>{
    public WorkshopCarrier(Car_Workshop<T> attachedTo){
        super(3, new ArrayList<>(), attachedTo);
    }

    T unload(T t){
        getLoad().remove(t);
        t.setIsMovable(true);
        return t;
    }

    private Object doUnload(Object o){
        if(isUnloadable(o)){
            getLoad().remove(o);
            return getObj(getLoad().indexOf(o));
        }
        return null;
    }

    public boolean isUnloadable(Object o){
        if(!getLoad().contains(o)){ return false; }
        return super.isUnloadable();
    }

    void load(T t){
        if(isLoadable(t)){
            getLoad().add(t);
            t.setIsMovable(false);
        }
    }
}
