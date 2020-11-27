package Carry;

import Base_Classes.Car_Transport;
import Base_Classes.Saab95;
import Base_Classes.Volvo240;
import FART.Speed;
import Movement.Direction;
import Movement.Movable;
import Movement.Positionable;
import Uncategorized.VehicleProperties;
import FART.NoStrat;

import java.util.ArrayList;

public class CarTransportCarrier extends Carrier<Car_Transport>{
    public CarTransportCarrier(Car_Transport attachedTo) {
        super(3, new ArrayList<>(), attachedTo);
    }
    private Positionable positionable = new Positionable(0, 0, Direction.NORTH);
    private VehicleProperties vehicleProperties;
    private Speed speed = new Speed(0,100,new NoStrat());
    
    public void load(Saab95 saab95){ doLoad(saab95); }
    public void load(Volvo240 volvo240){ doLoad(volvo240);}
    private void doLoad(Object o){ if(isLoadable(o)){ getLoad().add(o); }}

    @Override
    public boolean isLoadable(Object o) {
        if (positionable.getDirection() != ((Movable) loadType).getDirection()) { return false; }
        if (getAttachedTo().getAngle() != 0) { return false; }
        if (getVolume() == getCapacity()) { return false; }
        if (((Vehicle) loadType).getCurrentSpeed() != 0 || getAttachedTo().getCurrentSpeed() != 0) { return false; }
        if (!isRightPosition(loadType)) { return false; }
        return super.isLoadable(o);
    }
    boolean isRightPosition(Object o){
        switch (((Positionable) loadingCar).getDirection()) {
            case NORTH:
                if (((Positionable) loadingCar).gety() < getAttachedTo().gety() && (getAttachedTo().gety() - ((Positionable) loadingCar).gety() < 3) && Math.abs(getAttachedTo().getx() - ((Positionable) loadingCar).getx()) < 0.001) {
                    return true;
                }
            case EAST:
                if (((Positionable) loadingCar).getx() < getAttachedTo().getx() && (getAttachedTo().getx() - ((Positionable) loadingCar).getx() < 3) && Math.abs(getAttachedTo().gety() - ((Positionable) loadingCar).gety()) < 0.001) {
                    return true;
                }
            case SOUTH:
                if (((Positionable) loadingCar).gety() > getAttachedTo().gety() && (getAttachedTo().gety() - ((Positionable) loadingCar).gety() < -3) && Math.abs(getAttachedTo().getx() - ((Positionable) loadingCar).getx()) > -0.001) {
                    return true;
                }
            case WEST:
                if (((Positionable) loadingCar).getx() > getAttachedTo().getx() && (getAttachedTo().gety() - ((Positionable) loadingCar).gety() < -3) && Math.abs(getAttachedTo().gety() - ((Positionable) loadingCar).gety()) < 0.001) {
                    return true;
                }
            default:
                System.out.println("not right position");
                return false;
        }
    }
}
