package Movement;

public class Positionable {
    private double x; // The X position
    private double y; // The Y position
    private Direction direction;
    private final States states;

    public Positionable(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, boolean hasSpeed){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.states = new States(isMovable, isTransportable, hasSpeed);
    }
    public States getStates(){ return this.states; }
    public double getx() { return x; }
    public double gety() { return y; }
    void setx(double x) { this.x = x; }
    void sety(double y) { this.y = y; }
    public Direction getDirection() {return direction; }
    public void setDirection(Direction direction){ this.direction = direction; }
    boolean geIsMovable() { return getStates().getIsMovable(); }
    boolean getIsTransportable() { return getStates().getIsTransportable(); }
    void setIsMovable(boolean isMovable) { getStates().setIsMovable(isMovable); }
    void setIsTransportable(boolean isTransportable) { getStates().setIsTransportable(isTransportable);}
}
