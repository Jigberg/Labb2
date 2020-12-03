package Graphical;

import Base_Classes.Saab95;
import Base_Classes.Scania;
import Base_Classes.Vehicle;
import Base_Classes.Volvo240;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public List<Vehicle> createCarList(){  // in future, plan is to add multiple methods with an enum as parameter.
        List<Vehicle> list = new ArrayList<>();
        list.add(new Volvo240());
        list.add(new Saab95());
        list.add(new Scania());
        return list;
    }
}
