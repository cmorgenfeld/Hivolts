
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * corresponds the key events with movements
 * contains the main method which sets the window of the game
 * @author Given by Mr. Kuszmaul
 *         edited by Creighton
 *			documentation by Jeffrey
 */
public class MainFrame extends JFrame implements KeyListener{
    private MainDraw draw;
    private Rectangle fence;
    private You you;
    private Grid grid;

    /**
     * corresponds key events with movements
     */
    public void keyPressed(KeyEvent e) {
    	int key = e.getKeyCode();
    	if(key == KeyEvent.VK_Q) {
    		you.move(-1, 1);
    	} else if(key == KeyEvent.VK_W) {
    		you.move(0, 1);
    	} else if(key == KeyEvent.VK_E) {
    		you.move(1, 1);
    	} else if(key == KeyEvent.VK_A) {
    		you.move(-1, 0);
    	} else if(key == KeyEvent.VK_S) {
    		you.move(0, 0);;
    	} else if(key == KeyEvent.VK_D) {
    		you.move(1, 0);
    	} else if(key == KeyEvent.VK_Z) {
    		you.move(-1, -1);
    	} else if(key == KeyEvent.VK_X) {
    		you.move(0, -1);
    	} else if(key == KeyEvent.VK_C) {
    		you.move(1, -1);
    	} else if(key == KeyEvent.VK_J) {
    		you.jump();
    	}
    	repaint();
    }

    /**
     * template
     */
    public void keyReleased(KeyEvent e) {}
    
    /**
     * template
     */
    public void keyTyped(KeyEvent e) {}
    
   
    /**
     * constructor for MainFrame
     */
    public MainFrame() {
    	int youX = 0;
    	int youY = 0;
    	
        draw = new MainDraw();
        grid = new Grid();
        grid.init();
        for(int i=0; i<11; i++) {
        	for (int k=0; k<11; k++) {
        		if(Grid.field[i][k] instanceof You) {
	        		youX = i;
	        		youY = k;
	        	}
        	}
        }
        you = new You(youX, youY);
        draw.you = you;
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    
    /**
     * main method which is run
     * sets the window where the game will take place
     * @param args
     */
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setTitle("Hivolts Game");
                frame.setResizable(false);
                frame.setSize(600, 623);
                frame.setMinimumSize(new Dimension(600, 623));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(frame.draw);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
