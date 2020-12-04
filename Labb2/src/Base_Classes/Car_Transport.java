package Base_Classes;

import Carry.Carry;
import Movement.Direction;
import Movement.Movable;
import Ramp.*;
import SpeedChange.SpeedChangeStrat;
import java.util.List;

import java.util.ArrayList;

public class Car_Transport extends Vehicle {
    private final Carry carry = new Carry(4, new ArrayList<>());
    private final Ramp ramp = new Ramp(90, 90, 0);

    public Car_Transport(){
        super(0, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.NO_STRAT, 0);
    }

    public void load(Saab95 saab95){ getCarry().loadInBack(saab95.getMovable()); }
    public void load(Volvo240 volvo240){ getCarry().loadInBack(volvo240.getMovable()); }

    @Override
    public void move(){
        for(Movable movable : getCarry().getLoad()){
            movable.move();
        }
        getMovable().move();
    }
    @Override
    public void turnRight(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnRight();
        }
        super.turnRight();
    }
    @Override
    public void turnLeft(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnLeft();
        }
        super.turnLeft();
    }
    private Carry getCarry(){ return this.carry; }
    private Ramp getRamp(){ return this.ramp; }


    private boolean isLoadable(Movable movable){
        if (!movable.getStates().getIsTransportable()) { return false; }
        if (movable.getStates().getCurrentlyHasSpeed()){ return false; }
        if (getMovable().getStates().getCurrentlyHasSpeed()) { return false; }
        if (getMovable().getDirection() != movable.getDirection()){ return false; }
        if (!getCarry().isRightPosition(movable, getMovable())){ return false; }
        return getCarry().isLoadable(movable);
    }

    public void unload(){
        if(isUnloadable()){
            Movable unloaded = getCarry().unloadBack();
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }
    public boolean isUnloadable(){ return getCarry().isUnloadable() && !getMovable().getStates().getCurrentlyHasSpeed(); }


    /**
     * Raises ramp.
     * @param angle to raise platform.
     */
    public void raiseRamp(int angle){
        if(!getMovable().getStates().getCurrentlyHasSpeed()) {
            getRamp().setAngle(Math.min(getRamp().raisableAngle(), angle));
            if(isSecured()){
                getMovable().getStates().setCanMove(true);
            }
        }
    }

    /**
     * Lowers ramp.
     * @param angle to lower platform.
     */
    public void lowerRamp(int angle) {
        if(!getMovable().getStates().getCurrentlyHasSpeed()) {
            getRamp().setAngle(Math.min(getRamp().lowerableAngle(), angle));
            if(!isSecured()){
                getMovable().getStates().setCanMove(false);
            }
        }
    }

    @Override
    public void startEngine(){
        if(isSecured()){
            getMovable().getStates().setCanMove(true);
        }
    }
    boolean isSecured() { return getRamp().getAngle() == getRamp().getMaxAngle(); }
    public int getVolume(){ return getCarry().getVolume(); }
    public List<Movable> getLoad(){ return getCarry().getLoad(); }
}

