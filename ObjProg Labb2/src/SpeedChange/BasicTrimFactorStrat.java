package SpeedChange;


public class BasicTrimFactorStrat extends CalculateSpeedChangeStrat {
    private final TrimFactor trimFactor;
    public BasicTrimFactorStrat(Double trimFactorValue){
        this.trimFactor = new TrimFactor(trimFactorValue);
    }

    @Override
    public Double calculateSpeedChange(Double amount) {
        return amount*getPower()*0.01*getTrimFactor().getEffect(); }

    TrimFactor getTrimFactor(){ return this.trimFactor; }
}
