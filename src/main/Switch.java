package main;

import gui.SwitchApplet;
import static gui.SwitchApplet.*;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Switch {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Switch");
        
        SwitchApplet applet = new SwitchApplet(frame);
        
        frame.add(applet, BorderLayout.CENTER);
        
        //make close button work
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        //no resizing... for now ;)
        frame.setResizable(false);
        
        //processing initialization
        applet.init();
        
        frame.setVisible(true);
        
        frame.setSize(WIDTH, HEIGHT);
    }
}
