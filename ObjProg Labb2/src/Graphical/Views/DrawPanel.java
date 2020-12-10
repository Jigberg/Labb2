package Graphical.Views;

import java.util.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
import Base_Classes.*;
import Graphical.*;
import Base_Classes.*;
import java.util.List;
import java.sql.Array;


// This panel represent the animated part of the view with the car images.

public class DrawPanel extends JPanel implements IView{
    private final java.util.List<Wrapper> wrappers;

    // Initializes the panel and reads the images
    public DrawPanel(java.util.List<Wrapper> wrappers) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(800, 560));
        this.setBackground(Color.green);
        this.wrappers = wrappers;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Wrapper wrapper : getWrappers()) {
            g.drawImage(wrapper.getImage(), (int) wrapper.getX(), (int) wrapper.getY(), null);
        }
    }

    public Component getComponent(){ return this; }

    java.util.List<Wrapper> getWrappers(){ return this.wrappers; }
}
