package Graphical;

import Base_Classes.*;
import Movement.Movable;

import java.util.ArrayList;
import java.util.List;

/**
 * Factory for creating all the game pieces.
 * Includes different
 */
public class PiecesFactory {
    public List<Vehicle> createCarList(){  // in future, plan is to add multiple methods with an enum as parameter.
        List<Vehicle> list = new ArrayList<>();
        list.add(new Volvo240());
        list.add(new Saab95());
        list.add(new Scania());
        return list;
    }
    public List<Movable> createGeneral(){
        List<Movable> list = new ArrayList<>();
        list.add(new Volvo240().getMovable());
        list.add(new Kangaroo().getMovable());
        return list;
    }
}
