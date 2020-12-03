package Graphical;

public class Frame {
    private static final int X = 800;
    private static final int Y = 800;

    FrameButtons frameButtons = new FrameButtons("CarSim 2.0");
    FrameDrawPanel frameDrawPanel = new FrameDrawPanel(X, Y-240); // might generify with f.ex. frameButtons.height

    public void paint(){ getFrameDrawPanel().repaint();}

    private FrameDrawPanel getFrameDrawPanel(){ return this.frameDrawPanel; }
    private FrameButtons getFrameButtons(){ return this.frameButtons; }
}
