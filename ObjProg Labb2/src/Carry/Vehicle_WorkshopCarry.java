package Carry;

import Base_Classes.Vehicle_Workshop;
import Movement.Movable;
import Uncategorized.IVehicle;

import java.util.ArrayList;


public class Vehicle_WorkshopCarry extends Carry<Vehicle_Workshop<?>> {
    public Vehicle_WorkshopCarry(Vehicle_Workshop<?> attachedTo){
        super(3, new ArrayList<>(), attachedTo);
    }

    public void load(Movable movable){
      if(isLoadable(movable)){
          getLoad().add(movable);
          movable.getStates().setCanMove(false);
          movable.getStates().setIsTransportable(false);
      }

    }
    public void unload(Movable movable){
        if(isUnloadable(movable)){
            Movable unloaded = getLoad().get(getLoad().indexOf(movable));
            unloaded.getStates().setCanMove(true);

        }
    }

    boolean isUnloadable(Movable movable){ return getLoad().contains(movable) && isUnloadable();}






}
