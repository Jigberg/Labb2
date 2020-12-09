package Movement;


import java.util.Map;

/**
 * @author Lukas, Emil, Martin.
 * A class for traversing positions
 */
public class Movable extends Positionable {
    private final Speed speed;

    public Movable(double x, double y, Direction direction, boolean canMove, double maxForwardSpeed, double maxBackwardsSpeed, double power, double maxAcceleration, double maxDeceleration){
        super(x, y, direction, canMove, true);
        this.speed = new Speed(maxForwardSpeed, maxBackwardsSpeed, power, maxAcceleration, maxDeceleration);
    }


    /**
     * Moves the object in the direction it's facing with the current speed it has.
     */
    public void move(){
    if(getStates().getCanMove()) {
            switch (getDirection()) {
                case NORTH -> sety(gety() + getSpeed().getCurrentSpeed());
                case EAST -> setx(getx() + getSpeed().getCurrentSpeed());
                case SOUTH -> sety(gety() - getSpeed().getCurrentSpeed());
                case WEST -> setx(getx() - getSpeed().getCurrentSpeed());
            }
        }
    }
    /**
     * Changes the direction of the object from its current one, to the next one, clockwise.
     */
    public void turnRight() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.EAST);
            case EAST -> setDirection(Direction.SOUTH);
            case SOUTH -> setDirection(Direction.WEST);
            case WEST -> setDirection(Direction.NORTH);
        }
    }
    /**
     * Changes the direction of the object from its current one, to the next one, counter clockwise.
     */
    public void turnLeft() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.WEST);
            case EAST -> setDirection(Direction.NORTH);
            case SOUTH -> setDirection(Direction.EAST);
            case WEST -> setDirection(Direction.SOUTH);
        }
    }

    public void increaseSpeed(double time){ if(getStates().getCanMove()){getSpeed().increaseSpeed(time); }}
    public void decreaseSpeed(double time){ if(getStates().getCanMove()){getSpeed().decreaseSpeed(time); }}

    public void addFactor(Enum_AccelerationFactor enum_accelerationFactor, double value){ getSpeed().addFactor(enum_accelerationFactor, value); }
    public void addFactorComposite(Map<Enum_AccelerationFactor, Double> factorPairs){ getSpeed().addFactorComposite(factorPairs); }
    public void removeFactor(int index){ getSpeed().removeFactor(index); }
    public void removeFactor(Enum_AccelerationFactor enum_accelerationFactor){ getSpeed().removeFactor(enum_accelerationFactor); }

    private Speed getSpeed() { return this.speed; }
    public double getCurrentSpeed(){ return getSpeed().getCurrentSpeed(); }
    public void setCurrentSpeed(double time){ getSpeed().setCurrentSpeed(time); }
}

