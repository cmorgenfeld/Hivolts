
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;

import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

/**
 * You: can draw itself, can move and jump
 * @author Creighton, Connie, Sergey, and Jeffrey
 * 			documentation by Jeffrey
 *
 */
public class You extends GamePiece{
	private static BufferedImage sprite;
	
	/**
	 * constructor for You
	 * @param x initial x coordinate
	 * @param y initial y coordinate
	 */
	public You(int x, int y) {
		super(x, y);
	}
	
	/**
	 * draws itself, if it is dead, displays the Lost screen
	 * @param g Graphics variable
	 */
	public void drawYou(Graphics g) {
		try {
	    	sprite = ImageIO.read(new File("src/You.png"));
	    }
	    catch (IOException e) {
	    	System.out.println("Exception caught");
	    }
		g.drawImage(sprite, this.getX()*50, this.getY()*50, 50, 50, null);
		if(getDead()) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.BLACK);
			g.drawString("You Lost!", 250, 300);
		}
	}
	
	/**
	 * @override
	 */
	public void move(int x, int y) {
		Grid.field[this.getX()][this.getY()] = null;
		super.move(x, y);
		isDead();
		Grid.field[this.getX()][this.getY()] = new You(this.getX(), this.getY());
	}
	
	/**
	 * helper method
	 * @param i x coordinate
	 * @param j y coordinate
	 * @return true or false
	 */
	private boolean notafenceandlowprob(int i, int j) {
		return !(isFence(i, j)) && Math.random() <= 0.01;
	}
	
	/**
	 * jump method: you move to a random location on the grid, with the guarantee that you will
	 * not land on an electric fence
	 */
	public void jump() {
		boolean done = false;
		Grid.field[this.getX()][this.getY()] = null;
		while (!done) {
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					boolean notFenceandLowProb = notafenceandlowprob(i,j);
					if (p && !done && !(oldCoords(i, j))) {
						// do we always reach this point as expected?
						System.out.println(i + ", " + j);
						if(isMho(i, j)) {
							this.setDead(true);
							done = true;
						} else {
							Grid.field[i][j] = new You(i, j);
							this.setX(i);
							this.setY(j);
							done = true;
							break;
						}
		        }
		      }
		    }
		  }
	}
	
	/**
	 * checks if the location on the field is a fence
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return true if it is a fence, false otherwise
	 */
	public boolean isFence(int x, int y) {
		return(Grid.field[x][y] instanceof Fence);
	}
	
	/**
	 * checks if the location on the field is a Mho
	 * @param x x coordinate
	 * @param y y coordinate
	 * @return true if it is a Mho, false otherwise
	 */
	public boolean isMho(int x, int y) {
		return(Grid.field[x][y] instanceof Mho);
	}
	
	/**
	 * checks if the new coordinates are the same as the original
	 * @param x new x coordinate
	 * @param y new y coordinate
	 * @return true if the coordinates are the same, false otherwise
	 */
	public boolean oldCoords(int x, int y) {
		return x == this.getX() && y == this.getY();
	}
	
	/**
	 * sets dead to true if You are dead, false otherwise
	 */
	public void isDead() {
		if(Grid.field[this.getX()][this.getY()] instanceof Fence || Grid.field[this.getX()][this.getY()] instanceof Mho) {
			setDead(true);
		}
	}
}
