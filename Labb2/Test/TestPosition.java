import Base_Classes.*;
import org.junit.*;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPosition {

    @Test
    public void workshopPosition(){
        Vehicle_Workshop workshop = new Vehicle_Workshop();
        assertEquals(workshop.getPositionable().getx(), 0, 0.001);
    }

}
