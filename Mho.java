
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

/**
 * class for Mho, includes the mho's movements which corresponds with the location of You
 * @author mostly Creighton (did all the fancy move methods)
 *         with a tiny bit of Connie (did the drawMho method and the constructor)
 *         debugged by Sergey (with the help of Mr. Kuszmaul's presence)
 *         documentation by Jeffrey
 *
 */
public class Mho extends GamePiece{
	private static BufferedImage sprite;
	private int number;
	
	/**
	 * constructor for Mho
	 * @param x initial x coordinate
	 * @param y initial y coordinate
	 * @param number which Mho it is
	 */
	public Mho(int x, int y, int number) {
		super(x, y);
		this.number = number;
	}
	
	/**
	 * draws Mho
	 * @param xcoord x location of Mho on the display
	 * @param ycoord y location of Mho on the display
	 * @param g graphics variable
	 */
	public static void drawMho(int xcoord, int ycoord, Graphics g) {
		try {
	    	sprite = ImageIO.read(new File("src/Mho.png"));
	    }
	    catch (IOException e) {
	    	System.out.println("Exception caught");
	    }
		g.drawImage(sprite, xcoord, ycoord, 50, 50, null);
		
	}
	
	/**
	 * moves the Mho according to the location of You on the field
	 */
	public void move(int x, int y) {
		Grid.field[x][y] = null;
		int[] youXY = wheresYou();
		int diffX = Math.abs(x - youXY[0]);
		int diffY = Math.abs(y - youXY[1]);
		if(diffX > diffY) {
			if(youXY[0] > x) {
				this.setX(x + 1);
			} else {
				this.setX(x - 1);
			}
		} else if (diffY > diffX) {
			if(youXY[1] > y) {
				this.setY(y + 1);
			} else {
				this.setY(y - 1);
			}
		} else {
			if(youXY[0] > x) {
				this.setX(x + 1);
			} else {
				this.setX(x - 1);
			} if(youXY[1] > y) {
				this.setY(y + 1);
			} else {
				this.setY(y - 1);
			}
		}
		Grid.field[this.getX()][this.getY()] = new Mho(this.getX(), this.getY(), this.number);
		isDead();
	}
	
	/**
	 * finds You in the field
	 * @return the location of You
	 */
	public int[] wheresYou() {
		int[] retval = new int[2];
		for(int i=0; i<11; i++) {
			for(int j=0; j<11; j++) {
				if(Grid.field[i][j] instanceof You) {
					retval[0] = i;
					retval[1] =j;
					break;
				}
			}
		}
		return retval;
	}
	
	/**
	 * if the mho is dead, this method sets the dead value to true
	 */
	public void isDead() {
		if(Grid.field[this.getX()][this.getY()] instanceof Fence) {
			setDead(true);
		}
	}
	
	/**
	 * getter for the number of the Mho
	 * @return number
	 */
	public int getNumber() {
		  return this.number;
	}
}
