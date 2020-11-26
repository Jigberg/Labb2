package Base_Classes;

import Uncategorized.Direction;

import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Vehicles.Volvo240
 */

public class Volvo240{
    private final double trimFactor = 1.25;

    /**
     * Constructor for class.
     */
    public Volvo240() {
        super(0, 0, Direction.NORTH, 0, true, 100, Color.RED, "Volvo240");
    }

    /**
     * Calculates the speedfactor.
     * Uses trimFactor.
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

}
