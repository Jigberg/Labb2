package SpeedChange;

import Uncategorized.IVehicle;

public class BasicTrimFactorStrat extends SpeedChangeStrategy {
    private TrimFactor trimFactor;
    private IVehicle IVehicle;
    public BasicTrimFactorStrat(Double trimFactorValue, IVehicle IVehicle){
        this.trimFactor = new TrimFactor(trimFactorValue);
        this.IVehicle = IVehicle;
    }
    @Override
    public Double calculateSpeedChange(Double amount) { return getVehicleProperties().getEnginePower()*0.01*getTrimFactor().getEffect(); }

    IVehicle getVehicleProperties(){ return this.IVehicle; }
    TrimFactor getTrimFactor(){ return this.trimFactor; }
}
