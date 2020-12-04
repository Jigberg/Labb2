package SpeedChange;

public class BasicTurboStrat extends CalculateSpeedChangeStrat {

    public BasicTurboStrat(Double turboValue, double power){
        super(power);
        setTurbo(turboValue);
    }

    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01*getTurbo().getEffect(); }

}
