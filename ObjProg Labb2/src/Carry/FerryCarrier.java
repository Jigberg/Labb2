package Carry;

import Base_Classes.Ferry;

import java.util.ArrayList;

public class FerryCarrier extends Carrier<Ferry>{
    public FerryCarrier(Ferry attachedTo){
        super(20, new ArrayList<>(), attachedTo);
    }
}
