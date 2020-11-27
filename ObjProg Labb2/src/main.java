import Base_Classes.Volvo240;

public class main {
    public static void main(String[] args) { (new main()).program(); }

    void program(){
        Volvo240 volvo = new Volvo240();
        volvo.move();
        volvo.turnLeft();

//        volvo.turnLeft();
    }
}
