
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
        
        int[] mhoList = new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		for(int i=0; i<12; i++) {
			for(int j=0; j<12; j++) {
				if(Grid.field[i][j] instanceof Mho) {
					thisMho = (Mho) Grid.field[i][j];
					if (thisMho.getDead()) {
						Grid.field[i][j] = null;
					} else if(mhoList[thisMho.getNumber()] == 1) {
	        			thisMho.move(i, j);
		        		mhoList[thisMho.getNumber()] = 0;
		        		Mho.drawMho(i*50, j*50, g);
	        		}
	        	} else if(Grid.field[i][j] instanceof Fence) {
	        		Fence.drawFence(i*50, j*50, g);
	        	}
			} 	
        }  
        drawGrid(g);
        you.drawYou(g);
        if(you.getDead()) {
        	You.deadScreen(g);
        }
    }

    public void drawGrid (Graphics g) {
    	for(int i=50; i<600; i+= 50) {
    		g.drawLine(i, 0, i, 600);
    		g.drawLine(0, i, 600, i);
    	}
    }
}
