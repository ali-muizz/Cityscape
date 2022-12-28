import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;

public class MovingUFO {
	
	private int x;
	private int y;
	private int xa;
	private int ya;
	private CityScape reference; 
	private static final int DIAMETER = 60;
	
	private boolean right = false, left = false;
	private boolean up = false, down = false;
	private boolean space = false;
	
	public MovingUFO(CityScape reference) {
		this.reference = reference;
		this.x = 200;
		this.y = 200;
		this.xa = 0;
		this.ya = 0;
	}
	
	public void keyPressed(KeyEvent e){
		//This checks to see which key was pressed, and then sets the appropriate
		//Boolean to true
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			left = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			up = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			down = true;
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			space = true;
		}
	}
	
	public void keyReleased(KeyEvent e){
		//When the key is released, set the Boolean to false, and change
		//acceleration to 0
		if (e.getKeyCode() == KeyEvent.VK_LEFT){
			left = false;
			xa=0;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT){
			right = false;
			xa=0;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP){
			up = false;
			ya=0;
		}

		if (e.getKeyCode() == KeyEvent.VK_DOWN){
			down = false;
			ya=0;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE){
			space = false;
		}
	}

	public void move() {
		//Base your acceleration on the Booleans set by your keyPressed method
		if (right) {
			xa = 1;
		}
		if (left){
			xa = -1;
		}
		if (down){
			ya = 1;
		}
		if (up){
			ya = -1;
		}
		
		if(x+xa*10 < reference.getWidth()-DIAMETER-15 && (x + xa *10 )> 0)
		{
			x+=xa*10;
		}
		
		if(y+ya*10 < reference.getHeight()-DIAMETER * 6 && (y + ya *10 ) > 0)
		{
			y+=ya * 10;
		}

		//y+=ya * 10;
	}

	public void paint(Graphics g)
	{
		
		if(space)
		{
			g.setColor(new Color(144,238,144));
			g.fillArc(x-33, y, 150, 1200, 0, 180);
		}
		
		g.setColor(Color.white);
		g.fillOval(x+15, y-15, 50, 40);
		g.setColor(Color.gray);
		g.fillOval(x, y, 80, 25);
	}

	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setX(int temp)
	{
		x = temp;
	}
	
	public void setY(int temp)
	{
		y = temp;
	}
	
	public boolean getSpace()
	{
		return space;
	}
}


