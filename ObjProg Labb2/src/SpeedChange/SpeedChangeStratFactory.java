package SpeedChange;

/**
 * @author Lukas, Emil, Martin.
 * A class for constructing speedchange strategies.
 */
public class SpeedChangeStratFactory {
    CalculateSpeedChangeStrat strat;

    public SpeedChangeStratFactory(double power, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue){
        this.strat = stratFactory(speedChangeStrat, speedChangeStratValue, power);
    }

    /**
     * Redirects to the chosen speed change strategy for the object. If it does not have one No_Strat is chosen.
     * @param power The objects power to increase its speed.
     * @param speedChangeStrat Which strat trim/turbo/neither the object has.
     * @param speedChangeStratValue How big effect the trim or boost will have.
     */
    public CalculateSpeedChangeStrat stratFactory(SpeedChangeStrat speedChangeStrat, double speedChangeStratValue, double power) {
        return switch (speedChangeStrat) {
            case BASIC_TURBO_STRAT -> new BasicTurboStrat(speedChangeStratValue, power);
            case BASIC_TRIMFACTOR_STRAT -> new BasicTrimFactorStrat(speedChangeStratValue, power);
            case NO_STRAT -> new NoStrat(power);
        };
    }

    /**
     * Getters and setters below.
     */
    public CalculateSpeedChangeStrat getStrat(){ return this.strat; }

}
