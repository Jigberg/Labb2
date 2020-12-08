package Movement;

public class Speed {
    private double currentSpeed;
    private final double maxForwardSpeed;
    private final double maxBackwardsSpeed;
    private final Acceleration acceleration;

    public Speed(double maxForwardSpeed, double maxBackwardsSpeed, double power, double maxAcceleration, double maxDeceleration){
        this.maxForwardSpeed = maxForwardSpeed;
        this.maxBackwardsSpeed = maxBackwardsSpeed;
        this.acceleration = new Acceleration(power, maxAcceleration, maxDeceleration);
    }

    /**
     * Checks if the object is eligible for the speed increase.
     * Increases the speed of the object with a factor "speedFactor", calculated in a unique speedStrat.
     * Does not let the object go over its maximum speed.
     * @param time increasing speed for time time units.
     */
    public void increaseSpeed(double time){
        double speedIncrease = getAcceleration().calculateAcceleration()*time;
        if (isSpeedIncreaseInRange(speedIncrease)) {
                setCurrentSpeed(getCurrentSpeed() + speedIncrease);
        }else {
                setCurrentSpeed(getMaxForwardSpeed());
        }
    }

    /**
     * Checks if the object is eligible for the speed decrease.
     * Decreases the speed of the object with a factor "speedFactor", calculated in a unique speedStrat.
     * @param time decreasing speed for time time units.
     */
    public void decreaseSpeed(double time){
        double speedDecrease = getAcceleration().calculateAcceleration()*time;
        if (isSpeedDecreaseInRange(speedDecrease)) {
            setCurrentSpeed(getCurrentSpeed() - speedDecrease);
        }else {
            setCurrentSpeed(-getMaxBackwardsSpeed());
            }
        }

    public void addFactor(Enum_AccelerationFactor enum_accelerationFactor, double value){ getAcceleration().addFactor(enum_accelerationFactor, value);}
    public void removeFactor(int index){ getAcceleration().removeFactor(index); }
    public void removeFactor(Enum_AccelerationFactor enum_accelerationFactor){ getAcceleration().removeFactor(enum_accelerationFactor); }

    /**
     *
     * @param speedIncrease
     * @return if the speed increase is in the acceptable range specified in the constructor.
     */
    private boolean isSpeedIncreaseInRange(double speedIncrease){ return getCurrentSpeed() + speedIncrease <= getMaxForwardSpeed(); }
    /**
     *
     * @param speedDecrease
     * @return if the speed decrease is in the acceptable range specified in the constructor.
     */
    private boolean isSpeedDecreaseInRange(double speedDecrease){ return getCurrentSpeed() - speedDecrease >= -getMaxBackwardsSpeed(); }
    public void setCurrentSpeed(double currentSpeed){ this.currentSpeed = currentSpeed; }
    double getCurrentSpeed() { return this.currentSpeed; }
    public double getMaxForwardSpeed() { return this.maxForwardSpeed; }
    public double getMaxBackwardsSpeed() { return maxBackwardsSpeed; }
    public Acceleration getAcceleration() { return acceleration; }
}
