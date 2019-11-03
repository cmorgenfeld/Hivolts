import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

/**
 * this Fence class is a GamePiece that can draw itself (a png image of an electric fence)
 * @author Connie Jiang
 * 			documentation by Jeffrey
 *
 */
public class Fence extends GamePiece{
	private static BufferedImage sprite;
	
	/**
	 * constructor for Fence
	 * @param x initial x coordinate
	 * @param y initial y coordinate
	 */
	public Fence(int x, int y) {
		super(x, y);
	}
	
	/**
	 * draws a fence
	 * @param xcoord x coordinate of the image
	 * @param ycoord y coordinate of the image
	 * @param g the Graphics variable
	 */
	public static void drawFence(int xcoord, int ycoord, Graphics g) {
		try {
	    	sprite = ImageIO.read(new File("src/fence.png"));
	    }
	    catch (IOException e) {
	    	System.out.println("Exception caught");
	    }
		g.drawImage(sprite, xcoord, ycoord, 50, 50, null);
	}
}
