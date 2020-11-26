package Uncategorized;

public class Turbo {
    private Double turboValue;
    private boolean turboOn = false;
    public Turbo(Double turboValue){
        this.turboValue = turboValue;
    }
    public boolean getTurboOn(){ return this.turboOn; }
    public double getTurboValue(){ return this.turboValue; }
    public void setTurboOn(Boolean turboOn) { this.turboOn = turboOn;}
    }
