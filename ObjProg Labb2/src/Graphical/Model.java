package Graphical;

import Base_Classes.Vehicle;
import Movement.Enum_AccelerationFactor;
import Movement.Movable;
import Graphical.*;
import java.util.*;
import Base_Classes.*;

import javax.swing.text.WrappedPlainView;

public class Model {
    PiecesFactory piecesFactory = new PiecesFactory();
    List<Wrapper> pieces = getPiecesFactory().createWrapperList();

    public void updateCars(){
        for (Wrapper wrapper : getPieces()) {
            wrapper.getVehicle().move();
            int x = (int) Math.round(wrapper.getX());
            int y = (int) Math.round(wrapper.getY());
            if(!isInFrame(x,y)) {
                wrapper.getVehicle().turnRight();
                wrapper.getVehicle().turnRight();
            }
        }
    }

    boolean isInFrame(int x, int y){
        // System.out.println("am I in frame?");
        if(x > 800-100){ return false; }
        if(x < 0){ return false; }
        if(y > 560-60){ return false; }
        if(y < 0){ return false;}
        // System.out.println("in frame!");
        return true;
    }

//    public void move(){
//        for(Wrapper piece : getPieces()){
//            piece.getVehicle().getMovable().move();
//        }
//    }
    public void gas(double amount){
        System.out.println("gasing!, amount: " + amount);
        for(Wrapper piece : getPieces()){
            piece.getVehicle().gas(amount);
        }
    }
    public void brake(double amount){
        for(Wrapper piece : getPieces()){
            piece.getVehicle().brake(amount);
        }
    }
    public void liftBed(){
        for(Wrapper piece : getPieces()){
           if(!(piece.getRamp() == null)){
                piece.getRamp().raiseRamp(10);
           }
        }
    }

    public void lowerbed(){
        for(Wrapper piece : getPieces()){
            if(!(piece.getRamp() == null)){
                piece.getRamp().lowerRamp(10);
            }
        }
    }
    void stopEngine(){
        for(Wrapper piece : getPieces()){
            piece.getVehicle().stopEngine();
        }
    }

    void startEngine(){
        for(Wrapper piece : getPieces()){
            piece.getVehicle().startEngine();
        }
    }

    void turnTurboOn(){
        for(Wrapper piece : getPieces()){
            if(piece.hasTurbo()){
                piece.getVehicle().removeFactor(Enum_AccelerationFactor.TURBO);
                piece.getVehicle().addFactor(Enum_AccelerationFactor.TURBO, 1.25);
            }
        }
    }

    void turnTurboOff(){
        for(Wrapper piece : getPieces()){
            if(piece.hasTurbo()){
                System.out.println("removing turbo factor");
                piece.getVehicle().removeFactor(Enum_AccelerationFactor.TURBO);

            }
        }
    }

private PiecesFactory getPiecesFactory(){ return this.piecesFactory; }
public List<Wrapper> getPieces(){ return this.pieces; }

}
