import Base_Classes.Car_Transport;
import Base_Classes.Saab95;
import Base_Classes.Volvo240;

public class main {
    public static void main(String[] args) { (new main()).program(); }

    void program(){
        Volvo240 volvo = new Volvo240();
        volvo.move();
        volvo.turnLeft();
        volvo.turnRight();

//        volvo.turnLeft();
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
