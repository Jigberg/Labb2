package Graphical;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Base_Classes.*;
import Graphical.*;

// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel{

    // Just a single image, TODO: Generalize
    BufferedImage volvoImage;
    // To keep track of a single cars position


    Point vehiclePoint = new Point();
    Vehicle volvo = new Volvo240();
    Vehicle saab = new Saab95();
    Vehicle scania = new Scania();


    // TODO: Make this genereal for all cars
    void moveit(int x, int y, Vehicle vehicle) {
        f(vehicle);
        vehicle.getMovable().setx(x);
        vehicle.getMovable().sety(y);
    }

    void f(Vehicle vehicle){
        if (vehicle instanceof Saab95){ this.saab = saab;}
        if (vehicle instanceof Volvo240) { this.volvo = volvo;
        }else{ this.scania = scania; }
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        // Print an error message in case file is not found with a try/catch block
        try {
            // You can remove the "pics" part if running outside of IntelliJ and
            // everything is in the same main folder.
            // volvoImage = ImageIO.read(new File("Volvo240.jpg"));

            // Rememember to rightclick src New -> Package -> name: pics -> MOVE *.jpg to pics.
            // if you are starting in IntelliJ.
            volvoImage = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/Volvo240.jpg"));
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // g.drawImage(volvoImage, vehiclePoint.x, vehiclePoint.y, null); // see javadoc for more info on the parameters
        g.drawImage(volvoImage, (int) volvo.getMovable().getx(), (int) volvo.getMovable().gety(), null);
        g.drawImage(volvoImage, (int) saab.getMovable().getx(), (int) saab.getMovable().gety(), null);
        g.drawImage(volvoImage, (int) scania.getMovable().getx(), (int) scania.getMovable().gety(), null);
    }


}
