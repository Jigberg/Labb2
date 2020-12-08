package Graphical;

import Base_Classes.Vehicle;
import Carry.Carry;
import Graphical.*;
import Graphical.Views.Buttons;
import Graphical.Views.DrawPanel;
import Graphical.Views.IView;


import javax.swing.*;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Application {
        private final int delay = 50;
        private Timer timer = new Timer(delay, new TimerListener());


        private DrawPanel drawPanel = new DrawPanel();
        private Model model = new Model();
        private Buttons buttons = new Buttons("CarSim");

        private CarController carController = new CarController(getModel(), getButtons());


        /* Each step the TimerListener moves all the cars in the list and tells the
         * view to update its images. Change this method to your needs.
         * */
        private class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                getModel().updateCars();
                for ()
                }
            }

        public void start(){ getTimer().start(); }


        Model getModel() {return this.model; }
        private Timer getTimer(){ return this.timer; }
        private CarController getCarController(){ return this.carController; }
        private Buttons getButtons(){ return this.buttons; }
}


