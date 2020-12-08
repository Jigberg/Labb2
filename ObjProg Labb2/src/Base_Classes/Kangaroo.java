package Base_Classes;

import Carry.Carry;
import Movement.Direction;
import Movement.Movable;
import java.util.List;

import java.util.ArrayList;

public class Kangaroo{
    /**
     * Movable object for all moving functionality.
     * Carry object for transporting.
     */
    private final Movable movable;
    private final Carry carry = new Carry(3, new ArrayList<>());

    public Kangaroo(double x, double y, Direction direction){ this.movable = new Movable(x, y, direction, true, 50, 50, 1, 1, 1); }
    public Kangaroo(){ this.movable = new Movable(0, 0, Direction.NORTH, true, 0, 50, 1, 1, 1); }

    /**
     * Loads KangarooCub types. Fills the "front" position first.
     * @param kangarooCub a KangarooCub object.
     */
    public void load(KangarooCub kangarooCub){ getCarry().loadInFront(kangarooCub.getMovable()); }
    /**
     * Loads KangarooCub types. Fills the "front" position first.
     * @param wallabyCub a WallabyCub object.
     */
    public void load(WallabyCub wallabyCub){ getCarry().loadInFront(wallabyCub.getMovable()); }

    /**
     * if possible, unloads from the "rear" position first.
     */
    public void unload(){
        if(getCarry().isUnloadable()){
            Movable unloaded = getCarry().unloadBack();
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }

    /**
     * Moves the Kangaroo and the carrying objects.
     */
    public void move(){
        for(Movable movable : getCarry().getLoad()){
            movable.move();
        }
        getMovable().move();
    }

    /**
     * Turns the Kangaroo and the carrying objects
     */
    public void turnRight(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnRight();
        }
        getMovable().turnRight();
    }
    /**
     * Turns the Kangaroo and the carrying objects
     */
    public void turnLeft(){
        for(Movable movable : getCarry().getLoad()){
            movable.turnLeft();
        }
        getMovable().turnLeft();
    }

    /**
     * Jumps faster, calls increaseSpeed in movable.
     * @param amount a factor for calculating the speed increase.
     */
    public void jumpFaster(double amount){getMovable().increaseSpeed(amount); }

    /**
     * Jumps slower, calls decreaseSpeed in movable.
     * @param amount a factor for calculating the speed decrease.
     */
    public void jumpSlower(double amount){getMovable().decreaseSpeed(amount); }

    /**
     * Prints x and y positional values.
     */
    public void checkSurroundings(){ System.out.println("x: " + getMovable().getx() + "   ,  y: "+ getMovable().gety()); }
    /**
     * Getters and setters below.
     */
    public Movable getMovable(){return this.movable;}
    private Carry getCarry(){ return this.carry; }
    public int getVolume(){ return getCarry().getVolume(); }

}
