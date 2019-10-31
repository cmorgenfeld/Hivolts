package game;

import java.awt.Color;
import java.awt.Graphics;

import java.awt.image.BufferedImage;
import java.io.*;

import javax.swing.JComponent;

import javax.imageio.*;

public class MainDraw extends JComponent {

    public int x = 50;
    public int y = 50;
    public You you;
    private Mho thisMho;
    
    final private Color background =  new Color(238, 238, 238, 255);

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
