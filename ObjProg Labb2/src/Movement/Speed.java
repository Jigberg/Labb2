package Movement;

import SpeedChange.SpeedChangeStrategy;

public class Speed extends Positionable{
    private double currentSpeed;
    private double power;
    private final SpeedChangeStrategy strat;
    private double maxForwardSpeed;
    private double maxBackwardsSpeed;
    private double maxSpeedIncrease;
    private double maxSpeedDecrease;


    public Speed(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, double power, SpeedChangeStrategy strat, double maxForwardSpeed, double maxBackwardsSpeed, double maxSpeedIncrease, double maxSpeedDecrease){
        super(x, y, direction, isMovable, isTransportable);
        this.currentSpeed = 0;
        this.power = power;
        this.strat = strat;
        this.strat.setPower(power);
        this.maxForwardSpeed = maxForwardSpeed;
        this.maxBackwardsSpeed = maxBackwardsSpeed;
        this.maxSpeedIncrease = maxSpeedIncrease;
        this.maxSpeedDecrease = -maxSpeedDecrease;
    }
    public Speed(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, double power, SpeedChangeStrategy strat) {
        super(x, y, direction, isMovable, isTransportable);
        this.currentSpeed = 0;
        this.power = power;
        this.strat = strat;
        this.strat.setPower(power);
    }

    public void increaseSpeed(double amount){
        double speedIncrease = getStrat().calculateSpeedChange(amount);
        if(isSpeedIncreaseInRange(speedIncrease)){
            setCurrentSpeed(getCurrentSpeed() + speedIncrease);
        }else{
            setCurrentSpeed(getMaxForwardSpeed());
        }
        if(getCurrentSpeed() != 0){
            getStates().setCurrentlyHasSpeed(true);
        }
    }
    public void decreaseSpeed(double amount){
        double speedDecrease = getStrat().calculateSpeedChange(amount);
        if(isSpeedDecreaseInRange(speedDecrease)){
            setCurrentSpeed(getCurrentSpeed() - speedDecrease);
        }else{
            setCurrentSpeed(-getMaxBackwardsSpeed());
        }
        if(getCurrentSpeed() != 0){
            getStates().setCurrentlyHasSpeed(true);
        }
    }

    boolean isSpeedIncreaseInRange(double speedIncrease){ return speedIncrease <= getMaxSpeedIncrease() && getCurrentSpeed() + speedIncrease <= getMaxForwardSpeed(); }
    boolean isSpeedDecreaseInRange(double speedDecrease){ return speedDecrease <= getMaxSpeedDecrease() && getCurrentSpeed() - speedDecrease >= -getMaxBackwardsSpeed(); }
    public double getPower(){ return this.power; }
    double getCurrentSpeed() { return currentSpeed; }
    double getMaxForwardSpeed(){ return this.maxForwardSpeed; }
    double getMaxBackwardsSpeed(){ return this.maxBackwardsSpeed; }
    SpeedChangeStrategy getStrat(){ return this.strat; }
    public void setCurrentSpeed(double currentSpeed) { this.currentSpeed = currentSpeed; }
    double getMaxSpeedDecrease() { return maxSpeedDecrease; }
    double getMaxSpeedIncrease() { return maxSpeedIncrease; }

}
