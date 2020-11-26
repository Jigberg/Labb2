package Uncategorized;

public class Movables {
    private boolean isMovable; // Used to know if it is in a movable state
    private Positionables positionables;

    public Movables(double x, double y, Direction direction, double currentSpeed, boolean isMovable, double maxSpeed) {
        this.positionables = new Positionables(x, y, direction);
        this.isMovable = isMovable;
    }

    /**
     * Moves the car depending on direction.
     */
    public void move() {
        if(getIsMovable()) {
            switch (getDirection()) {
                case NORTH -> sety(gety() + getCurrentSpeed());
                case EAST -> setx(getx() + getCurrentSpeed());
                case SOUTH -> sety(gety() - getCurrentSpeed());
                case WEST -> setx(getx() - getCurrentSpeed());
            }
        }
    }

    /**
     * Turns the car left.
     */
    public void turnLeft() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.WEST);
            case EAST -> setDirection(Direction.NORTH);
            case SOUTH -> setDirection(Direction.EAST);
            case WEST -> setDirection(Direction.SOUTH);
        }
    }
    /**
     * Turns the car right.
     */
    public void turnRight() {
        switch (getDirection()) {
            case NORTH -> setDirection(Direction.EAST);
            case EAST -> setDirection(Direction.SOUTH);
            case SOUTH -> setDirection(Direction.WEST);
            case WEST -> setDirection(Direction.NORTH);
        }
    }
    public void setDirection(Direction direction){ getPositionables().setDirection(direction); }
    public Direction getDirection(){ return getPositionables().getDirection(); }
    public Positionables getPositionables(){ return this.positionables; }
    public boolean getIsMovable() { return isMovable; }
    public void setIsMovable(boolean isMovable) { this.isMovable = isMovable; }
}

