import java.awt.*;

public class Building {
	
	private int x;
	private int y;
	private int w;
	private static int frameHeight = 640;
	private static int frameWidth = 1020;
	private boolean firstRun; 
	
	int increment;
	int windowWidth;
	int theHeight;
	int windowsPerColumn;
	boolean[][] lightArray;
	
	public Building(int x, int y, int w)
	{
		this.x = x;
		this.y = y;
		this.w = w;
		this.firstRun = true;
		
		increment = 10;
		windowWidth = 25;
		theHeight = 1020 - this.y;
		windowsPerColumn = theHeight / (increment + windowWidth * 4);
		lightArray = new boolean[4][windowsPerColumn];
	}
	
	private boolean randomizer()
	{
		int randomized = (int) Math.floor(Math.random() * (10)); 
		return (randomized % 2) == 0;
	}
	
	public void paint(Graphics g)
	{
		// Actual Building
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(x, y, w, frameHeight - y);
		
		int theX = x + increment;
		int theY = y + increment;
							
		
		for(int i = 0; i < 4; i++)
		{
			theY = y + increment;
			for(int j = 0; j < windowsPerColumn; j++)
			{
				if(firstRun)
				{
					lightArray[i][j] = randomizer();
				}

				if(lightArray[i][j])
				{
					g.setColor(Color.black);
				}
				else
				{
					g.setColor(new Color(255,250,205));
				}
				g.fillRect(theX, theY, windowWidth, windowWidth);
				theY += windowWidth + increment;
			}
			theX += windowWidth + increment;
		}
		firstRun = false;
	}
	
}




