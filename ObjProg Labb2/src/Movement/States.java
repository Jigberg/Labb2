package Movement;

/**
 * @author Lukas, Emil, Martin.
 * A class for states of an object
 */
public class States {
    boolean canMove;
    boolean isTransportable;
    boolean currentlyHasSpeed = false;


    /**
     * Creates the states which all objects must have.
     * @param canMove Can the object move right now.
     * @param isTransportable Can the object be transported right now.
     */
    public States(boolean canMove, boolean isTransportable){
        this.canMove = canMove;
        this.isTransportable = isTransportable;
    }

    /**
     * Getters and setters.
     */
    public boolean getCanMove() { return canMove; }
    public boolean getIsTransportable() { return isTransportable; }
    public void setCanMove(boolean movable) { canMove = movable; }
    public void setIsTransportable(boolean transportable) { isTransportable = transportable; }
    public boolean getCurrentlyHasSpeed() { return this.currentlyHasSpeed; }
    public void setCurrentlyHasSpeed(boolean currentlyHasSpeed) {this.currentlyHasSpeed = currentlyHasSpeed; }

}
