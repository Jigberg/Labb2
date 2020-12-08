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
    public List<Wrapper> createWrapperList(){  // in future, plan is to add multiple methods with an enum as parameter.
        List<Wrapper> list = new ArrayList<>();
        list.add(new Wrapper(new Volvo240(), "pics/Volvo240.jpg", null, null));
        Saab95 saab = new Saab95();
        list.add(new Wrapper(saab, "pics/Saab95.jpg", null, saab.getMovable().getSpeedChangeStratFactory().getStrat().getTurbo()));
        Scania scania = new Scania();
        list.add(new Wrapper(scania, "pics/Scania.jpg", scania.getRamp(), null));
        return list;
    }
}
