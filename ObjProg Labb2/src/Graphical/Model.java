package Graphical;

import Base_Classes.Vehicle;
import Movement.Movable;
import Graphical.*;
import java.util.*;
import Base_Classes.*;

import javax.swing.text.WrappedPlainView;

public class Model {
    PiecesFactory piecesFactory = new PiecesFactory();
    List<Wrapper> pieces = getPiecesFactory().createWrapperList();

    public void updateCars(){
        for (Vehicle vehicle : getVehicles()) {
            vehicle.move();
            int x = (int) Math.round(vehicle.getMovable().getx());
            int y = (int) Math.round(vehicle.getMovable().gety());
            if(!isInFrame(x,y)) {
                vehicle.turnRight();
                vehicle.turnRight();
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

    public void move(){
        for(Wrapper piece : getPieces()){
            piece.getVehicle().getMovable().move();
        }
    }
    public void gas(double amount){
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
            if(!(piece.getTurbo() == null)){
                piece.getTurbo().setTurboOn(true);
            }
        }
    }

    void turnTurboOff(){
        for(Wrapper piece : getPieces()){
            if(!(piece.getTurbo() == null)){
                piece.getTurbo().setTurboOn(false);
            }
        }
    }

private PiecesFactory getPiecesFactory(){ return this.piecesFactory; }
public List<Wrapper> getPieces(){ return this.pieces; }

}
