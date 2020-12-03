package Ramp;

import Movement.Speed;

public class Ramp{
    private int angle;
    private int maxAngle;
    private int minAngle;

    public Ramp(int angle, int maxAngle, int minAngle){
        this.angle = angle;
        this.maxAngle = maxAngle;
        this.minAngle = minAngle;

    }

    public int raisableAngle(){ return getMaxAngle() - getAngle(); }
    public int lowerableAngle(){ return getAngle() - getMinAngle(); }

    public int getAngle(){ return this.angle; }
    public void setAngle(int angle){ this.angle = angle; }
    public int getMaxAngle(){ return this.maxAngle; }
    public int getMinAngle(){ return this.minAngle; }
}
