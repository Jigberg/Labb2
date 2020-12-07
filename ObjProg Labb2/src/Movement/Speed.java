package Movement;

import SpeedChange.*;

import javax.sound.midi.SysexMessage;

/**
 * @author Lukas, Emil, Martin.
 * A class for speed, used for movable.
 */
public abstract class Speed extends Positionable {
    private double currentSpeed;
    private double maxForwardSpeed = 50;
    private double maxBackwardsSpeed = 50;
    private double maxSpeedIncrease = 50;
    private double maxSpeedDecrease = 50;
    private final SpeedChangeStratFactory speedChangeStratFactory;


    /**
     * Constructor that sets a speed-change-strategy via the factory.
     */
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

    /**
     * Constructor that sets a speed-change-strategy via the factory.
     */
    public Speed(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, double power, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue) {
        super(x, y, direction, isMovable, isTransportable);
        this.currentSpeed = 0;
        this.speedChangeStratFactory = new SpeedChangeStratFactory(power, speedChangeStrat, speedChangeStratValue);
    }

    /**
     * Checks if the object is eligible for the speed increase.
     * Increases the speed of the object with a factor "speedFactor", calculated in a unique speedStrat.
     * Does not let the object go over its maximum speed.
     * @param amount Chosen by the user.
     */
    public void increaseSpeed(double amount){
        if(getStates().getCanMove()) {
            double speedIncrease = getSpeedChangeStratFactory().getStrat().calculateSpeedChange(amount);
            if (isSpeedIncreaseInRange(speedIncrease)) {
                setCurrentSpeed(getCurrentSpeed() + speedIncrease);
            } else {
                setCurrentSpeed(getMaxForwardSpeed());
            }
        }
    }

    /**
     * Checks if the object is eligible for the speed decrease.
     * Decreases the speed of the object with a factor "speedFactor", calculated in a unique speedStrat.
     * @param amount Chosen by the user.
     */
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


    /**
     *
     * @param speedIncrease
     * @return if the speed increase is in the acceptable range specified in the constructor.
     */
    boolean isSpeedIncreaseInRange(double speedIncrease){ return speedIncrease <= getMaxSpeedIncrease() && getCurrentSpeed() + speedIncrease <= getMaxForwardSpeed(); }

    /**
     *
     * @param speedDecrease
     * @return if the speed decrease is in the acceptable range specified in the constructor.
     */
    boolean isSpeedDecreaseInRange(double speedDecrease){ return speedDecrease <= getMaxSpeedDecrease() && getCurrentSpeed() - speedDecrease >= -getMaxBackwardsSpeed(); }
    public double getCurrentSpeed() { return currentSpeed; }
    double getMaxForwardSpeed(){ return this.maxForwardSpeed; }
    double getMaxBackwardsSpeed(){ return this.maxBackwardsSpeed; }

    /**
     * Sets the currentspeed to amount, also sets the hasSpeed state to true if speed is other than 0.
     * @param currentSpeed
     */
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
        getStates().setCurrentlyHasSpeed(getCurrentSpeed() != 0);
    }

    /**
     * Getters and setters below.
     */
    private double getMaxSpeedDecrease() { return maxSpeedDecrease; }
    private double getMaxSpeedIncrease() { return maxSpeedIncrease; }
    public SpeedChangeStratFactory getSpeedChangeStratFactory(){ return this.speedChangeStratFactory; }

}

