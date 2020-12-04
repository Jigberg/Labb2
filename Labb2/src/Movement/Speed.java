package Movement;

import SpeedChange.*;

import javax.sound.midi.SysexMessage;

public abstract class Speed extends Positionable {
    private double currentSpeed;
    private double maxForwardSpeed = 50;
    private double maxBackwardsSpeed = 50;
    private double maxSpeedIncrease = 50;
    private double maxSpeedDecrease = 50;
    private final SpeedChangeStratFactory speedChangeStratFactory;


    public Speed(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, double power, double maxForwardSpeed, double maxBackwardsSpeed,
                 double maxSpeedIncrease, double maxSpeedDecrease, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue){
        super(x, y, direction, isMovable, isTransportable);
        this.currentSpeed = 0;
        this.maxForwardSpeed = maxForwardSpeed;
        this.maxBackwardsSpeed = maxBackwardsSpeed;
        this.maxSpeedIncrease = maxSpeedIncrease;
        this.maxSpeedDecrease = maxSpeedDecrease;
        this.speedChangeStratFactory = new SpeedChangeStratFactory(power, speedChangeStrat, speedChangeStratValue);
    }
    public Speed(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, double power, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue) {
        super(x, y, direction, isMovable, isTransportable);
        this.currentSpeed = 0;
        this.speedChangeStratFactory = new SpeedChangeStratFactory(power, speedChangeStrat, speedChangeStratValue);
    }

    public void increaseSpeed(double amount){
        if(getStates().getCanMove()){
            double speedIncrease = getSpeedChangeStratFactory().getStrat().calculateSpeedChange(amount);
            if(isSpeedIncreaseInRange(speedIncrease)){
                setCurrentSpeed(getCurrentSpeed() + speedIncrease);
            }else{
                setCurrentSpeed(getMaxForwardSpeed());
            }
        }
    }
    public void decreaseSpeed(double amount){
        if(getStates().getCanMove()) {
            double speedDecrease = getSpeedChangeStratFactory().getStrat().calculateSpeedChange(amount);
            if (isSpeedDecreaseInRange(speedDecrease)) {
                setCurrentSpeed(getCurrentSpeed() - speedDecrease);
            } else {
                setCurrentSpeed(-getMaxBackwardsSpeed());
            }
        }
    }

    boolean isSpeedIncreaseInRange(double speedIncrease){ return speedIncrease <= getMaxSpeedIncrease() && getCurrentSpeed() + speedIncrease <= getMaxForwardSpeed(); }
    boolean isSpeedDecreaseInRange(double speedDecrease){ return speedDecrease <= getMaxSpeedDecrease() && getCurrentSpeed() - speedDecrease >= -getMaxBackwardsSpeed(); }
    public double getCurrentSpeed() { return currentSpeed; }
    double getMaxForwardSpeed(){ return this.maxForwardSpeed; }
    double getMaxBackwardsSpeed(){ return this.maxBackwardsSpeed; }
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
        getStates().setCurrentlyHasSpeed(getCurrentSpeed() != 0);
    }
    double getMaxSpeedDecrease() { return maxSpeedDecrease; }
    double getMaxSpeedIncrease() { return maxSpeedIncrease; }
    public SpeedChangeStratFactory getSpeedChangeStratFactory(){ return this.speedChangeStratFactory; }

}

