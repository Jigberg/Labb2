package Graphical;

import Base_Classes.*;

import javax.sound.midi.SysexMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.vehicles.add(new Volvo240());
        cc.vehicles.add(new Saab95());
        cc.vehicles.add(new Scania());
        cc.vehicles.add(new Car_Transport());

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        cc.frame.drawPanel.setVehicleList(cc.vehicles);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
    * view to update its images. Change this method to your needs.
    * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : getVehicles()) {

                vehicle.move();
                int x = (int) Math.round(vehicle.getMovable().getx());
                int y = (int) Math.round(vehicle.getMovable().gety());
                if(!isInFrame(x,y)) {
                    vehicle.turnRight();
                    vehicle.turnRight();
                }
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
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
            vehicles.gas(gas);
        }
    }
    void brake(int amount){
        double brake = ((double) amount) / 100;
        for(Vehicle vehicle : vehicles){
            vehicle.brake(brake);
        }
    }
    void stopEngine(){
        for(Vehicle vehicle : vehicles){
            vehicle.stopEngine();
        }
    }

    void turnTurboOn(){
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).turboON();
            };
        }
    }

    void turnTurboOff(){
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof Saab95){
                ((Saab95) vehicle).turboOFF();
            };
        }
    }

    void liftBedButton(){
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania){
                ((Scania) vehicle).raiseRamp(10);
            };
        }
    }

    void lowerBedButton(){
        for(Vehicle vehicle : vehicles){
            if(vehicle instanceof Scania){
                ((Scania) vehicle).lowerRamp(10);
            };
        }
    }

    public ArrayList<Vehicle> getVehicles(){ return vehicles; }
}
