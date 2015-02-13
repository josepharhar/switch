package gui;

import java.util.List;

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
    
//    private Block[][] blocks;
    private Grid<Block> blocks;
    
    private Selector selector;
    
    public SwitchApplet(JFrame frame) {
        super.frame = frame;
        
        //initialize and fill block array with new random blocks
//        blocks = new Block[NUM_BLOCKS_WIDTH][NUM_BLOCKS_HEIGHT];
        blocks = new Grid<Block>(NUM_BLOCKS_WIDTH, NUM_BLOCKS_HEIGHT);
        for (int i = 0; i < blocks.getWidth(); i++) {
            for (int j = 0; j < blocks.getHeight(); j++) {
                blocks.put(i, j, new Block(this, blocks));
            }
        }
        
    }
    
    public void setup() {
        size(WIDTH, HEIGHT);
        
        ellipseMode(CORNER);
        
        //change some frame settings now that the embedded processing applet is in the frame
        frame.pack();
        frame.setLocationRelativeTo(null);
    }
    
    public void draw() {
        background(128);
        
        for (int i = 0; i < blocks.getWidth(); i++) {
            for (int j = 0; j < blocks.getHeight(); j++) {
                blocks.get(i, j).draw(i * BLOCK_WIDTH, j * BLOCK_HEIGHT);
            }
        }

        if (selector != null) {
            selector.draw();
        }
    }
    
    public void mouseClicked() {
        if (selector == null) {
            System.out.println("selector is null, reassigning");
            //determine x and y of cursor
            int x = (int) (mouseX / BLOCK_WIDTH);
            int y = (int) (mouseY / BLOCK_HEIGHT);
            selector = new Selector(this, x, y);
        } else {
            // a block has already been selected, this will try to swap

            int clickedx = (int)(mouseX / BLOCK_WIDTH);
            int clickedy = (int)(mouseY / BLOCK_HEIGHT);
            
            if (clickedx == selector.getx() && clickedy == selector.gety()) {
                //same spot, deselect
                selector = null;
            } else if (clickedx == selector.getx() + 1 && clickedy == selector.gety()) {
                //right adjacent
                blocks.swap(clickedx, clickedy, selector.getx(), selector.gety());
                selector = null;
            } else if (clickedx == selector.getx() - 1 && clickedy == selector.gety()) {
                //left adjacent
                blocks.swap(clickedx, clickedy, selector.getx(), selector.gety());
                selector = null;
            } else if (clickedx == selector.getx() && clickedy == selector.gety() + 1) {
                //down adjacent
                blocks.swap(clickedx, clickedy, selector.getx(), selector.gety());
                selector = null;
            } else if (clickedx == selector.getx() && clickedy == selector.gety() - 1) {
                //up adjacent
                blocks.swap(clickedx, clickedy, selector.getx(), selector.gety());
                selector = null;
            } else {
                //change selector to where it got clicked
                System.out.println("moving selector to new spot");
                selector = new Selector(this, clickedx, clickedy);
            }
        }
    }
    
    //tell if there is three blocks in a row and act on it if there is
    private void update() {
        
        for (int i = 0; i < blocks.getWidth(); i++) {
            for (int j = 0; j < blocks.getHeight(); j++) {
                Block currentBlock = blocks.get(i, j);
                List<Block> adjacents = blocks.getAdjacent(i, j);
                for (Block b : adjacents) {
                    if (currentBlock.sameType(b)) {
                        //adjacent block is of the same type, check the next one in the same direction
                        
                    }
                }
            }
        }
        
    }
    
}
