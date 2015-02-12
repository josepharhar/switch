package gui;

import static gui.SwitchApplet.*;

public class Selector {
    private SwitchApplet applet;
    
    private int x;
    private int y;
    
    public Selector(SwitchApplet applet, int x, int y) {
        this.applet = applet;
        this.x = x;
        this.y = y;
    }
    
    public void draw() {
        applet.pushMatrix();
            applet.noFill();
            applet.stroke(0);
            applet.strokeWeight(10);
            applet.ellipse(x * BLOCK_WIDTH, y * BLOCK_HEIGHT, BLOCK_WIDTH, BLOCK_HEIGHT);
            applet.strokeWeight(1);
        applet.popMatrix();
    }
    
    public int getx() {
        return x;
    }
    
    public int gety() {
        return y;
    }
}
