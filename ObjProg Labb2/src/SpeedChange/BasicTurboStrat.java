package SpeedChange;

public class BasicTurboStrat extends SpeedChangeStrategy {
    private Turbo turbo;

    public BasicTurboStrat(Double turboValue){
        this.turbo = new Turbo(turboValue);
    }

    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01*getTurbo().getEffect(); }

    Turbo getTurbo(){ return this.turbo; }
}
