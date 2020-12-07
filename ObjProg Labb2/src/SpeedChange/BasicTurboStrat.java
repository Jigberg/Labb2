package SpeedChange;

/**
 * @author Lukas, Emil, Martin.
 * A class for a basic turbostrat used when calculating speedchange.
 */
public class BasicTurboStrat extends CalculateSpeedChangeStrat {

    public BasicTurboStrat(Double turboValue, double power){
        super(power);
        setTurbo(turboValue);
    }

    /**
     * Calculates the speed increase using a turbo factor.
     */
    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01*getTurbo().getEffect(); }

}
