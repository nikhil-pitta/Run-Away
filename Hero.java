package security;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;
import javax.swing.Timer;

public class Hero extends JPanel implements KeyListener, ActionListener
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
