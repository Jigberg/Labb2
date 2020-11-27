package SpeedChange;

import Uncategorized.IVehicle;

public class BasicTurboStrat extends SpeedChangeStrategy {
    private Turbo turbo;
    private IVehicle IVehicle;
    public BasicTurboStrat(Double turboValue, IVehicle IVehicle){
        this.turbo = new Turbo(turboValue);
        this.IVehicle = IVehicle;
    }
    @Override
    public Double calculateSpeedChange(Double amount) { return getVehicleProperties().getEnginePower()*0.01*getTurbo().getEffect(); }

    IVehicle getVehicleProperties(){ return this.IVehicle; }
    Turbo getTurbo(){ return this.turbo; }
}
