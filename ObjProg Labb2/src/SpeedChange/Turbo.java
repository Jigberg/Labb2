package SpeedChange;

/**
 * @author Lukas, Emil, Martin.
 * A class for the turbo.
 */
public class Turbo {
    private final Double turboValue;
    private boolean turboOn;

    public Turbo(Double turboValue){
        this.turboValue = turboValue;
    }

    boolean getTurboOn(){ return this.turboOn; }
    double getTurboValue(){ return this.turboValue; }
    public void setTurboOn(boolean turboOn) { this.turboOn = turboOn; }

    /**
     *
     * @return the turbovalue if the turbo is currently ON.
     */
    protected Double getEffect(){ return getTurboOn() ? getTurboValue() : 1; }
    }
