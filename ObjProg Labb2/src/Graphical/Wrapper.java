package Graphical;

import Base_Classes.Vehicle;
import Ramp.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Wrapper {
    private BufferedImage image;
    private final Ramp ramp;
    private final Vehicle vehicle;
    private final boolean hasTurbo;

    public Wrapper(Vehicle vehicle, String imagePath, Ramp ramp, boolean hasTurbo) {
        this.ramp = ramp;
        this.vehicle = vehicle;
        this.hasTurbo = hasTurbo;

        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public Ramp getRamp(){ return this.ramp; }
    public Vehicle getVehicle (){ return this.vehicle; }
    public double getX(){ return getVehicle().getMovable().getx(); }
    public double getY() { return getVehicle().getMovable().gety(); }
    public BufferedImage getImage(){ return image; }
    void setImage(BufferedImage image){ this.image = image; }
    public boolean hasTurbo(){ return this.hasTurbo; }
}
