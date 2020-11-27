package Movement;

public class States {
    boolean isMovable;
    boolean isTransportable;
    boolean isRotatable;
    public States(boolean isMovable, boolean isTransportable, boolean isRotatable){
        this.isMovable = isMovable;
        this.isTransportable = isTransportable;
        this.isRotatable = isRotatable;
    }

    public boolean getIsMovable() { return isMovable; }
    public boolean getIsTransportable() { return isTransportable; }
    public void setIsMovable(boolean movable) { isMovable = movable; }
    public void setIsTransportable(boolean transportable) { isTransportable = transportable; }
}
