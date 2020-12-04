package SpeedChange;

public class SpeedChangeStratFactory {
    CalculateSpeedChangeStrat strat;

    public SpeedChangeStratFactory(double power, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue){
        this.strat = stratFactory(speedChangeStrat, speedChangeStratValue, power);
    }

    public CalculateSpeedChangeStrat stratFactory(SpeedChangeStrat speedChangeStrat, double speedChangeStratValue, double power) {
        return switch (speedChangeStrat) {
            case BASIC_TURBO_STRAT -> new BasicTurboStrat(speedChangeStratValue, power);
            case BASIC_TRIMFACTOR_STRAT -> new BasicTrimFactorStrat(speedChangeStratValue, power);
            case NO_STRAT -> new NoStrat(power);
        };
    }

    public CalculateSpeedChangeStrat getStrat(){ return this.strat; }

}
