package Carriers;

import Base_Classes.Car_Transport;
import Base_Classes.Saab95;
import Base_Classes.Volvo240;
import Uncategorized.Movables;
import Uncategorized.Positionables;

import java.util.ArrayList;

public class CarTransportCarrier extends Carrier<Car_Transport>{
    public CarTransportCarrier(Car_Transport attachedTo) {
        super(3, new ArrayList<>(), attachedTo);
    }
    
    public void load(Saab95 saab95){ doLoad(saab95); }
    public void load(Volvo240 volvo240){ doLoad(volvo240);}
    private void doLoad(Object o){ if(isLoadable(o)){ getLoad().add(o); }}

    @Override
    public boolean isLoadable(Object o) {
        if (getAttachedTo().getDirection() != ((Movables) loadType).getDirection()) { return false; }
        if (getAttachedTo().getRamp().getAngle() != 0) { return false; }
        if (getVolume() == getCapacity()) { return false; }
        if (((Vehicle) loadType).getCurrentSpeed() != 0 || getAttachedTo().getCurrentSpeed() != 0) { return false; }
        if (!isRightPosition(loadType)) { return false; }
        return super.isLoadable(o);
    }
    boolean isRightPosition(Object o){
        switch (((Positionables) loadingCar).getDirection()) {
            case NORTH:
                if (((Positionables) loadingCar).gety() < getAttachedTo().gety() && (getAttachedTo().gety() - ((Positionables) loadingCar).gety() < 3) && Math.abs(getAttachedTo().getx() - ((Positionables) loadingCar).getx()) < 0.001) {
                    return true;
                }
            case EAST:
                if (((Positionables) loadingCar).getx() < getAttachedTo().getx() && (getAttachedTo().getx() - ((Positionables) loadingCar).getx() < 3) && Math.abs(getAttachedTo().gety() - ((Positionables) loadingCar).gety()) < 0.001) {
                    return true;
                }
            case SOUTH:
                if (((Positionables) loadingCar).gety() > getAttachedTo().gety() && (getAttachedTo().gety() - ((Positionables) loadingCar).gety() < -3) && Math.abs(getAttachedTo().getx() - ((Positionables) loadingCar).getx()) > -0.001) {
                    return true;
                }
            case WEST:
                if (((Positionables) loadingCar).getx() > getAttachedTo().getx() && (getAttachedTo().gety() - ((Positionables) loadingCar).gety() < -3) && Math.abs(getAttachedTo().gety() - ((Positionables) loadingCar).gety()) < 0.001) {
                    return true;
                }
            default:
                System.out.println("not right position");
                return false;
        }
    }
}
