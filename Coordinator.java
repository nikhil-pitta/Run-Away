package security;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Coordinator
{
	
	private JFrame frame;
	

	public Coordinator()
	{
		
		/*
//hey whats up guys scarce here
		frame = new JFrame("Drawing Panel");
		frame.setBounds(200, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		setLayout(null);
		frame.getContentPane().add(this);
		frame.getContentPane().add(hero);

		
		frame.setVisible(true);
*/
		TheRealMap panel = new TheRealMap();
		Hero hero = new Hero();
		
        frame = new JFrame ("");
        frame.setSize(1023, 952);
        frame.setLocation(400, 50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.getContentPane().add(panel);
        frame.getContentPane().add(hero);
        
        
 
        frame.setVisible(true);
		
	}
	

}
