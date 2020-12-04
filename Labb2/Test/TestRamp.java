import Base_Classes.Car_Transport;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;
import Base_Classes.*;


public class TestRamp {
//    @Test
//    public void testMoveRampUp(){
//        Car_Transport ct = new Car_Transport();
//        ct.raiseRamp(90);
//        ct.startEngine();
//        ct.gas(1);
//        ct.move();
//        assertEquals(ct.positionY(),2.0,0.001);
//    }
//
//    @Test
//    public void testMoveRampDown(){
//        Car_Transport ct = new Car_Transport();
//        ct.lowerRamp(90);
//        ct.startEngine();
//        ct.gas(1);
//        ct.move();
//        assertEquals(ct.positionY(),0.0,0.001);
//    }

    @Test
    public void testMoveScaniaRampUp(){
        Scania scania = new Scania();
        scania.raiseRamp(70);
        scania.startEngine();
        scania.gas(1);
        scania.move();
        assertEquals(scania.positionY(),0.0,0.001);
    }
}
