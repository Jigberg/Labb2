package SpeedChange;

public abstract class CalculateSpeedChangeStrat {
    private double power;
    private Turbo turbo;
    private TrimFactor trimFactor;

    public CalculateSpeedChangeStrat(double power){
        this.power = power;
    }

    public abstract Double calculateSpeedChange(Double amount);

    public Turbo getTurbo() { return this.turbo; }
    public TrimFactor getTrimFactor(){ return this.trimFactor; }
    double getPower(){ return this.power; }
    public void setPower(double power){ this.power = power; }
    void setTrimFactor(double trimFactorValue) { this.trimFactor = new TrimFactor(trimFactorValue); }
    void setTurbo(double turboValue){ this.turbo = new Turbo(turboValue); }


}
