import java.awt.*;

public class UFO {
	
	private int x;
	private int y;
	private int xa;
	private int ya;
	private CityScape reference; 
	private static final int DIAMETER = 60;
	
	public UFO(CityScape reference, int x, int y, int xa, int ya) {
		this.reference = reference;
		this.x = x;
		this.y = y;
		this.xa = xa;
		this.ya = ya;
	}

	void move() {
		// if the ball hits the edge of the screen... reverse the
		// x/y velocity
		if ((x + xa < 0) || (x + xa > reference.getWidth() - DIAMETER))
			xa *= -1;
		if ((y + ya < 0) || (y + ya > reference.getHeight()/3))
			ya *= -1;
		//update x and y coordinates
		x = x + xa;
		y = y + ya;
	}
	
	public void collision(UFO u) {
		int dx = (x-u.x) + (xa-u.xa);
		int dy = (y-u.y) + (ya-u.ya);
		//if the balls collide...
		if (Math.sqrt(dx*dx+dy*dy)<=DIAMETER)
		{
			//switch velocities
			int tempxa = xa;
			int tempya = ya;
			xa = u.xa;
			ya = u.ya;
			u.xa = tempxa;
			u.ya = tempya;
		}
	}
	
	public void paint(Graphics g)
	{
		g.setColor(Color.white);
		g.fillOval(x+15, y-15, 50, 40);
		g.setColor(Color.gray);
		g.fillOval(x, y, 80, 25);
	}
}