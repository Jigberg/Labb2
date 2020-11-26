package Base_Classes;

import Uncategorized.VehicleProperties;
import java.awt.*;

/**
 * @author Nicklas, Lukas, Emil, Martin.
 * A class for car model Vehicles.Volvo240
 */

public class Volvo240{
    VehicleProperties vehicleProperties;
    public Volvo240(Color color){
        this.vehicleProperties = new VehicleProperties(200, color, "The Car Transport");
    }
}
