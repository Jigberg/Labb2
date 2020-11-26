package Base_Classes;

import Uncategorized.VehicleProperties;

import java.awt.*;

public class Scania {
    VehicleProperties vehicleProperties;
    public Scania(Color color){
        this.vehicleProperties = new VehicleProperties(300, color, "The Scania");
    }
}
