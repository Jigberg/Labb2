package Graphical.Views;

import Graphical.Observer;

import java.util.ArrayList;
import java.util.List;

public class Notifier {
    List<Graphical.Observer> observers = new ArrayList<>();

    void notifyObservers(String message, int amount){
        for(Graphical.Observer o : getObservers()){
            o.recieveMessage(message, amount);
        }
    }

    public void addObserver(Graphical.Observer o){
        getObservers().add(o);
    }
    void removeObserver(Graphical.Observer o){
        getObservers().remove(o);
    }

    List<Observer> getObservers(){ return observers; }
}
