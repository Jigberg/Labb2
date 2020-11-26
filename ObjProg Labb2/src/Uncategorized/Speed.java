package Uncategorized;

public class Speed {
    private double currentSpeed;
    private double maxSpeed;

    public double getCurrentSpeed() { return currentSpeed; }
    public double getMaxSpeed(){ return this.maxSpeed; }
    /**
     * Decrements the speed a specified amount.
     * Checks if current speed is in interval [-1, enginePower]
     * @param currentSpeed The speed that the car already has.
     */
    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }
    public void changeSpeed(double amount){
        if(!isSpeedChangeInRange(amount)){
            setSpeedMaxOrMin(amount);
        }else{
            setCurrentSpeed(calculateSpeedChange(amount));}
    }
    public double calculateSpeedChange(double amount){ return getCurrentSpeed() + amount; }

    public void setSpeedMaxOrMin(double amount){
        setCurrentSpeed((calculateSpeedChange(amount) + getCurrentSpeed()) < -1 ? 0 : getMaxSpeed());
    }

    public boolean isSpeedChangeInRange(double amount){
        return (-1 <= getCurrentSpeed() + amount && getCurrentSpeed() + amount < getMaxSpeed()); }
}
