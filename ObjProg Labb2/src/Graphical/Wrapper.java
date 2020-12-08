package Graphical;

import Base_Classes.Vehicle;
import Ramp.*;
import SpeedChange.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Wrapper {
    private BufferedImage image;
    private final Ramp ramp;
    private final Turbo0 turbo0;
    private final Vehicle vehicle;

    public Wrapper(Vehicle vehicle, String imagePath, Ramp ramp, Turbo0 turbo0) {
        this.ramp = ramp;
        this.vehicle = vehicle;
        this.turbo0 = turbo0;

        try {
            this.image = ImageIO.read(getClass().getResourceAsStream(imagePath));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public Turbo0 getTurbo() {return this.turbo0; }
    public Ramp getRamp(){ return this.ramp; }
    public Vehicle getVehicle (){ return this.vehicle; }
    public double getX(){ return getVehicle().getMovable().getx(); }
    public double getY() { return getVehicle().getMovable().gety(); }
    public BufferedImage getImage(){ return image; }
    void setImage(BufferedImage image){ this.image = image; }
}
