package Carriers;

import Base_Classes.Kangaroo;
import java.util.Stack;

public class KangarooCarrier extends Carrier<Kangaroo>{
    public KangarooCarrier(Kangaroo attachedTo) {
        super(2, new Stack<>(), attachedTo);
    }
}
