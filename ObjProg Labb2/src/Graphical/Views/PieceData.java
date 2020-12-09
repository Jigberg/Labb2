package Graphical.Views;

import Graphical.Wrapper;

import javax.swing.*;
import java.awt.*;

public class PieceData extends JPanel implements IView{
    private java.util.List<Wrapper> wrappers;
    // Initializes the panel and reads the images
    public PieceData(java.util.List<Wrapper> wrappers) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(800, 20));
        this.setBackground(Color.WHITE);
        this.wrappers = wrappers;
    }

    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int offset = 0;
        for (Wrapper wrapper : getWrappers()) {
            g.drawString(wrapper.getVehicle().getClass().getSimpleName() + " : " + Math.round(wrapper.getVehicle().getMovable().getCurrentSpeed()), 5 + offset, 15);
            offset += 100;
        }
    }

    java.util.List<Wrapper> getWrappers(){ return this.wrappers; }

    public Component getComponent(){ return this; }
}
