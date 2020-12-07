package SpeedChange;

/**
 * @author Lukas, Emil, Martin.
 * A superclass for the different speedchange strategies.
 */
public abstract class CalculateSpeedChangeStrat {
    private double power;
    private Turbo turbo;
    private TrimFactor trimFactor;

    public CalculateSpeedChangeStrat(double power){
        this.power = power;
    }

    /**
     * @param amount to change speed.
     * @return the calculated speed change based on strategy.
     */
    public abstract Double calculateSpeedChange(Double amount);

    /**
     * Getters and setters below.
     */
    public Turbo getTurbo() { return this.turbo; }
    public TrimFactor getTrimFactor(){ return this.trimFactor; }
    protected double getPower(){ return this.power; }
    protected void setPower(double power){ this.power = power; }
    protected void setTrimFactor(double trimFactorValue) { this.trimFactor = new TrimFactor(trimFactorValue); }
    protected void setTurbo(double turboValue){ this.turbo = new Turbo(turboValue); }


}
