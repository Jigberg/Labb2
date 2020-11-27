package Carry;

import Base_Classes.Ferry;

import java.util.ArrayList;

public class FerryCarry extends Carry<Ferry> {
    public FerryCarry(Ferry attachedTo){
        super(20, new ArrayList<>(), attachedTo);
    }
}
