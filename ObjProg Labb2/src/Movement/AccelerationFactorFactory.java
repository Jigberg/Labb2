package Movement;

public class AccelerationFactorFactory {
    AccelerationFactor createAccelerationFactor(Enum_AccelerationFactor enum_accelerationFactor, double value) {
        return switch (enum_accelerationFactor) {
            case TURBO -> new Turbo(value);
            case TRIMFACTOR -> new TrimFactor(value);

        };
    }
    Composite createComposite(AccelerationFactor...factors){
       Composite composite = new Composite();
       for(AccelerationFactor factor : factors){
        composite.addFactor(factor);
       }
       return composite;
    }
}
