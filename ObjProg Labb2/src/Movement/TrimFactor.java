package Movement;

public class TrimFactor implements AccelerationFactor{
    private double trimFactor;

    public TrimFactor(double trimFactor){
        this.trimFactor = trimFactor;
    }

    @Override
    public double calculateEffect() { return getTrimFactor(); }
    @Override
    public boolean equals(Object o){ return o instanceof TrimFactor; }
    private double getTrimFactor(){ return this.trimFactor; }
}
