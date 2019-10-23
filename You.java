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

public class You extends GamePiece{
	private static BufferedImage sprite;
	
	public You(int x, int y) {
		super(x, y);
	}
	
	public void drawYou(int xcoord, int ycoord, Graphics g) {
		try {
	    	sprite = ImageIO.read(new File("src/You.png"));
	    }
	    catch (IOException e) {
	    	System.out.println("Exception caught");
	    }
		g.drawImage(sprite, xcoord, ycoord, 50, 50, null);
	}
	
	/*
	 * 
	public boolean move(int x, int y, boolean jump) {
	}
	*/
}
