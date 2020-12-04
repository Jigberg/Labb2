package SpeedChange;

public class NoStrat extends CalculateSpeedChangeStrat {
    public NoStrat(double power){ super(power); }

    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01; }
}
