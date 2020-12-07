package SpeedChange;

/**
 * @author Lukas, Emil, Martin.
 * A class for the trimfactor.
 */
public class TrimFactor {
    private final Double trimFactor;
    public TrimFactor(Double trimFactor){
        this.trimFactor = trimFactor;
    }

    /**
     * Getters and setters below.
     */
    public Double getEffect(){ return this.trimFactor; }
}
