package Carry;

import Base_Classes.Kangaroo;
import Movement.Movable;

import java.util.Stack;

public class KangarooCarry extends Carry {
    public KangarooCarry(Movable attachedTo) {
        super(2, new Stack<>(), attachedTo);
    }

    public void load(Movable movable){ if(isLoadable(movable)){getLoad().add(0, movable); }}

    public void unload(){
        if(isUnloadable()){
            Movable unloaded = getLoad().remove(getVolume());
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }
}
