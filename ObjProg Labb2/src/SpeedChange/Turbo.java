package SpeedChange;

public class Turbo {
    private Double turboValue;
    private boolean turboOn = false;

    public Turbo(Double turboValue){
        this.turboValue = turboValue;
    }

    boolean getTurboOn(){ return this.turboOn; }
    double getTurboValue(){ return this.turboValue; }
    public void setTurboOn(boolean turboOn) { this.turboOn = turboOn; }

    Double getEffect(){ return getTurboOn() ? getTurboValue() : 1; }
    }
