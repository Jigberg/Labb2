package SpeedChange;

/**
 * @author Lukas, Emil, Martin.
 *  A class for a basic trimfactor used when calculating speed change.
 */
public class BasicTrimFactorStrat extends CalculateSpeedChangeStrat {
    public BasicTrimFactorStrat(Double trimFactorValue, double power){
        super(power);
        setTrimFactor(trimFactorValue);
    }

    /**
     * Calculates the speed increase using a trim factor.
     */
    @Override
    public Double calculateSpeedChange(Double amount) {
        return amount*getPower()*0.01*getTrimFactor().getEffect();

}

}
