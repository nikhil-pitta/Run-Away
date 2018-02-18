package security;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
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
	private BufferedImage hero;
	private BufferedImage fire;
	private BufferedImage blocks;

	private int ballx, bally;
	private int vx, vy;
	private int radius;

	private int changeX;
	private int changeY;
	private boolean hit = false;
	private boolean collected = false;
	private Rectangle player;
	private Rectangle temp;
	private int avx;
	private int avy;
	private int ax;
	private int a2x;
	private int a3x, a3y;
	private int count = 0;
	private Rectangle AI1, AI2, AI3, AI4, AI5, AI6, AI7, AI8;
	private Rectangle Treasure;


	Timer t = new Timer(5, this);


	public TheRealMap()
	{
		try{

			image = ImageIO.read(new File("src//security//Treasure.png"));
			hero = ImageIO.read(new File("src//security//Hero.png"));
			fire = ImageIO.read(new File("src//security//Litaf.png"));
			blocks = ImageIO.read(new File("src//security//Blocks.png"));

		} catch (IOException e) {
			System.err.println("HELLO MY DUDE YOU TRASH!!!!");
		}
		setBackground(Color.GREEN);

		t.start();
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);

		ballx = 40 - radius;
		bally = 40 - radius;

		avx = 3;
		avy = 3;

		ax = 100;
		a2x = 700;
		a3x = 475;
		a3y = 150;

		radius = 20;

		player = new Rectangle(ballx, bally, 20*2, 20*2);

	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(Color.BLACK);
		int w = getWidth();
		int h = getHeight();

		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(9));
		g2.drawLine(0, 0, 0, 900);
		g2.drawLine(0, 0, 1000, 0);
		g2.drawLine(1000, 0, 1000, 900);
		g2.drawLine(0, 900, 1000, 900);

		for(int x = 100; x <= 300; x+= 150)
		{
			for(int y = 100; y <= 700; y+=200)
			{
				g2.setColor(Color.BLACK);
				g2.fillRect(x, y, 50, 50);
				g.drawImage(blocks, x, y, this);
			}
		}

		if(collected==true)
		{

			if(count%2==0)
			{
				g.drawImage(image, 0, 0, this);
				
			}

			else g.drawImage(image, 875, 800, this);

			//count++;

			collected = false;
		}

		else
		{

			Treasure = new Rectangle(875, 800, 50, 50);
			g.setColor(Color.GREEN);
			g.fillRect(Treasure.x, Treasure.y, 50, 50);

			g.drawImage(image, 875, 800, this);


			g.setColor(Color.RED);
		}


		move();
		g.setColor(Color.GREEN);
		AI1 = new Rectangle(ax, 200, 50, 50);
		g.fillRect(AI1.x, AI1.y, 50, 50);
		g.drawImage(fire, ax-15, 200-15, this);

		AI2 = new Rectangle(ax, 400, 50, 50);
		g.fillRect(AI2.x, AI2.y, 50, 50);
		g.drawImage(fire, ax-15, 400-15, this);

		AI3 = new Rectangle(ax, 600, 50, 50);
		g.fillRect(AI3.x, AI3.y, 50, 50);
		g.drawImage(fire, ax-15, 600-15, this);


		for(int x = 400; x <= 600; x+= 150)
		{
			for(int y = 150; y <= 750; y+=200)
			{
				g2.setColor(Color.BLACK);
				g2.fillRect(x, y, 50, 50);
				g.drawImage(blocks, x, y, this);
			}
		}

		for(int x = 700; x <= 900; x+= 150)
		{
			for(int y = 100; y <= 700; y+=200)
			{
				g2.setColor(Color.BLACK);
				g2.fillRect(x, y, 50, 50);
				g.drawImage(blocks, x, y, this);
			}
		}

		g.setColor(Color.RED);

		AI7 = new Rectangle(a3x, a3y, 50, 50);
		g.setColor(Color.GREEN);
		g.fillRect(AI7.x, AI7.y, 50, 50);
		g.drawImage(fire, a3x-15, a3y-15, this);

		AI8 = new Rectangle(a3x, a3y+400, 50, 50);
		g.setColor(Color.GREEN);
		g.fillRect(AI8.x, AI8.y, 50, 50);
		g.drawImage(fire, a3x-15, a3y+385, this);

		AI4 = new Rectangle(a2x, 200, 50, 50);
		g.setColor(Color.GREEN);
		g.fillRect(AI4.x, AI4.y, 50, 50);
		g.drawImage(fire, a2x-15, 200-15, this);

		AI5 = new Rectangle(a2x, 400, 50, 50);
		g.fillRect(AI5.x, AI5.y, 50, 50);
		g.drawImage(fire, a2x-15, 400-15, this);

		AI6 = new Rectangle(a2x, 600, 50, 50);
		g.fillRect(AI6.x, AI6.y, 50, 50);
		g.drawImage(fire, a2x-15, 600-15, this);



		g.setColor(Color.GREEN);
		player = new Rectangle(ballx, bally, 20*2, 20*2);
		g.drawImage(hero, player.x-30, player.y-30, this);


		if(hit)
		{
			ballx = 40-radius;
			bally = 40-radius;

			g.fillRect(ballx, bally, player.width, player.height);
			g.drawImage(hero, ballx-30, bally-30, this);
			hit = false;
		}


		else
		{
			//g.fillRect(ballx, bally, radius*2, radius*2);
			g.fillRect(player.x, player.y, player.width, player.height);
			g.drawImage(hero, ballx-30, bally-30, this);

		}

	}

	public void move()
	{
		if(ax>300 || ax<30 || a2x<25 || a2x>900)
		{
			avx = -avx;

		}
		ax +=avx;
		a2x += avx;
		a3y += avx;


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

		collision();


	}

	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e){}

	public void collision()
	{
		for(int x = 100; x <= 300; x+= 150)
		{
			for(int y = 100; y <= 700; y+=200)
			{
				temp = new Rectangle (x, y, 50, 50);

				if((Math.abs(player.x - temp.x) * 2 < (player.width + temp.width)) && (Math.abs(player.y - temp.y) * 2 < (player.height + temp.height)))
				{
					hit = true;
				}

			}
		}

		for(int x = 400; x <= 600; x+= 150)
		{
			for(int y = 150; y <= 750; y+=200)
			{
				temp = new Rectangle (x, y, 50, 50);

				if((Math.abs(player.x - temp.x) * 2 < (player.width + temp.width)) && (Math.abs(player.y - temp.y) * 2 < (player.height + temp.height)))
				{
					hit = true;
				}

			}
		}

		for(int x = 700; x <= 900; x+= 150)
		{
			for(int y = 100; y <= 700; y+=200)
			{
				temp = new Rectangle (x, y, 50, 50);

				if((Math.abs(player.x - temp.x) * 2 < (player.width + temp.width)) && (Math.abs(player.y - temp.y) * 2 < (player.height + temp.height)))
				{
					hit = true;
				}

			}
		}


		if((Math.abs(player.x - AI1.x) * 2 < (player.width + AI1.width)) && (Math.abs(player.y - AI1.y) * 2 < (player.height + AI1.height))) 
			hit = true;

		if((Math.abs(player.x - AI2.x) * 2 < (player.width + AI2.width)) && (Math.abs(player.y - AI2.y) * 2 < (player.height + AI2.height))) 
			hit = true;

		if((Math.abs(player.x - AI3.x) * 2 < (player.width + AI3.width)) && (Math.abs(player.y - AI3.y) * 2 < (player.height + AI3.height))) 
			hit = true;

		if((Math.abs(player.x - AI4.x) * 2 < (player.width + AI4.width)) && (Math.abs(player.y - AI4.y) * 2 < (player.height + AI4.height))) 
			hit = true;

		if((Math.abs(player.x - AI5.x) * 2 < (player.width + AI5.width)) && (Math.abs(player.y - AI5.y) * 2 < (player.height + AI5.height))) 
			hit = true;

		if((Math.abs(player.x - AI6.x) * 2 < (player.width + AI6.width)) && (Math.abs(player.y - AI6.y) * 2 < (player.height + AI6.height))) 
			hit = true;

		if((Math.abs(player.x - AI7.x) * 2 < (player.width + AI7.width)) && (Math.abs(player.y - AI7.y) * 2 < (player.height + AI7.height))) 
			hit = true;

		if((Math.abs(player.x - AI8.x) * 2 < (player.width + AI8.width)) && (Math.abs(player.y - AI8.y) * 2 < (player.height + AI8.height))) 
			hit = true;

		if((Math.abs(player.x - Treasure.x) * 2 < (player.width + Treasure.width)) && (Math.abs(player.y - Treasure.y) * 2 < (player.height + Treasure.height))) 
		{
			collected = true;
		}

	}






}






