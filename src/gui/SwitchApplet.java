package gui;

import javax.swing.JFrame;

import processing.core.*;

public class SwitchApplet extends PApplet {
    
    //width and height of entire frame
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    //width and height of the block display
    public static int GAME_WIDTH = 600;
    public static int GAME_HEIGHT = 600;
    //total number of blocks
    public static int NUM_BLOCKS_WIDTH = 10;
    public static int NUM_BLOCKS_HEIGHT = 10;
    //width and height of individual blocks
    public static int BLOCK_WIDTH = GAME_WIDTH / NUM_BLOCKS_WIDTH;
    public static int BLOCK_HEIGHT = GAME_HEIGHT / NUM_BLOCKS_HEIGHT;
    
    private Block[][] blocks;
    
    private Selector selector;
    
    public SwitchApplet(JFrame frame) {
        super.frame = frame;
        
        //initialize and fill block array with new random blocks
        blocks = new Block[NUM_BLOCKS_WIDTH][NUM_BLOCKS_HEIGHT];
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                blocks[i][j] = new Block(this);
            }
        }
        
        selector = new Selector(this);
        selector.setSelection(3, 3);
        
    }
    
    public void setup() {
        size(WIDTH, HEIGHT);
        
        ellipseMode(CORNER);
        
        //change some frame settings now that the embedded processing applet is in the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    public void draw() {
        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[0].length; j++) {
                blocks[i][j].draw(i * BLOCK_WIDTH, j * BLOCK_HEIGHT);
            }
        }
        
        selector.draw();
    }
    
}
