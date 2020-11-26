package Base_Classes;

import Uncategorized.VehicleProperties;

import java.awt.*;

public class Car_Transport {
    VehicleProperties vehicleProperties;
    public Car_Transport(Color color){
        this.vehicleProperties = new VehicleProperties(200, color, "The Car Transport");
    }
}
