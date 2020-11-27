package Carry;

import Base_Classes.Kangaroo;
import java.util.Stack;

public class KangarooCarry extends Carry<Kangaroo> {
    public KangarooCarry(Kangaroo attachedTo) {
        super(2, new Stack<>(), attachedTo);
    }
}
