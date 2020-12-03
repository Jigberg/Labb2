package Movement;

public class States {
    boolean canMove;
    boolean isTransportable;
    boolean currentlyHasSpeed = false;

    public States(boolean canMove, boolean isTransportable){
        this.canMove = canMove;
        this.isTransportable = isTransportable;
    }

    public boolean getCanMove() { return canMove; }
    public boolean getIsTransportable() { return isTransportable; }
    public void setCanMove(boolean movable) { canMove = movable; }
    public void setIsTransportable(boolean transportable) { isTransportable = transportable; }
    public boolean getCurrentlyHasSpeed() { return this.currentlyHasSpeed; }
    public void setCurrentlyHasSpeed(boolean currentlyHasSpeed) {this.currentlyHasSpeed = currentlyHasSpeed; }

}
