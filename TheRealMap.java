package security;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TheRealMap extends JPanel{

	private BufferedImage image;

    public TheRealMap()
    {
        try{

            image = ImageIO.read(new File("Treasure.png"));
        } catch (IOException e) {
            System.err.println("HELLO MY DUDE YOU TRASH!!!!");
        }
        setBackground(Color.GREEN);
    }
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        int w = getWidth();
        int h = getHeight();
        g.drawImage(image, 427, 25, this);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(9));
        g2.drawLine(0, 0, 0, 900);
        g2.drawLine(0, 0, 1000, 0);
        g2.drawLine(1000, 0, 1000, 900);
        g2.drawLine(0, 900, 1000, 900);
        g2.fillRect(100, 100, 50, 50);
        g2.fillRect(200, 100, 50, 50);
        g2.fillRect(100, 300, 50, 50);
        g2.fillRect(100, 500, 50, 50);
        g2.fillRect(100, 700, 50, 50);
        g2.fillRect(200, 300, 50, 50);
        g2.fillRect(200, 500, 50, 50);
        g2.fillRect(200, 700, 50, 50);
        g2.fillRect(400, 150, 50, 50);
        g2.fillRect(400, 350, 50, 50);
        g2.fillRect(400, 550, 50, 50);
        g2.fillRect(400, 750, 50, 50);
        g2.fillRect(500, 150, 50, 50);
        g2.fillRect(500, 350, 50, 50);
        g2.fillRect(500, 550, 50, 50);
        g2.fillRect(500, 750, 50, 50);
        g2.fillRect(800, 100, 50, 50);
        g2.fillRect(800, 300, 50, 50);
        g2.fillRect(800, 500, 50, 50);
        g2.fillRect(800, 700, 50, 50);
        g2.fillRect(700, 100, 50, 50);
        g2.fillRect(700, 300, 50, 50);
        g2.fillRect(700, 500, 50, 50);
        g2.fillRect(700, 700, 50, 50);
    }
    
    
}


