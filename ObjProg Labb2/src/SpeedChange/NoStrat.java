package SpeedChange;

public class NoStrat extends CalculateSpeedChange {
    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01; }
}
