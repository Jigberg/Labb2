package Graphical;

import java.awt.*;
import java.awt.List;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Base_Classes.*;
import Graphical.*;
import Base_Classes.*;

import java.sql.Array;
import java.util.*;

// This panel represent the animated part of the view with the car images.

public class FrameDrawPanel extends JPanel{

    // Just a single image, TODO: Generalize

    ArrayList<Vehicle> vehicleList;

    void setVehicleList(ArrayList<Vehicle> vehicleList) { this.vehicleList = vehicleList; }
    ArrayList<Vehicle> getVehicleList(){ return vehicleList; }

    // Initializes the panel and reads the images
    public FrameDrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.green);
        /*// Print an error message in case file is not found with a try/catch block
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
        }*/

    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // g.drawImage(volvoImage, vehiclePoint.x, vehiclePoint.y, null); // see javadoc for more info on the parameters
        for (Vehicle vehicle : vehicleList) {
            g.drawImage(vehicle.getImage(), (int) vehicle.getMovable().getx(), (int) vehicle.getMovable().gety(), null);
        }
    }
}
