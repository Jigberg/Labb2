package Graphical.Views;

public class Window {
    private static final int X = 800;
    private static final int Y = 800;

    FrameButtons viewButtons = new Buttons("CarSim 2.0");
    FrameDrawPanel viewDrawPanel = new DrawPanel(X, Y-240); // might generify with f.ex. frameButtons.height

    public void paint(){ getFrameDrawPanel().repaint();}

    private FrameDrawPanel getFrameDrawPanel(){ return this.viewDrawPanel; }
    private FrameButtons getFrameButtons(){ return this.viewButtons; }
}
