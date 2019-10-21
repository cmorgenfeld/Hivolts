/**
 * @author Connie Jiang
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;


public class Fence extends GamePiece{
	private static BufferedImage sprite;
	
	public Fence(int x, int y) {
		super(x, y);
	}
	
	public void drawFence(int xcoord, int ycoord, Graphics g) {
		try {
	    	sprite = ImageIO.read(new File("src/fence.png"));
	    }
	    catch (IOException e) {
	    	System.out.println("Exception caught");
	    }
		g.drawImage(sprite, xcoord, ycoord, 50, 50, null);
	}
}
