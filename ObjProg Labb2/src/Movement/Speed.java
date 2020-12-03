package Movement;

import SpeedChange.*;

public abstract class Speed extends Positionable{
    private double currentSpeed;
    private double power;
    private CalculateSpeedChangeStrat strat;
    private double maxForwardSpeed = 50;
    private double maxBackwardsSpeed = 50;
    private double maxSpeedIncrease = 50;
    private double maxSpeedDecrease = 50;


    public Speed(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, double power, double maxForwardSpeed, double maxBackwardsSpeed, double maxSpeedIncrease, double maxSpeedDecrease){
        super(x, y, direction, isMovable, isTransportable);
        this.currentSpeed = 0;
        this.power = power;
        this.strat = new NoStrat();
        this.strat.setPower(power);
        this.maxForwardSpeed = maxForwardSpeed;
        this.maxBackwardsSpeed = maxBackwardsSpeed;
        this.maxSpeedIncrease = maxSpeedIncrease;
        this.maxSpeedDecrease = maxSpeedDecrease;
    }
    public Speed(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, double power) {
        super(x, y, direction, isMovable, isTransportable);
        this.currentSpeed = 0;
        this.power = power;
        setStrat(new NoStrat());
        getStrat().setPower(power);
    }

    public void increaseSpeed(double amount){
        double speedIncrease = getStrat().calculateSpeedChange(amount);
        if(isSpeedIncreaseInRange(speedIncrease)){
            setCurrentSpeed(getCurrentSpeed() + speedIncrease);
        }else{
            setCurrentSpeed(getMaxForwardSpeed());
        }

    }
    public void decreaseSpeed(double amount){
        double speedDecrease = getStrat().calculateSpeedChange(amount);
        if(isSpeedDecreaseInRange(speedDecrease)){
            setCurrentSpeed(getCurrentSpeed() - speedDecrease);
        }else{
            setCurrentSpeed(-getMaxBackwardsSpeed());
        }
    }

    boolean isSpeedIncreaseInRange(double speedIncrease){ return speedIncrease <= getMaxSpeedIncrease() && getCurrentSpeed() + speedIncrease <= getMaxForwardSpeed(); }
    boolean isSpeedDecreaseInRange(double speedDecrease){ return speedDecrease <= getMaxSpeedDecrease() && getCurrentSpeed() - speedDecrease >= -getMaxBackwardsSpeed(); }
    public double getPower(){ return this.power; }
    public double getCurrentSpeed() { return currentSpeed; }
    double getMaxForwardSpeed(){ return this.maxForwardSpeed; }
    double getMaxBackwardsSpeed(){ return this.maxBackwardsSpeed; }
    public CalculateSpeedChangeStrat getStrat(){ return this.strat; }
    public void setStrat(CalculateSpeedChangeStrat strat){
        this.strat = strat;
        getStrat().setPower(getPower());
    }
    public CalculateSpeedChangeStrat stratFactory(SpeedChangeStrat strat, double modifierValue) {
        return switch (strat) {
            case NO_STRAT -> new NoStrat();
            case BASIC_TURBO_STRAT -> new BasicTurboStrat(modifierValue);
            case BASIC_TRIMFACTOR_STRAT -> new BasicTrimFactorStrat(modifierValue);
        };
    }
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
        getStates().setCurrentlyHasSpeed(getCurrentSpeed() != 0);
    }
    double getMaxSpeedDecrease() { return maxSpeedDecrease; }
    double getMaxSpeedIncrease() { return maxSpeedIncrease; }


}
