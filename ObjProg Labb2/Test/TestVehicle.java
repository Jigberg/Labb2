import Base_Classes.*;
import Movement.Direction;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;


public class TestVehicle {

    @Test
    public void testStopEngine(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(2);
        volvo.stopEngine();
        assertEquals(volvo.currentSpeed(), 0, 0.001);
    }

    @Test
    public void testGasWithoutStart(){
        Volvo240 volvo = new Volvo240();
        volvo.gas(1);
        volvo.startEngine();
        assertEquals(volvo.currentSpeed(), 0, 0.001);
    }

    @Test
    public void testGasWithStart(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(1);
        assertEquals(volvo.currentSpeed(), 2.6, 0.001);
    }

    @Test
    public void testGas(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.gas(0.5);
        assertEquals(v.currentSpeed(), 1.3, 0.001);
    }

    @Test
    public void testBrake() {
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.gas(5.0);
        v.brake(2);
        assertEquals(v.currentSpeed(), 0, 0.001);
    }

    @Test
    public void testGasNegative(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.gas(-0.5);
        assertEquals(v.currentSpeed(), 0, 000.1);
    }

    @Test
    public void testMaxSpeed(){
        Volvo240 v = new Volvo240();
        v.startEngine();
        v.gas(100);
        v.gas(100);
        assertEquals(v.currentSpeed(), 5.2, 000.1);
    }

    @Test
    public void testTurbo(){
        Saab95 saab = new Saab95();
        saab.turboON();
        saab.startEngine();
        saab.gas(1);
        assertEquals(saab.currentSpeed(), 3.125, 0.001);
    }

    @Test
    public void testTurboOff(){
        Saab95 saab = new Saab95();
        saab.turboON();
        saab.startEngine();
        saab.turboOFF();
        saab.gas(1);
        assertEquals(saab.currentSpeed(), 2.5, 0.001);
    }

    @Test
    public void testTrimFactor(){
        Volvo240 volvo = new Volvo240();
        volvo.startEngine();
        volvo.gas(1);
        volvo.move();
        assertEquals(volvo.getMovable().getCurrentSpeed(), 2.6, 0.001);
    }

}
