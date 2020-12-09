package Movement;

import com.sun.jdi.Value;

import java.util.HashMap;
import java.util.Map;

public class Acceleration {
    private final double power;
    private final double maxAcceleration;
    private final double maxDeceleration;
    private final AccelerationFactorFactory accelerationFactorFactory = new AccelerationFactorFactory();
    private final Composite composite;

    public Acceleration(double power, double maxAcceleration, double maxDeceleration){
        this.power = power;
        this.maxAcceleration = maxAcceleration;
        this.maxDeceleration = maxDeceleration;
        this.composite = getAccelerationFactorFactory().createComposite();

    }

    public double calculateAcceleration(){ return 0.01*getPower()*getComposite().calculateEffect(); }

    public void addFactor(Enum_AccelerationFactor enum_accelerationFactor, double value){ getComposite().addFactor(getAccelerationFactorFactory().createAccelerationFactor(enum_accelerationFactor,value)); }
    public void addFactorComposite(Map<Enum_AccelerationFactor, Double> factorPairs){
        Composite comp = getAccelerationFactorFactory().createComposite() ;
        for (Map.Entry<Enum_AccelerationFactor, Double> entry : factorPairs.entrySet()){
            comp.addFactor(getAccelerationFactorFactory().createAccelerationFactor(entry.getKey(), entry.getValue()));
        }
        getComposite().addFactor(comp);
    }
    public void removeFactor(int index){ getComposite().removeFactor(index); }
    public void removeFactor(Enum_AccelerationFactor enum_accelerationFactor){ getComposite().removeFactor(getAccelerationFactorFactory().createAccelerationFactor(enum_accelerationFactor, 0));}

    private AccelerationFactorFactory getAccelerationFactorFactory() { return accelerationFactorFactory; }
    private Composite getComposite(){ return this.composite; }
    private double getPower(){ return this.power; }
}
