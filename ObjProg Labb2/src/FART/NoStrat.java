package FART;

public class NoStrat implements SpeedChangeStrategy{
    public NoStrat(){}
    @Override
    public Double calculateSpeedChange(Double amount) {
        return null;
    }
}
