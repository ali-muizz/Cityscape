import javax.imageio.*;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import javax.imageio.*;

public class Car {

	private int xa;
	private boolean direction;
	public int x = 200;
	public int y = 510;
	private BufferedImage img = null;

    public boolean trapped = false;
    public boolean visible = true;

	public Car()
	{
		try
		{
			img = ImageIO.read(new File("car.png"));
		}
		catch (IOException e)
		{
			System.out.println("No Image");
		}
		
		xa = 1;
	}

	public void move()
	{
		 if (x + xa < 200)
		 {
			 xa = 1;
		 }
		 
		 if(x + xa > 1020)
		 {
			 xa = -1;
		 }
		 
		 if (!trapped) 
		 {
			 x = x + xa * 3;
			 }
	}

	public void paint(Graphics2D g)
	{		
		if(visible)
		{
			if(xa < 0)
			{
				g.drawImage(img, x-200, y, 150, 150, null);	
			}		
			else
			{
				g.drawImage(img, x, y, -150, 150, null);
			}	
		}
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
}
