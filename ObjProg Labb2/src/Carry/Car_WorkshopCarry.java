package Carry;

import Base_Classes.Car_Workshop;
import Base_Classes.Saab95;
import Movement.Movable;

import java.util.ArrayList;
import java.util.List;


public class Car_WorkshopCarry extends Carry<Car_Workshop<?>> {
    public Car_WorkshopCarry(Car_Workshop<?> attachedTo){
        super(3, new ArrayList<>(), attachedTo);
    }

    public void load(Movable movable){
      if(isLoadable(movable)){
          getLoad().add(movable);
          movable.getStates().setIsMovable(false);
          movable.getStates().setIsTransportable(false);
      }

    }






}
