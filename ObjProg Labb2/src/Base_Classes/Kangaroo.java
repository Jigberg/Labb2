package Base_Classes;

import Carry.Carry;
import Movement.Direction;
import Movement.Movable;
import java.util.List;

import java.util.ArrayList;

public class Kangaroo{
    private final Movable movable;

    public Kangaroo (){
        this.movable = new Movable(0, 0, Direction.NORTH, true, true, 50);
    }

    Carry carry = new Carry(3, new ArrayList<>());

    public void move(){ getMovable().move();}
    public void turnRight(){getMovable().turnRight();}
    public void turnLeft(){getMovable().turnLeft();}
    public void jumpFaster(double amount){getMovable().increaseSpeed(amount); }
    public void jumpSlower(double amount){getMovable().decreaseSpeed(amount); }
    public void checkSurroundings(){ System.out.println("x: " + getMovable().getx() + "   ,  y: "+ getMovable().gety()); }

    public void load(KangarooCub kangarooCub){ getCarry().loadInFront(kangarooCub.getMovable()); }
    public void load(WallabyCub wallabyCub){getCarry().loadInFront(wallabyCub.getMovable()); }
    public void unload(){
        if(getCarry().isUnloadable()){
            Movable unloaded = getCarry().getLoad().remove(getCarry().getVolume());
            unloaded.getStates().setIsTransportable(true);
            unloaded.getStates().setCanMove(true);
        }
    }

    public int getVolume(){ return getCarry().getVolume(); }
    public Movable getMovable(){return this.movable;}
    private Carry getCarry(){ return this.carry; }

}
