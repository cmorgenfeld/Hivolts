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
	private boolean gameLost = false;
	
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
		if(gameLost) {
			g.setColor(Color.RED);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.BLACK);
			g.drawString("You Lost!", 250, 300);
		}
	}
	
	public void move(int x, int y) {
		super.move(x, y);
		System.out.println("moved");
		isDead();
		System.out.println(getDead());
		if(getDead()) {
			gameLost = true;
			System.out.println("Dead");
		}
	}
	
	public void jump() {
		System.out.println("Dead");
		int youCount = 0;
		Grid.field[this.getX()][this.getY()] = null;
		while (youCount < 1) {
			for (int i = 1; i < 11; i++) {
				for (int j = 1; j < 11; j++) {
					if (!(Grid.field[i][j] instanceof Fence) && Math.random() <= 0.01 && youCount<1 && !(i==this.getX() && j == this.getY())) {
						Grid.field[i][j] = new You(i, j);
						this.setX(i);
						this.setY(j);
						youCount++;
						break;

		        }
		      }
		    }
		  }
	}
	
	public void isDead() {
		if(Grid.field[this.getX()][this.getY()] instanceof Fence || Grid.field[this.getX()][this.getY()] instanceof Mho) {
			System.out.println("Dead?");
			setDead(true);
		}
	}
}


