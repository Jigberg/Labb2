package Base_Classes;

import Ramp.*;
import Carry.Carry;
import java.util.ArrayList;
import Movement.*;
import java.util.List;
import SpeedChange.SpeedChangeStrat;

/**
  * @author Lukas, Emil, Martin.
  * Class for a Car transporter that can transport volvos and saabs.
  */
public class Car_Transport extends Vehicle {
    /**
     * Carry object for transporting.
     * Ramp object for lowering and raising the rampbed.
     */
    private final Carry carry = new Carry(4, new ArrayList<>());
    private final Ramp ramp = new Ramp(90, 90, 0, 90);

    public Car_Transport(){
        super(0, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.NO_STRAT, 0);
    }

    /**
     * Loads Saab95 types of cars.
     * @param saab95 a Saab95 object.
     */
    public void load(Saab95 saab95){if(isLoadable(saab95.getMovable())) { getCarry().loadInBack(saab95.getMovable());}}
    /**
     * Loads Volvo249 types of cars.
     * @param volvo240 a Volvo240 object
     */
    public void load(Volvo240 volvo240){ if(isLoadable(volvo240.getMovable())){ getCarry().loadInBack(volvo240.getMovable()); }}
    /**
     * Moves the Car_Transport and the carrying cars.
     */
    @Override
    public void move(){
        for(Movable movable : getCarry().getLoad()){
            movable.move();
        }
        getMovable().move();
    }
    /**
     * Turns the Car_Transport and the carrying cars.
     */
    @Override
    public void turnRight(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnRight();
        }
        super.turnRight();
    }
    /**
     * Turns the Car_Transport and the carrying cars.
     */
    @Override
    public void turnLeft(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnLeft();
        }
        super.turnLeft();
    }
    /**
     * Check if the Car_Transport is able the load the specific object.
     * @param movable a object that is being loaded.
     * @return if all conditions are met.
     */
    private boolean isLoadable(Movable movable){
        if (!movable.getStates().getIsTransportable()) { return false; }
        if (movable.getStates().getCurrentlyHasSpeed()){ return false; }
        if (getMovable().getStates().getCurrentlyHasSpeed()) { return false; }
        if (getMovable().getDirection() != movable.getDirection()){ return false; }
        if (!getCarry().isRightPosition(movable, getMovable())){ return false; }
        return getCarry().isLoadable(movable);
    }
    /**
     * if possible, unload the rear car and set isTransportable to true, and canMove to true.
     */
    public void unload(){
        if(isUnloadable()){
            Movable unloaded = getCarry().unloadBack();
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }
    /**
     * @return if Car Transport doesn't have speed and if other basic conditions are met.
     */
    private boolean isUnloadable(){ return getCarry().isUnloadable() && !getMovable().getStates().getCurrentlyHasSpeed(); }

    @Override
    public void startEngine(){
        if(getRamp().isSecured()){
            getMovable().getStates().setCanMove(true);
        }
    }

    /**
     * Getters and setters.
     */

    public int getVolume(){ return getCarry().getVolume(); }
    public List<Movable> getLoad(){ return getCarry().getLoad(); }
    private Carry getCarry(){ return this.carry; }
    private Ramp getRamp(){ return this.ramp; }
}

