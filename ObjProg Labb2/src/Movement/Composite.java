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

    /**
     * If client do removeFactor(Composite) all composites disregarding content will be removed.
     * If client do removeFactor(Turbo) all composites with only turbo factors will be removed.
     * @param o the comparing object.
     * @return If client do removeFactor(Composite) all composites disregarding content will be removed.
     * Or If client do f.ex. removeFactor(Turbo) all composites with only turbo factors will be removed.
     *
     */
    @Override
    public boolean equals(Object o){
        if(o instanceof Composite){ return true; }
        for(AccelerationFactor factor : getFactors()){
            if(!factor.equals(o)){ return false; }
        }
        return true;
    }

    public List<AccelerationFactor> getFactors() { return this.factors; }
}
