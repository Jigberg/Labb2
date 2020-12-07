package SpeedChange;

/**
 * @author Lukas, Emil, Martin.
 * A class for a speedchange strategie that does not change the calculation with any special effect.
 */
public class NoStrat extends CalculateSpeedChangeStrat {
    public NoStrat(double power){ super(power); }


    /**
     * Calculates the speed increase without any special effect.
     */
    @Override
    public Double calculateSpeedChange(Double amount) { return amount*getPower()*0.01; }
}
