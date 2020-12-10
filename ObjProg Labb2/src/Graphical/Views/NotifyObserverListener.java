package Graphical.Views;

import javax.accessibility.AccessibleValue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NotifyObserverListener implements ActionListener {
    private final String message;
    private final AccessibleValue accessibleValue;
    private final Notifier notifier;

    public NotifyObserverListener(Notifier notifier, String message, AccessibleValue accessibleValue){
        this.notifier = notifier;
        this.message = message;
        this.accessibleValue = accessibleValue;
    }
    public NotifyObserverListener(Notifier notifier, String message){
        this.notifier = notifier;
        this.message = message;
        this.accessibleValue = new AccessibleValue() {
            @Override
            public Number getCurrentAccessibleValue() {
                return 0;
            }
            @Override
            public boolean setCurrentAccessibleValue(Number n) {
                return false;
            }
            @Override
            public Number getMinimumAccessibleValue() {
                return 0;
            }
            @Override
            public Number getMaximumAccessibleValue() {
                return 0;
            }
        };
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getNotifier().notifyObservers(getMessage(), (int) getAccessibleValue().getCurrentAccessibleValue());
    }

    public String getMessage() { return message; }
    public AccessibleValue getAccessibleValue() { return accessibleValue; }
    public Notifier getNotifier() { return notifier; }
}
