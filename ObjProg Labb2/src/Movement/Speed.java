package Movement;

import SpeedChange.SpeedChangeStrategy;

public class Speed {
    private double currentSpeed;
    private double maxSpeed;
    private final SpeedChangeStrategy strat;
    private double power;


    public Speed(double currentSpeed, double maxSpeed, SpeedChangeStrategy strat, Double power){
        this.currentSpeed = currentSpeed;
        this.maxSpeed = maxSpeed;
        this.strat = strat;
    }

    public double getPower(){ return this.power; }
    public double getCurrentSpeed() { return currentSpeed; }
    public double getMaxSpeed(){ return this.maxSpeed; }
    SpeedChangeStrategy getStrat(){ return this.strat; }
    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }

    public void changeSpeed(double amount){
        if(!isSpeedChangeInRange(amount)){
            setSpeedMaxOrMin(amount);
        }else{
            setCurrentSpeed(strat.calculateSpeedChange(amount));}
    }

    void setSpeedMaxOrMin(double amount){
        setCurrentSpeed((calculateSpeedChange(amount) + getCurrentSpeed()) < -1 ? 0 : getMaxSpeed());
    }

    boolean isSpeedChangeInRange(double amount){ return 0 <= getCurrentSpeed() + getStrat().calculateSpeedChange(amount) && getCurrentSpeed() + getStrat().calculateSpeedChange(amount) <= getMaxSpeed();}


}
