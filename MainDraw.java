import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.*;
import java.io.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;

public class MainDraw extends JComponent {

    public int x = 50;
    public int y = 50;
    public static BufferedImage image;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	image = ImageIO.read(new File("src/fence.png"));
        }
        catch (IOException e) {
        	System.out.println("Exception caught");
        }
        g.drawImage(image, 0, 0, 30, 30, Color.WHITE, null);
        //g.fillRect(x, y, 50, 50);
        //g.setColor(Color.BLACK);
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