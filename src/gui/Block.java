package gui;

//used for BLOCK_WIDTH, BLOCK_HEIGHT, etc
import static gui.SwitchApplet.*;

public class Block {
    
    //zero-based "type" represents what kind of block it is
    private int type;
    private static final int MAX_TYPES = 4;
    
    //color as defined by Processing
    private int color;
    
    //PApplet to draw on
    SwitchApplet applet;
    
    //random block
    public Block(SwitchApplet applet) {
        this.applet = applet;
        type = (int) (Math.random() * MAX_TYPES);
        switch (type) {
        case 0:
            color = applet.color(255, 0, 0);
            break;
        case 1:
            color = applet.color(0, 255, 0);
            break;
        case 2:
            color = applet.color(0, 0, 255);
            break;
        case 3:
            color = applet.color(128, 128, 0);
            break;
        default:
            color = applet.color(0);
            break;
        }
    }
    
    //Draws the block at the specified location (top-left corner)
    public void draw(int x, int y) {
        applet.fill(color);
        applet.ellipse(x, y, BLOCK_WIDTH, BLOCK_HEIGHT);
    }
    
    public int getType() {
        return type;
    }
}
