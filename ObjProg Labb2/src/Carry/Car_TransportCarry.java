package Carry;

import Base_Classes.Car_Transport;
import Base_Classes.Saab95;
import Base_Classes.Volvo240;
import Movement.*;
import Uncategorized.IVehicle;
import SpeedChange.NoStrat;

import java.util.ArrayList;

public class Car_TransportCarry extends Carry<Car_Transport> {

    public Car_TransportCarry(Car_Transport attachedTo) {
        super(3, new ArrayList<>(), attachedTo);
    }

    public void load(Movable movable){ if(isLoadable(movable)){getLoad().add(0, movable); }}

    @Override
    public boolean isLoadable(Movable movable){
        if (!movable.getStates().getIsTransportable()) { return false; }
        if (movable.getStates().getHasSpeed()){ return false; }
        if (getAttachedTo().getMovable().getStates().getHasSpeed()) { return false; }
        if (getAttachedTo().getMovable().getDirection() != movable.getDirection()){ return false; }
        if (!isRightPosition(movable)){ return false; }
        return super.isLoadable(movable);
    }
    boolean isRightPosition(Movable movable){
        int range = 3;
        switch (movable.getDirection()){
            case NORTH:
                if(isDistanceInRange(range, getAttachedTo().getMovable().gety(), movable.gety())){ return true; }
            case EAST:
                if(isDistanceInRange(range, getAttachedTo().getMovable().getx(), movable.getx())){ return true; }
            case SOUTH:
                if(isDistanceInRange(range, getAttachedTo().getMovable().gety(), movable.gety())){ return true; }
            case WEST:
                if(isDistanceInRange(range, getAttachedTo().getMovable().getx(), movable.getx())){ return true; }
        }
        return false;
    }
    boolean isDistanceInRange(int range, double biggerAbs, double smallerAbs){ return Math.abs(biggerAbs) - Math.abs(smallerAbs) < range; }
    public void unload(){
        if(isUnloadable()){
            Movable unloaded = getLoad().remove(0);
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setIsMovable(true);
        }
    }
    @Override
    public boolean isUnloadable(){ return super.isUnloadable() && !getAttachedTo().getMovable().getStates().getHasSpeed(); }
}
