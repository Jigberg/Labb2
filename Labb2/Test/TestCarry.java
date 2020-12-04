import Base_Classes.Car_Transport;
import Base_Classes.Saab95;
import Base_Classes.Scania;
import Base_Classes.Volvo240;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;

import javax.sound.midi.SysexMessage;

import static org.junit.Assert.*;


public class TestCarry {

    @Test
    public void TestLoad(){
        Saab95 s = new Saab95();
        Volvo240 v = new Volvo240();
        Scania sc = new Scania();
        Car_Transport ct = new Car_Transport();
        ct.load(s);
        ct.load(v);
        // ct.load(sc); compile error
        assertEquals(ct.getVolume(), 2);
    }

    @Test
    public void TestUnload(){
        Saab95 s = new Saab95();
        Volvo240 v = new Volvo240();
        Car_Transport ct = new Car_Transport();
        ct.load(s);
        ct.load(v);
        ct.unload();
        assertTrue(ct.getLoad().contains(s.getMovable()));
    }
    @Test
    public void TestLoadWhileMoving(){
        Saab95 s = new Saab95();
        Volvo240 v = new Volvo240();
        Car_Transport ct = new Car_Transport();
        ct.load(s);
        v.startEngine();
        ct.load(v);
        ct.unload();
        assertEquals(ct.getVolume(), 1);
    }

    @Test
    public void TestLoadWhenTooFarAway(){
        Saab95 s = new Saab95();
        Car_Transport ct = new Car_Transport();
        ct.startEngine();
        ct.gas(1);
        ct.gas(1);
        ct.stopEngine();
        ct.load(s);
        assertEquals(ct.getVolume(), 0);
    }

    @Test
    public void TestLoadTooManyCars(){
        Saab95 s = new Saab95();
        Saab95 s2 = new Saab95();
        Saab95 s3 = new Saab95();
        Saab95 s4 = new Saab95();

        Car_Transport ct = new Car_Transport();
        ct.startEngine();
        ct.gas(1);
        ct.gas(1);
        ct.stopEngine();
        ct.load(s);
        assertEquals(ct.getVolume(), 0);
    }

}
