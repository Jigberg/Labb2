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
    double getx() { return x; }
    double gety() { return y; }
    void setx(double x) { this.x = x; }
    void sety(double y) { this.y = y; }
    Direction getDirection() {return direction; }
    void setDirection(Direction direction){ this.direction = direction; }
    States getStates(){ return this.states; }
    boolean geIsMovable() { return getStates().getIsMovable(); }
    boolean getIsTransportable() { return getStates().getIsTransportable(); }
    void setIsMovable(boolean isMovable) { getStates().setMovable(isMovable); }
    void setIsTransportable(boolean isTransportable) { getStates().setTransportable(isTransportable);}
}
