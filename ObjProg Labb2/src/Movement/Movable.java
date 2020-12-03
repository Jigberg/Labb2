package Movement;

import SpeedChange.SpeedChangeStrat;

public class Movable extends Speed {

    public Movable(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, Double power, double maxForwardSpeed, double maxBackwardsSpeed, double maxSpeedIncrease, double maxSpeedDecrease, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue) {
        super(x, y, direction, isMovable, isTransportable, power, maxForwardSpeed, maxBackwardsSpeed, maxSpeedIncrease, maxSpeedDecrease, speedChangeStrat, speedChangeStratValue);
    }
    public Movable(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, double power, SpeedChangeStrat speedChangeStrat, double speedChangeStratValue) {
        super(x, y, direction, isMovable, isTransportable, power, speedChangeStrat, speedChangeStratValue);
    }

    public void move(){
        if(getStates().getCanMove()) {
            switch (getDirection()) {
                case NORTH -> sety(gety() + getCurrentSpeed());
                case EAST -> setx(getx() + getCurrentSpeed());
                case SOUTH -> sety(gety() - getCurrentSpeed());
                case WEST -> setx(getx() - getCurrentSpeed());
            }
        }
    }
    public void turnRight() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.EAST);
            case EAST -> setDirection(Direction.SOUTH);
            case SOUTH -> setDirection(Direction.WEST);
            case WEST -> setDirection(Direction.NORTH);
        }
    }
    public void turnLeft() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.WEST);
            case EAST -> setDirection(Direction.NORTH);
            case SOUTH -> setDirection(Direction.EAST);
            case WEST -> setDirection(Direction.SOUTH);
        }
    }
}

