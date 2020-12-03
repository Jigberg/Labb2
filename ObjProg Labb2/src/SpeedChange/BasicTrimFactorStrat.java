package SpeedChange;


public class BasicTrimFactorStrat extends CalculateSpeedChangeStrat {
    public BasicTrimFactorStrat(Double trimFactorValue, double power){
        super(power);
        setTrimFactor(trimFactorValue);
    }

    @Override
    public Double calculateSpeedChange(Double amount) {
        return amount*getPower()*0.01*getTrimFactor().getEffect();

}

}
