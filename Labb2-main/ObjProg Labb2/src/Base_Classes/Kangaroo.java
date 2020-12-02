package Base_Classes;

import Carry.KangarooCarry;
import Movement.Direction;
import Movement.Movable;
import SpeedChange.NoStrat;

public class Kangaroo{
    private final KangarooCarry carry = new KangarooCarry(getMovable());
    private final Movable movable;

    public Kangaroo (){
        this.movable = new Movable(0, 0, Direction.NORTH, true, true, 50);
    }

    public void load(KangarooCub kangarooCub){ getCarry().load(kangarooCub.getMovable()); }
    public void unload(){ getCarry().unload(); }

    public void move(){ getMovable().move();}
    public void turnRight(){getMovable().turnRight();}
    public void turnLeft(){getMovable().turnLeft();}
    public void jumpFaster(double amount){getMovable().increaseSpeed(amount); }
    public void jumpSlower(double amount){getMovable().decreaseSpeed(amount); }
    public void checkSurroundings(){ System.out.println("x: " + getMovable().getx() + "   ,  y: "+ getMovable().gety()); }

    public Movable getMovable(){return this.movable;}
    public KangarooCarry getCarry(){ return this.carry; }

}
