package security;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TheRealMap extends JPanel implements KeyListener, ActionListener{

	private BufferedImage image;
	private int ballx, bally;
	private int vx, vy;
	private int radius;

	Timer t = new Timer(5, this);


	public TheRealMap()
	{
		try{

			image = ImageIO.read(new File("Treasure.png"));
		} catch (IOException e) {
			System.err.println("HELLO MY DUDE YOU TRASH!!!!");
		}
		setBackground(Color.GREEN);

		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		
		ballx = 40-radius;
		bally = 40 - radius;
		
		radius = 20;

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

		//Graphics2D g2D = (Graphics2D) g;
		//g2D.fill(new Ellipse2D.Double(x, y, 40, 40));
		
	
		
		g.fillRect(ballx, bally, radius*2, radius*2);

	}

	public void actionPerformed(ActionEvent arg0) 
	{
		repaint();

		ballx+=vx;
		bally+=vy;

		vx = 0; 
		vy = 0;
	}

	public void up()
	{
		vy = -5;
		vx = 0;

	}

	public void down()
	{
		vy = 5;
		vx = 0;

	}

	public void right()
	{
		vy = 0;
		vx = 5;

	}

	public void left()
	{
		vy = 0;
		vx = -5;

	}


	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();

		if(code== KeyEvent.VK_RIGHT)
		{
			right();

		}
		else if(code== KeyEvent.VK_DOWN)
		{
			down();


		}
		else if(code== KeyEvent.VK_LEFT)
		{
			left();

		}
		else if(code== KeyEvent.VK_UP)
		{
			up();

		}

	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e){}
	
	public void collision()
	{
		
	}
}







/* public class Hero extends JPanel implements KeyListener, ActionListener
    {

    	private int x, y;
    	private int vx, vy;

    	Timer t = new Timer(5, this);


    	public Hero()
    	{
    		t.start();
    		addKeyListener(this);
    		setFocusable(true);
    		setFocusTraversalKeysEnabled(false);
    	}

    	public void paintComponent(Graphics g)
    	{
    		super.paintComponent(g);
    		Graphics2D g2 = (Graphics2D) g;
    		g2.fill(new Ellipse2D.Double(x, y, 40, 40));

    	}

    	public void actionPerformed(ActionEvent arg0) 
    	{
    		repaint();

    		x+=vx;
    		y+=vy;

    		vx = 0; 
    		vy = 0;
    	}

    	public void up()
    	{
    		vy = -5;
    		vx = 0;

    	}

    	public void down()
    	{
    		vy = 5;
    		vx = 0;

    	}

    	public void right()
    	{
    		vy = 0;
    		vx = 5;

    	}

    	public void left()
    	{
    		vy = 0;
    		vx = -5;

    	}


    	public void keyPressed(KeyEvent e) 
    	{
    		int code = e.getKeyCode();

    		if(code== KeyEvent.VK_RIGHT)
    		{
    			right();

    		}
    		else if(code== KeyEvent.VK_DOWN)
    		{
    			down();


    		}
    		else if(code== KeyEvent.VK_LEFT)
    		{
    			left();

    		}
    		else if(code== KeyEvent.VK_UP)
    		{
    			up();

    		}

    	}

    	public void keyReleased(KeyEvent e) {}
    	public void keyTyped(KeyEvent e){}


    }



}*/


