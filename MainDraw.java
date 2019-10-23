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
    private static BufferedImage fence;
    private static BufferedImage mho;
    
    final private Color background =  new Color(238, 238, 238, 255);

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	fence = ImageIO.read(new File("src/game/fence.png"));
        	mho = ImageIO.read(new File("src/game/Mho.png"));
        } catch (IOException e) {
        	System.out.println("Exception caught");
        }
        for(int i=0; i<600; i+= 50) {
        	g.drawImage(fence, i, 0, 50, 50, background, null);
        	g.drawImage(fence, i, 550, 50, 50, background, null);
        	g.drawImage(fence, 0, i, 50, 50, background, null);
        	g.drawImage(fence, 550, i, 50, 50, background, null);
        }
        g.drawImage(mho, 100, 100, 50, 50, background, null);
        drawGrid(g);
    }

    public void drawGrid (Graphics g) {
    	for(int i=50; i<600; i+= 50) {
    		g.drawLine(i, 0, i, 600);
    		g.drawLine(0, i, 600, i);
    	}
    }
}
