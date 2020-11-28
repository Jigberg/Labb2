package Movement;

public class States {
    boolean isMovable;
    boolean isTransportable;
    boolean hasSpeed;

    public States(boolean isMovable, boolean isTransportable, boolean hasSpeed){
        this.isMovable = isMovable;
        this.isTransportable = isTransportable;
        this.hasSpeed = hasSpeed;
    }

    public boolean getIsMovable() { return isMovable; }
    public boolean getIsTransportable() { return isTransportable; }
    public void setIsMovable(boolean movable) { isMovable = movable; }
    public void setIsTransportable(boolean transportable) { isTransportable = transportable; }
    public boolean getHasSpeed() { return this.hasSpeed; }
}
