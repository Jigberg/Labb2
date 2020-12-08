package Movement;

import java.util.ArrayList;
import java.util.List;

public class Composite implements AccelerationFactor{
    List<AccelerationFactor> factors = new ArrayList<>();

    void addFactor(AccelerationFactor factor){ getFactors().add(factor); }
    void removeFactor(int index){ getFactors().remove(index); }
    void removeFactor(AccelerationFactor factor){ getFactors().remove(factor); }

    @Override
    public double calculateEffect() {
        double effect = 1;
        for(AccelerationFactor factor : getFactors()){
            effect *= factor.calculateEffect();
        }
        return effect;
    }

    public List<AccelerationFactor> getFactors() { return this.factors; }
}
