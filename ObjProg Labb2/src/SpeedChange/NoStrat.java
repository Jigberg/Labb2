package SpeedChange;

public class NoStrat extends SpeedChangeStrategy {
    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01; }
}
