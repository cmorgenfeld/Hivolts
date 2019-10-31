package game;

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
	
	public void drawYou(Graphics g) {
		try {
	    	sprite = ImageIO.read(new File("src/game/You.png"));
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
	
	public void move(int x, int y) {
		Grid.field[this.getX()][this.getY()] = null;
		super.move(x, y);
		isDead();
		Grid.field[this.getX()][this.getY()] = new You(this.getX(), this.getY());
	}
	
	private boolean notafenceandlowprop(int i, int j) {
		return !(isFence(i, j)) && Math.random() <= 0.01;
	}
	
	public void jump() {
		boolean done = false;
		Grid.field[this.getX()][this.getY()] = null;
		while (!done) {
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					boolean p = notafenceandlowprop(i,j);
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
	
	public boolean isFence(int x, int y) {
		return(Grid.field[x][y] instanceof Fence);
	}
	
	public boolean isMho(int x, int y) {
		return(Grid.field[x][y] instanceof Mho);
	}
	
	public boolean oldCoords(int x, int y) {
		return x == this.getX() && y == this.getY();
	}
	
	public void isDead() {
		if(Grid.field[this.getX()][this.getY()] instanceof Fence || Grid.field[this.getX()][this.getY()] instanceof Mho) {
			setDead(true);
		}
	}
