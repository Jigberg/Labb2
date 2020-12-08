package Graphical;

import Base_Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import Graphical.*;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    private List<Vehicle> vehicles;

    private Model model = new Model();

    public CarController(List<Vehicle> vehicles){
        this.vehicles = vehicles;
    }

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

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicles : vehicles){
            getModel().move();
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for(Vehicle vehicle : vehicles){
        getModel().move();
        }
    }
    void stopEngine(){
        for(Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

    void startEngine(){
        for(Vehicle vehicle : vehicles){
            vehicle.startEngine();
        }
    }

    void turnTurboOn(){
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).turboON();
            }
        }
    }

    void turnTurboOff(){
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).turboOFF();
            }
        }
    }

    void liftBedButton(){
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania){
                ((Scania) vehicle).raiseRamp(10);
            }
        }
    }

    void lowerBedButton(){
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania){
                ((Scania) vehicle).lowerRamp(10);
            }
        }
    }

    public List<Vehicle> getVehicles(){ return vehicles; }
    private Model getModel(){ return this.model;}
}
