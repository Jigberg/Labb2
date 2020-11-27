package SpeedChange;

import Uncategorized.IVehicle;

public class BasicTrimFactorStrat extends SpeedChangeStrategy {
    private TrimFactor trimFactor;
    public BasicTrimFactorStrat(Double trimFactorValue){
        super();
        this.trimFactor = new TrimFactor(trimFactorValue);
    }
    @Override
    public Double calculateSpeedChange(Double amount) { return getPower()*0.01*getTrimFactor().getEffect(); }

    IVehicle getVehicleProperties(){ return this.IVehicle; }
    TrimFactor getTrimFactor(){ return this.trimFactor; }
}
