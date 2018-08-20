package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;
import com.mycompany.a2.Movable;

/**
 * Created 9/23/2017
 *Missile class used for missiles
 *need to implement a way to change direction of missile
 *when they are fired from the ship
 */
public class Missiles extends Movable implements IDrawable
{
	private int speedM;
	private int fuelLevel;
	//constructor
	public Missiles(double x, double y, int d, int s)
	{
		super(x,y,50,50,155);
		super.setDirection(d);
		super.setSpeed(s+1);
		setFuel(10);
	}
	@Override
	public String toString()
	{
		return ("Missile: loc="+ super.getLocationX()+","+super.getLocationY()+" color=["+super.getColorRed()+","+super.getColorGreen()+","+super.getColorBlue()+"] speed="+super.getSpeed()+" dir="+super.getDirection()+" fuel="+getFuel());
	}
	//get speed
	public int getSpeed()
	{
		return speedM;
	}
	//set speed
	public void setSpeed(int s)
	{
		speedM=s;
	}
	//get fuel
	public int getFuel()
	{
		return fuelLevel;
		
	}
	//set missile fuel
	public void setFuel(int f)
	{
		if(f>10)
			f=10;
		else if(f<0)
			f=0;
		else
		fuelLevel=f;
	}
	//removes missile fuel
	public int removeFuel()
	{
		return fuelLevel--;
	}
	public void draw(Graphics g, Point pr) {
		// TODO Auto-generated method stub
		g.setColor(ColorUtil.CYAN);
		int x = (int) (pr.getX() + super.getLocationX());
		int y = (int) (pr.getY()+super.getLocationY());
		
		g.fillRect(x, y, 10, 10);
		g.drawRect(x, y, 10, 10);
		//move();
	}
	
}
