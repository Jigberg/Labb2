package Carry;

import Base_Classes.Ferry;
import Movement.Movable;
import Movement.Positionable;

import java.util.ArrayList;

public class FerryCarry extends Carry {
    Positionable attachedTo;
    public FerryCarry(Movable attachedTo){
        super(20, new ArrayList<>(), attachedTo);
        this.attachedTo = attachedTo;
    }

    public void load(Movable movable){ if(isLoadable(movable)){getLoad().add(movable); }}

    public void unload(){
        if(isUnloadable()){
            Movable unloaded = getLoad().remove(getVolume());
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }
}
