import java.awt.*;

public class Background {
	
	private int x;
	private int y;
	private static int frameHeight = 640;
	private static int frameWidth = 1020;
	
	public Background()
	{
		this.x = 0;
		this.y = 0;
	}
	
	public void paint(Graphics g)
	{
		// Actual Building
		g.setColor(new Color(40, 0, 0));
		g.fillRect(x,y, frameWidth, frameHeight);
	}
	
}