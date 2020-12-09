package Graphical;

import Base_Classes.Vehicle;
import Carry.Carry;
import Graphical.*;
import Graphical.Views.*;
import com.sun.tools.javac.Main;


import javax.swing.*;
import java.awt.*;
import java.awt.dnd.DragGestureEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
        private final int delay = 50;
        private final Timer timer = new Timer(delay, new TimerListener());

        private final Model model = new Model();
        private final PieceData pieceData = new PieceData(getModel().getPieces());
        private final DrawPanel drawPanel = new DrawPanel(getModel().getPieces());
        private final Buttons buttons = new Buttons();
        private final CarController carController = new CarController(getModel(), getButtons());
        private final MainFrame mainFrame = new MainFrame(Arrays.asList(getPieceData(), getDrawPanel(), getButtons()));


        /* Each step the TimerListener moves all the cars in the list and tells the
         * view to update its images. Change this method to your needs.
         * */
        private class TimerListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                getModel().updateCars();
                getDrawPanel().repaint();
                getPieceData().repaint();
                }
            }

        public void start(){ getTimer().start(); }

        Model getModel() {return this.model; }
        private Timer getTimer(){ return this.timer; }
        private CarController getCarController(){ return this.carController; }
        private Buttons getButtons(){ return this.buttons; }
        private DrawPanel getDrawPanel(){ return this.drawPanel; }
        private PieceData getPieceData(){ return this.pieceData;}
}


