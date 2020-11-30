import Base_Classes.*;
import Carry.KangarooCarry;

public class main {
    public static void main(String[] args) { (new main()).program(); }

    void program(){
        volvo();
    }

    void volvo(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(10.0);
        System.out.println(volvo.getMovable().getCurrentSpeed());
        volvo.brake(10.0);
        System.out.println(volvo.getMovable().getCurrentSpeed());

    }

    void kangaroo(){
        Kangaroo kängru = new Kangaroo();
        kängru.jumpFaster(500000000);
        kängru.move();
        kängru.checkSurroundings();
        KangarooCub kängruBebis = new KangarooCub();
        kängru.load(kängruBebis);
        System.out.println(kängru.getCarry().getLoad());

    }

    void saab(){
        Saab95 saab = new Saab95();
        saab.move();
    }

    void Ct(){
        Car_Transport Ct = new Car_Transport();
        Ct.move();

    }
}
