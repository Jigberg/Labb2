package SpeedChange;

public class NoStrat extends CalculateSpeedChangeStrat {
    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01; }
}
