package Movement;

/**
 * @author Lukas, Emil, Martin.
 * A class for positioning in x/y and direction
 */
public class Positionable {
    private double x; // The X position
    private double y; // The Y position
    private Direction direction;
    private final States states;

    /**
     * Constructor that also sets direction and isMovable/isTransportable states.
     * @param x position in the x-axis.
     * @param y position in the y-axis.
     * @param direction facing.
     * @param canMove sets if object can move on its own.
     * @param isTransportable  sets if is transportable.
     */
    public Positionable(double x, double y, Direction direction, boolean canMove, boolean isTransportable){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.states = new States(canMove, isTransportable);
    }

    /**
     * Getters and setters below.
     */
    public States getStates(){ return this.states; }
    public double getx() { return x; }
    public double gety() { return y; }
    protected void setx(double x) { this.x = x; }
    protected void sety(double y) { this.y = y; }
    public Direction getDirection() {return direction; }
    protected void setDirection(Direction direction){ this.direction = direction; }
}
