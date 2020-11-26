package MovementAbilities;

public class Positionables{
    private double x; // The X position
    private double y; // The Y position
    private Direction direction;

    public Positionables(double x, double y, Direction direction){
        this.x = x;
        this.y = y;
        this.direction = direction;
    }
    public double getx() { return x; }
    public double gety() { return y; }
    public void setx(double x) { this.x = x; }
    public void sety(double y) { this.y = y; }
    public Direction getDirection() {return direction; }
    public void setDirection(Direction direction){ this.direction = direction; }
}
