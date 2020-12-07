import Base_Classes.Car_Transport;
import Movement.Direction;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestMove {

    @Test
    public void testMoveObject(){
        Car_Transport ct = new Car_Transport();
        ct.startEngine();
        ct.gas(1);
        ct.move();
        assertEquals(ct.positionY(),2.0,0.001);
    }

    @Test
    public void testTurnRight(){
        Car_Transport ct = new Car_Transport();
        ct.turnRight();
        assertSame(ct.direction(), Direction.EAST);
    }

    @Test
    public void testTurnLeft(){
        Car_Transport ct = new Car_Transport();
        ct.turnLeft();
        System.out.println(ct.direction());
        assertSame(ct.direction(), Direction.WEST);
    }
}
