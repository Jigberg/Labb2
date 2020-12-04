package Base_Classes;

import Movement.Direction;
import Movement.Movable;
import Carry.*;
import SpeedChange.SpeedChangeStrat;

import java.util.ArrayList;

public class Ferry extends Vehicle {
    Carry carry = new Carry(20, new ArrayList<>());

    public Ferry(){ super(0, 0, Direction.NORTH, true, true, 200.0, SpeedChangeStrat.NO_STRAT, 0); }

    public void load(Volvo240 volvo240){ getCarry().loadInFront(volvo240.getMovable()); }
    public void load(Saab95 saab95){ getCarry().loadInFront(saab95.getMovable()); }
    public void load(Scania scania){ getCarry().loadInFront(scania.getMovable()); }
    public void load(Car_Transport car_transport){ getCarry().loadInFront(car_transport.getMovable()); }
    public void load(Kangaroo kangaroo){ getCarry().loadInFront(kangaroo.getMovable()); }

    public void unload(){
        if(getCarry().isUnloadable()){
            Movable unloaded = getCarry().getLoad().remove(getCarry().getVolume());
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }

    Carry getCarry(){ return this.carry; }

}