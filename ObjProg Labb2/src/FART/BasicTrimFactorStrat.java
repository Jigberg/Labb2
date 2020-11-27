package FART;

import Uncategorized.VehicleProperties;

public class BasicTrimFactorStrat implements SpeedChangeStrategy{
    private TrimFactor trimFactor;
    private VehicleProperties vehicleProperties;
    public BasicTrimFactorStrat(Double trimFactorValue, VehicleProperties vehicleProperties){
        this.trimFactor = new TrimFactor(trimFactorValue);
        this.vehicleProperties = vehicleProperties;
    }
    @Override
    public Double calculateSpeedChange(Double amount) { return getVehicleProperties().getEnginePower()*0.01*getTrimFactor().getEffect(); }

    VehicleProperties getVehicleProperties(){ return this.vehicleProperties; }
    TrimFactor getTrimFactor(){ return this.trimFactor; }
}
