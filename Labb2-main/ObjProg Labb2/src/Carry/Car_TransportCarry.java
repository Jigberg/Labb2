package Carry;

import Base_Classes.Car_Transport;
import Movement.*;

import java.util.ArrayList;

public class Car_TransportCarry extends Carry {

    public Car_TransportCarry(Movable attachedTo) {
        super(3, new ArrayList<>(), attachedTo);
    }

    public void load(Movable movable){ if(isLoadable(movable)){getLoad().add(0, movable); }}

    @Override
    public boolean isLoadable(Movable movable){
        if (!movable.getStates().getIsTransportable()) { return false; }
        if (movable.getStates().getCurrentlyHasSpeed()){ return false; }
        if (getAttachedTo().getStates().getCurrentlyHasSpeed()) { return false; }
        if (getAttachedTo().getDirection() != movable.getDirection()){ return false; }
        if (!isRightPosition(movable, getAttachedTo())){ return false; }
        return super.isLoadable(movable);
    }

    public void unload(){
        if(isUnloadable()){
            Movable unloaded = getLoad().remove(0);
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }
    @Override
    public boolean isUnloadable(){ return super.isUnloadable() && !getAttachedTo().getStates().getCurrentlyHasSpeed(); }
}
