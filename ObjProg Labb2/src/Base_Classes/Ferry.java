package Base_Classes;

import Uncategorized.VehicleProperties;

import java.awt.*;

public class Ferry {
    VehicleProperties vehicleProperties;
    public Ferry(Color color){
        this.vehicleProperties = new VehicleProperties(200, color, "The Car Transport");
    }
}
