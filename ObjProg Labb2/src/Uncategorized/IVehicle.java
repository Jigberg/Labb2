package Uncategorized;
import Movement.Movable;
import Movement.Speed;

import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A superclass for vehicles reflecting a car.
 */

public interface IVehicle {
    void stopEngine();
    void startEngine();
    void gas(double amount);
    void brake(double amount);
    public Movable getMovable();
}

