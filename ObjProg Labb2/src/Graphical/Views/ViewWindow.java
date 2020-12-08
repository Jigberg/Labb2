package Graphical.Views;

public class ViewWindow {
    private static final int X = 800;
    private static final int Y = 800;

    FrameButtons viewButtons = new ViewButtons("CarSim 2.0");
    FrameDrawPanel viewDrawPanel = new ViewDrawPanel(X, Y-240); // might generify with f.ex. frameButtons.height

    public void paint(){ getFrameDrawPanel().repaint();}

    private FrameDrawPanel getFrameDrawPanel(){ return this.viewDrawPanel; }
    private FrameButtons getFrameButtons(){ return this.viewButtons; }
}
