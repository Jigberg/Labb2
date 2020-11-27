package Movement;

public class Positionable {
    private double x; // The X position
    private double y; // The Y position
    private Direction direction;
    private final States states;

    public Positionable(double x, double y, Direction direction, boolean isMovable, boolean isTransportable, boolean isRotatable){
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.states = new States(isMovable, isTransportable, isRotatable);
    }
    States getStates(){ return this.states; }
    double getx() { return x; }
    double gety() { return y; }
    void setx(double x) { this.x = x; }
    void sety(double y) { this.y = y; }
    Direction getDirection() {return direction; }
    public void setDirection(Direction direction){ this.direction = direction; }
    boolean geIsMovable() { return getStates().getIsMovable(); }
    boolean getIsTransportable() { return getStates().getIsTransportable(); }
    void setIsMovable(boolean isMovable) { getStates().setIsMovable(isMovable); }
    void setIsTransportable(boolean isTransportable) { getStates().setIsTransportable(isTransportable);}
}
