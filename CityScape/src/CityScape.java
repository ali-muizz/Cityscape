import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CityScape extends JPanel {
	
	UFO[] list = new UFO[4];

	private Background theBackground = new Background();
	private Building building1 = new Building(25,300, 150);
	private Building building2 = new Building(225, 400, 150);
	private Building building3 = new Building(425, 250, 150);
	private Building building4 = new Building(625, 350, 150);
	private Building building5 = new Building(825, 300, 150);
	
	private Car c = new Car();
		
	private MovingUFO trollUFO = new MovingUFO(this);
		
	public CityScape() 
	{
		for (int i = 0; i< list.length; i++)
			list[i] = new UFO(this, i*50 + 10, i*50 + 10, (int)(10 * Math.random() - 5), (int)(10 * Math.random() - 5));
		
		//This adds the KeyListener to the BallWorld. It’s in this section that
		//you HAVE to have all three key listener methods whether they are used
		//or not. We place the KeyListener in the JPanel class because as we
		//mentioned before it is the director of all the action, so it receives
		//the keyboard information and then passes it along to the appropriate
		//classes.
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}
			@Override
			public void keyReleased(KeyEvent e) {
				//Passes the KeyEvent e to the ball instance
				trollUFO.keyReleased(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				//Passes the KeyEvent e to the ball instance
				trollUFO.keyPressed(e);
			}
		}); //NOTE THE SEMI-COLON!!!!
		//Making sure our JPanel has the focus and therefor it is the
		//instance that will receive the keyboard input
		setFocusable(true);
	}
	
	private void move() {
		
		c.move();
		
		trollUFO.move();
		
		carnapped(trollUFO, c);

		
		if(c.getX() > trollUFO.getX() && c.getX() + 200 < trollUFO.getX() + 300 && trollUFO.getSpace())
		{
			c.setY(1000);
		}

		//Check for collisions between each of UFO
		for (int i = 0; i < list.length; i++)
		{
			for (int j = i+1; j<list.length; j++)
			{
				list[i].collision(list[j]);
			}
		}
				
		//Move each UFO
		for (UFO u:list)
			u.move();
		 // THIS MOVES CAR, DO YOU ADD IT HERE?
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		theBackground.paint(g2d);
		building1.paint(g2d);
		building2.paint(g2d);
		building3.paint(g2d);
		building4.paint(g2d);
		building5.paint(g2d);
		trollUFO.paint(g2d);
		c.paint(g2d); // THIS PAINTS CAR, DO YOU ADD IT HERE?
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		//Paint each Ball in the list
		for (UFO u:list)
		{
			u.paint(g2d);	
		}
	}
	
	public void carnapped(MovingUFO u, Car c) {

		boolean touching = (u.getX() + 75 <= c.x + 10) && (u.getX() + 220 >= c.x);

		if (c.y <= u.getY() + 200) {
			c.visible = false;
		}

		if (u.getSpace() && touching) {
            c.trapped = true;
			if (c.y > u.getY() + 200) {
				c.y -= 10;
			}
        }
	}
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		
		JFrame frame = new JFrame("City");
		CityScape u = new CityScape();
		//frame.add(new CityScape());
		frame.setSize(1020,640);
		frame.setVisible(true);
		frame.add(u);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		while(true)
		{
			u.move();
			u.repaint();
			Thread.sleep(10); 
		}
	}

}