package Graphical;

import Base_Classes.Saab95;
import Base_Classes.Scania;
import Base_Classes.Vehicle;
import Base_Classes.Volvo240;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class CarSim {
        private final int delay = 50;
        private Timer timer = new Timer(delay, new TimerListener());

        List<Vehicle> vehicles = (new CarFactory()).createCarList();
        Frame frame = new Frame();
        CarController carController = new CarController(getVehicles());


        /* Each step the TimerListener moves all the cars in the list and tells the
         * view to update its images. Change this method to your needs.
         * */
        private class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                getCarController().updateCars();
                getFrame().paint();
                }
            }

        public void start(){ getTimer().start(); }


        private Timer getTimer(){ return this.timer; }
        private Frame getFrame(){ return this.frame; }
        private CarController getCarController(){ return this.carController; }
        private List<Vehicle> getVehicles(){ return this.vehicles; }
}


