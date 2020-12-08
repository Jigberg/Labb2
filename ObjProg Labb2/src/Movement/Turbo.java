package Movement;

public class Turbo implements AccelerationFactor{
    private double turboValue;

    public Turbo(double turboValue){
        this.turboValue = turboValue;
    }

    @Override
    public double calculateEffect() { return this.turboValue; }
    @Override
    public boolean equals(Object o){ return o instanceof Turbo; }

    private double getTurboValue(){ return this.turboValue; }
}
