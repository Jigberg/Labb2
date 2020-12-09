package Graphical;

import java.util.List;
import Graphical.Views.Buttons;
import Graphical.Views.Notifier;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements Observer{
    private final Model model;

    public CarController(Model model, Notifier... notifiers){
        this.model = model;
        for(Notifier notifier : notifiers){
            notifier.addObserver(this);
        }
    }

    @Override
    public void recieveMessage(String message, int amount) {
        System.out.println("cc, amount: " + amount);
        switch (message){
            case "Gas" -> getModel().gas(amount);
            case "Brake" -> getModel().brake(amount);
            case "Saab Turbo on" -> getModel().turnTurboOn();
            case "Saab Turbo off" -> getModel().turnTurboOff();
            case "Scania Lift Bed" -> getModel().liftBed();
            case "Scania Lower Bed" -> getModel().lowerbed();
            case "Start all cars" -> getModel().startEngine();
            case "Stop all cars" -> getModel().stopEngine();
        }
    }

    private Model getModel(){ return this.model;}
}
