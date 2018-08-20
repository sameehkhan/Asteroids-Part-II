package com.mycompany.a3;
import java.util.Random;
import com.codename1.ui.Graphics;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Dimension2D;
import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.mycompany.a2.Movable;
/**
 *asteroid class to make asteroids. 
 *Need to implement a method that changes direction when asteroids are created
 */
public class Asteroid extends Movable implements IDrawable, ICollider
{
	private Random rand = new Random();
	private int size;
	private int c;
	//constructor
	public Asteroid(int w, int h)
	{
		super(0,255,0);
		this.setLocation(rand.nextInt(w-0+1), rand.nextInt(h-0+1));
		c = ColorUtil.rgb(r.nextInt(255), r.nextInt(255), r.nextInt(255));
		size=rand.nextInt(30);
		super.setSpeed(rand.nextInt(11));
		super.setDirection(rand.nextInt(360));
	}
	
	//set location
	/*public void setLocation(double x, double y)
	{
		super.setLocation(x, y);
		if(m.getMapHeight()>= 1024.0 || m.getMapWidth()>=768.0 || m.getMapWidth()<=0.0|m.getMapHeight()<=0.0)
		{
			setDirection(getDirection()+rand.nextInt());
		}
	}*/
	//get size
	public int getSize()
	{
		return size;
	}
	@Override
	public void setSpeed(int speed)
	{
		System.out.println("Error: Speed cannot change.");
	}
	@Override
	public void setDirection(int direction)
	{
		System.out.println("Error: Direction cannot change.");
	}
	//set size
	public void setSize(int s)
	{
		System.out.println("Error: Size cannot change.");
	}
	
	@Override
	public String toString()
	{
		return("Asteroid: loc="+super.getLocationX()+","+super.getLocationY()+" color=["+super.getColorRed()+","+super.getColorGreen()+","+super.getColorBlue()+"] speed="+super.getSpeed()+" dir="+super.getDirection()+" size="+getSize());
	}
	/*public void move(Dimension d)
	{
		
	}*/
	Random r = new Random();
	public void draw(Graphics g, Point pr) {
		// TODO Auto-generated method stub
		g.setColor(c);
		int x = (int) (pr.getX() + super.getLocationX());
		int y = (int) (pr.getY()+super.getLocationY());
		
		g.fillArc(x, y, 100, 50, 0, 360);
		g.drawArc(x, y, 100, 50, 0, 360);
	}

	public boolean collidesWith(GameObjects ob) {
		// TODO Auto-generated method stub
		boolean check = false;
		double firstx = this.getLocationX()+(getSize()/2);
		double firsty = this.getLocationY()+(getSize()/2);
		double secondX = ob.getLocationX()+(ob.getSize()/2);
		double secondY = ob.getLocationY()+(ob.getSize()/2);
		double xDist = firstx - secondX;
		double yDist = firsty - secondY;
		double s = (xDist*xDist + yDist * yDist);
		int firstRadius = getSize()/2;
		int secondRadius = getSize()/2;
		
		int rSqr = (firstRadius*firstRadius+2 *firstRadius*secondRadius+secondRadius*secondRadius);
		if(s<=rSqr)
		{
			check =true;
		}
		return check;
	}

	public void handleCollision(GameObjects ob, GameWorld gw) {
		// TODO Auto-generated method stub
		int speed = getSpeed();
		speed--;
		if(speed>=0)
		{
			setSpeed(speed);
		}
	}
	
}
