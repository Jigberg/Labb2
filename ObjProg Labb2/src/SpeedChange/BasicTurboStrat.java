package SpeedChange;

public class BasicTurboStrat extends CalculateSpeedChangeStrat {
    private Turbo turbo;

    public BasicTurboStrat(Double turboValue){
        this.turbo = new Turbo(turboValue);
    }

    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01*getTurbo().getEffect(); }

    public Turbo getTurbo(){ return this.turbo; }
}
