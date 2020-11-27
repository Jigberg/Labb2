package Base_Classes;

import Uncategorized.IVehicle;

import java.awt.*;

public class Ferry {
    IVehicle IVehicle;
    public Ferry(Color color){
        this.IVehicle = new IVehicle(200, color, "The Car Transport");
    }
}
