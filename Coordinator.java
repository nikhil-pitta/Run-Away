package security;


import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Coordinator extends JPanel
{

	//private JFrame frame;


	public Coordinator()
	{

		/*

		frame = new JFrame("Drawing Panel");
		frame.setBounds(200, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


		setLayout(null);
		frame.getContentPane().add(this);
		frame.getContentPane().add(hero);


		frame.setVisible(true);
		 */
		TheRealMap map = new TheRealMap();
		Hero hero = new Hero();
		
		JFrame frame = new JFrame();

		frame = new JFrame ("");
		frame.setSize(1023, 952);
		frame.setLocation(400, 50);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(map);
		//add(hero);
		
		
		frame.getContentPane().add(this);
		
		//frame.add(map);


		//add(panel);
		//add(hero);


		frame.setVisible(true);

	}


}
