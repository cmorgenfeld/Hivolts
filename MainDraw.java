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
    private static BufferedImage image;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	image = ImageIO.read(new File("src/game/fence.png"));
        } catch (IOException e) {
        	System.out.println("Exception caught");
        }
        for(int i=0; i<600; i+= 50) {
        	g.drawImage(image, i, 0, 50, 50, Color.WHITE, null);
        	g.drawImage(image, i, 550, 50, 50, Color.WHITE, null);
        	g.drawImage(image, 0, i, 50, 50, Color.WHITE, null);
        	g.drawImage(image, 550, i, 50, 50, Color.WHITE, null);
        }
    }

    public void moveRight() {
        x = x + 5;
        repaint();
    }

    public void moveLeft() {
        x = x - 5;
        repaint();
    }

    public void moveDown() {
        y = y + 5;
        repaint();
    }

    public void moveUp() {
        y = y - 5;
        repaint();
    }
}