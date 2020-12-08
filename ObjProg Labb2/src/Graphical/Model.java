package Graphical;

import Base_Classes.Vehicle;
import Movement.Movable;
import Graphical.*;
import java.util.*;
import Base_Classes.*;

public class Model {
    PiecesFactory piecesFactory = new PiecesFactory();
    List<Vehicle> pieces = getPiecesFactory().createCarList();

    public void move(){
        for(Vehicle piece : getPieces()){
            piece.getMovable().move();
        }
    }
    public void gas(double amount){
        for(Vehicle piece : getPieces()){
            piece.gas(amount);
        }
    }
    public void brake(double amount){
        for(Vehicle piece : getPieces()){
            piece.brake(amount);
        }
    }
    public void liftBed(int angle){
        for(Vehicle piece : getPieces()){
//            piece
        }
    }

    public void lowerbed(int angle){
//        for(Scania piece : getPieces()){

//        }
    }

private PiecesFactory getPiecesFactory(){ return this.piecesFactory; }
public List<Vehicle> getPieces(){ return this.pieces; }

}
