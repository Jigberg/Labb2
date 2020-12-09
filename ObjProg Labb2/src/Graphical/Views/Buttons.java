package Graphical.Views;

import Graphical.CarController;
import Graphical.MessageVoid;
import Graphical.Observer;

import javax.accessibility.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class Buttons extends JPanel implements IView{
    private static final int X = 800;
    private static final int Y = 800;
    private final Notifier notifier = new Notifier();

    public Buttons(){
        initComponents();
    }


    private void initComponents() {
        // gasPanel
        JPanel gasPanel = new JPanel();
        JLabel gasLabel = new JLabel("Amount of gas");

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step
        JSpinner gasSpinner = new JSpinner(spinnerModel);


        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);
        this.add(gasPanel);

        // controlPanel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new GridLayout(2, 4));

        // Buttons
        JButton gasButton = new JButton("Gas");
        gasButton.addActionListener(new NotifyObserverListener(getNotifier(), gasButton.getText(), gasSpinner.getAccessibleContext().getAccessibleValue()));

        JButton brakeButton = new JButton("Brake");
        brakeButton.addActionListener(new NotifyObserverListener(getNotifier(), brakeButton.getText(), gasSpinner.getAccessibleContext().getAccessibleValue()));

        JButton turboOnButton = new JButton("Saab Turbo on");
        turboOnButton.addActionListener(new NotifyObserverListener(getNotifier(), turboOnButton.getText()));

        JButton turboOffButton = new JButton("Saab Turbo off");
        turboOffButton.addActionListener(new NotifyObserverListener(getNotifier(), turboOffButton.getText()));

        JButton liftBedButton = new JButton("Scania Lift Bed");
        liftBedButton.addActionListener(new NotifyObserverListener(getNotifier(), liftBedButton.getText()));

        JButton lowerBedButton = new JButton("Scania Lower Bed");
        lowerBedButton.addActionListener(new NotifyObserverListener(getNotifier(), lowerBedButton.getText()));


        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);

        controlPanel.setPreferredSize(new Dimension((X / 2) + 4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);

        JButton startButton = new JButton("Start all cars");
        startButton.addActionListener(new NotifyObserverListener(getNotifier(), startButton.getText()));
        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(startButton);

        JButton stopButton = new JButton("Stop all cars");
        stopButton.addActionListener(new NotifyObserverListener(getNotifier(), stopButton.getText()));
        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X / 5 - 15, 200));
        this.add(stopButton);
    }

    public Notifier getNotifier() { return notifier; }
    public Component getComponent(){ return this; }
}