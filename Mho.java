/**
 * 
 * @author Connie Jiang
 *
 */

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class Mho extends GamePiece{
	private static BufferedImage sprite;
	private int number;
	
	public Mho(int x, int y, int number) {
		super(x, y);
		this.number = number;
	}
	
	public void drawYou(int xcoord, int ycoord, Graphics g) {
		try {
	    	sprite = ImageIO.read(new File("src/Mho.png"));
	    }
	    catch (IOException e) {
	    	System.out.println("Exception caught");
	    }
		g.drawImage(sprite, xcoord, ycoord, 50, 50, null);
	}
	
	public void move(int x, int y) {
		super.move(x, y);
		isDead();
	}
	
	public void isDead() {
		if(Grid.field[this.getX()][this.getY()] instanceof Fence) {
			setDead(true);
		}
	}
}
