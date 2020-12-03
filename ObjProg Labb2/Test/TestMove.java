import Base_Classes.Car_Transport;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestMove {

    @Test
    public void testMoveObject(){
        Car_Transport ct = new Car_Transport();
        ct.startEngine();
        ct.move();
    }


}
