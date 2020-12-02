import Base_Classes.*;

public class main {
    public static void main(String[] args) { (new main()).program(); }

    void program(){
        kangaroo();
    }

    void volvo(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(10.0);
        System.out.println(volvo.getMovable().getCurrentSpeed());
        volvo.move();
        System.out.println(volvo.getMovable().getx() + "  " + volvo.getMovable().gety());
    }

    void kangaroo(){
        Kangaroo kängru = new Kangaroo();
        kängru.jumpFaster(500000000);
        kängru.move();
        kängru.checkSurroundings();
        KangarooCub joey = new KangarooCub();
        kängru.load(joey);
        System.out.println(kängru.getVolume());

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
