package Movement;

public class Movable extends Positionable {
    private Speed speed;
    public Movable(double x, double y, Direction direction, Speed speed, boolean isMovable, boolean isTransportable, boolean isRotatable) {
        super(x, y, direction, isMovable, isTransportable, isRotatable);
        this.speed = speed;
    }

    public void move(){
        if(getStates().getIsMovable()) {
            switch (getDirection()) {
                case NORTH -> sety(gety() + getSpeed().getCurrentSpeed());
                case EAST -> setx(getx() + getSpeed().getCurrentSpeed());
                case SOUTH -> sety(gety() - getSpeed().getCurrentSpeed());
                case WEST -> setx(getx() - getSpeed().getCurrentSpeed());
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
    Speed getSpeed(){ return this.speed; }
}

