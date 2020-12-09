package Graphical.Views;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import Graphical.*;

public class MainFrame extends JFrame{
    List<IView> views;

    public MainFrame(List<IView> views) {
        this.views = views;
        initComponents("CarSim 2.0");
    }
        private void initComponents(String title) {

            this.setTitle(title);
            this.setPreferredSize(new Dimension(800,800));
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

            for(IView view : getViews()){
                this.add(view.getComponent());
            }

            // This actionListener is for the gas button only
            // TODO: Create more for each component as necessary


            // Make the frame pack all it's components by respecting the sizes if possible.
            this.pack();
            // Get the computer screen resolution
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            // Center the frame
            this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
            // Make the frame visible
            this.setVisible(true);
            // Make sure the frame exits when "x" is pressed
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }

        public List<IView> getViews(){ return this.views;}

}
