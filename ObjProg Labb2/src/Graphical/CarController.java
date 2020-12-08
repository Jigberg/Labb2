package Graphical;

import java.util.List;
import Graphical.Views.Buttons;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController implements Observer{
    private final Model model;

    public CarController(Model model, Buttons buttons){
        this.model = model;
        buttons.addObserver(this);
    }

    @Override
    public void recieveMessage(String message, int amount) {

        switch (message){
            case "Gas" -> getModel().gas(amount);
            case "Brake" -> getModel().brake(amount);
            case "StartEngine" -> getModel().startEngine();
            case "StopEngine" -> getModel().stopEngine();
            case "TurboOn" -> getModel().turnTurboOn();
            case "TurboOff" -> getModel().turnTurboOff();
            case "LiftBed" -> getModel().liftBed();
            case "LowerBed" -> getModel().lowerbed();
        }
    }

    private Model getModel(){ return this.model;}
}
