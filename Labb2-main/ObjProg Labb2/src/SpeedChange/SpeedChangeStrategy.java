package SpeedChange;

public abstract class SpeedChangeStrategy {
    private double power;

    public abstract Double calculateSpeedChange(Double amount);

    double getPower(){ return this.power; }
    public void setPower(double power){ this.power = power; }

}
