package SpeedChange;

import Uncategorized.IVehicle;

public class BasicTrimFactorStrat extends SpeedChangeStrategy {
    private TrimFactor trimFactor;
    public BasicTrimFactorStrat(Double trimFactorValue){
        this.trimFactor = new TrimFactor(trimFactorValue);
    }

    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01*getTrimFactor().getEffect(); }

    TrimFactor getTrimFactor(){ return this.trimFactor; }
}
