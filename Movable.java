package com.mycompany.a3;

import java.util.Random;
public abstract class Movable extends GameObjects{
	private int speed;
	private int direction;
	Random rand = new Random();
	//constructor
	public Movable(int r, int g, int b)
	{
		super (r,g,b);
	}
	//constructor
	public Movable(double x, double y, int r, int g, int b)
	{
		super(x,y,r,g,b);
	}
	/*public Movable(double x, double y, int speed)
	{
		super(x,y,speed);
	}*/
	
	public void move()
	{
		double degrees = Math.toRadians(getDirection()-90);
		double deltaX = (Math.cos(degrees)*this.getSpeed()*10)/10;
		double deltaY = (Math.sin(degrees)*this.getSpeed()*10)/10;
		double oldLocationX=super.getLocationX();
		double oldLocationY=super.getLocationY();
		double newDeltaX = Math.round((oldLocationX+deltaX)*10)/10;
		double newDeltaY = Math.round((oldLocationY+deltaY)*10)/10;
		super.setLocation(newDeltaX, newDeltaY);
	}
	//sets the direction
	public void setDirection(int dir)
	{
		if(dir<360&&dir>=0)
			direction=dir;
		else if(dir>=360)
			direction =dir%360;
		else
			direction=dir%360+360;
	}
	//gets direction
	public int getDirection()
	{
		return direction;
	}
	//sets the speed
	public void setSpeed(int s)
	{
		if(s<0)
			speed=0; 
		else if(s>10)
			speed=10;
		else
			speed=s;
	}
	//gets speed
	public int getSpeed()
	{
		return speed;
	}
}

