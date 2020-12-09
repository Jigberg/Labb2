package Graphical;

import Base_Classes.*;
import Movement.Direction;
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
        list.add(new Wrapper(new Volvo240(), "pics/Volvo240.jpg", null, false));
        list.add(new Wrapper(new Saab95(200, 0, Direction.NORTH), "pics/Saab95.jpg", null, true));
        Scania scania = new Scania(400, 0, Direction.NORTH);
        list.add(new Wrapper(scania, "pics/Scania.jpg", scania.getRamp(), false));
        return list;
    }
}
