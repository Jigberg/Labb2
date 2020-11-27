package FART;

import Uncategorized.VehicleProperties;

public class BasicTurboStrat implements SpeedChangeStrategy{
    private Turbo turbo;
    private VehicleProperties vehicleProperties;
    public BasicTurboStrat(Double turboValue, VehicleProperties vehicleProperties){
        this.turbo = new Turbo(turboValue);
        this.vehicleProperties = vehicleProperties;
    }
    @Override
    public Double calculateSpeedChange(Double amount) { return getVehicleProperties().getEnginePower()*0.01*getTurbo().getEffect(); }

    VehicleProperties getVehicleProperties(){ return this.vehicleProperties; }
    Turbo getTurbo(){ return this.turbo; }
}
