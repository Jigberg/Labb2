package Carry;

import Base_Classes.Car_Transport;
import Base_Classes.Saab95;
import Base_Classes.Volvo240;
import Movement.Speed;
import Movement.Direction;
import Movement.Movable;
import Movement.Positionable;
import Uncategorized.IVehicle;
import SpeedChange.NoStrat;

import java.util.ArrayList;

public class Car_TransportCarry<L extends Movable> extends Carry<Car_Transport, L> {

    public Car_TransportCarry(Car_Transport attachedTo) {
        super(3, new ArrayList<>(), attachedTo);
    }
    public void load(Saab95 saab95){ doLoad(saab95); }
    public void load (Volvo240 volvo240){ doLoad(volvo240); }
    private void doLoad(Object o) {
        if (isLoadable(o.getM)) {
            getLoad().add(o);
        }
    }
    @Override
    public boolean isLoadable(L l){
        if (!l.getStates().getIsTransportable()) { return false; }
        if (l.getStates().getHasSpeed()){ return false; }
        if (getAttachedTo().getMovable().getStates().getHasSpeed()) { return false; }
        if (getAttachedTo().getMovable().getDirection() != l.getDirection()){ return false; }
        if (!isRightPosition(l)){ return false; }
        return super.isLoadable(l);
    }
    boolean isRightPosition(L l){
        int range = 3;
        switch (l.getDirection()){
            case NORTH:
                if(isDistanceInRange(range, getAttachedTo().getMovable().gety(), l.gety())){ return true; }
            case EAST:
                if(isDistanceInRange(range, getAttachedTo().getMovable().getx(), l.getx())){ return true; }
            case SOUTH:
                if(isDistanceInRange(range, getAttachedTo().getMovable().gety(), l.gety())){ return true; }
            case WEST:
                if(isDistanceInRange(range, getAttachedTo().getMovable().getx(), l.getx())){ return true; }
        }
        return false;
    }
    boolean isDistanceInRange(int range, double biggerAbs, double smallerAbs){ return Math.abs(biggerAbs) - Math.abs(smallerAbs) < range; }
    public void unload(){
        if(isUnloadable()){
            L unloaded = getLoad().remove(0);
            unloaded.getStates().setIsTransportalbe(true)
        }
    }
    @Override
    public boolean isUnloadable(){ return super.isUnloadable() && !getAttachedTo().getMovable().getStates().getHasSpeed(); }
}
