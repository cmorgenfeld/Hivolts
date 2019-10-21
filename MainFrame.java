import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class MainFrame extends JFrame implements KeyListener{
    private MainDraw draw;
    private Rectangle fence;
    private You you;

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
    		you.move(0, 0);
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
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    
   

    public MainFrame() {
        draw = new MainDraw();
        you = new You();
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

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
