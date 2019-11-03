
import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.swing.JComponent;

import javax.imageio.*;

/**
 * this is the class where the grid is drawn 
 * @author Given by Mr. Kuszmaul
 *         edited by Creighton
 *         edited by Connie
 *         documentation by Jeffrey
 *
 */

public class MainDraw extends JComponent {
    public You you;
    
    /**
     * paints the game
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for(int i=0; i<600; i+= 50) {
        	Fence.drawFence(i, 0, g);
        	Fence.drawFence(i,  550,  g);
        	Fence.drawFence(0, i, g);
        	Fence.drawFence(550, i, g);
        }

		for(int i=0; i<12; i++) {
			for(int k=0; k<12; k++) {
				if(Grid.field[i][k] instanceof Mho) {
	        		Mho.drawMho(i*50, k*50, g);
	        	} else if(Grid.field[i][k] instanceof Fence) {
	        		Fence.drawFence(i*50, k*50, g);
	        	}
			} 	
        }
        you.drawYou(g);
        drawGrid(g);
    }

    public void drawGrid (Graphics g) {
    	for(int i=50; i<600; i+= 50) {
    		g.drawLine(i, 0, i, 600);
    		g.drawLine(0, i, 600, i);
    	}
    }
}
