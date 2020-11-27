package Uncategorized;
import Movement.Speed;

import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A superclass for vehicles reflecting a car.
 */

public class IVehicle {
    private final double enginePower; // Engine power of the car
    private Color color; // Color of the car
    private final String modelName; // The car model name

    /**
     * Constructor for the class Car.
     * Stops the car.
     * @param enginePower engine power of the car.
     * @param color color of the car.
     * @param modelName the cars model name.
     */
    public IVehicle(double enginePower, Color color, String modelName) {
        this.color = color;
        this.modelName = modelName;
        this.enginePower = enginePower;
    }

    /**
     * Stops the car engine.
     */
    public void stopEngine(Movement.Speed speed) { speed.setCurrentSpeed(0); }
    /**
     * Starts the car engine.
     */
    public void startEngine(Movement.Speed speed) {
        speed.setCurrentSpeed(0.1);
    }
    public void gas(double amount, Movement.Speed speed) { speed.changeSpeed(amount < 0 ? 0 : amount); }
    public void brake(double amount, Speed speed) { speed.changeSpeed(-amount); }
    public double getEnginePower() { return enginePower; }
}
