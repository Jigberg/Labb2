package Graphical;
import java.util.*;

public class MessageVoid {
    List<Observer> observers;

    void notifyObservers(String message, int amount){
        for(Observer o : getObservers()){
            o.recieveMessage(message, amount);
        }
    }

    void addObserver(Observer o){
        getObservers().add(o);
    }
    void removeObserver(Observer o){
        getObservers().remove(o);
    }

    List<Observer> getObservers(){ return observers; }

}
