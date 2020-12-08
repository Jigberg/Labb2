package Base_Classes;

import Movement.*;
import Carry.*;

import java.util.ArrayList;

/**
 * @author Lukas, Emil, Martin.
 * Class for a ferry that can transport vehicles.
 */
public class Ferry extends Vehicle {
    /**
     * Carry object for transporting.
     */
    private final Carry carry = new Carry(20, new ArrayList<>());

    public Ferry(double x, double y, Direction direction){ super(x, y, direction, 200, 0, 200, 1, 1); }
    public Ferry(){ super(0, 0, Direction.NORTH, 200, 0, 200, 1, 1); }

    /**
     * Overloaded loading methods for the accept loading objects.
     * Loads object.
     */
    public void load(Volvo240 volvo240){ getCarry().loadInBack(volvo240.getMovable()); }
    public void load(Saab95 saab95){ getCarry().loadInBack(saab95.getMovable()); }
    public void load(Scania scania){ getCarry().loadInBack(scania.getMovable()); }
    public void load(Car_Transport car_transport){ getCarry().loadInBack(car_transport.getMovable()); }
    public void load(Kangaroo kangaroo){ getCarry().loadInBack(kangaroo.getMovable()); }

    /**
     * If possible, unload object from the front.
     */
    public void unload(){
        if(getCarry().isUnloadable()){
            Movable unloaded = getCarry().unloadFront();
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }

    /**
     * Getters and setters.
     */
    private Carry getCarry(){ return this.carry; }

}