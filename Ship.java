package com.mycompany.a3;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

/**
 * Created 9/20/2017
 * Ship class creates ship
 *
 */
public class Ship extends Movable implements Isteerable, IDrawable{
	private int steer;
	private int maxspeed;
	private int missileCount;
	private static double x = GameWorld.getMapHeight();
	private static double y = GameWorld.getMapWidth();
	//constructor
	public Ship(int x, int y)
	{
		super(x/2, y/2, 255, 0, 0);
		//this.setLocation(, y);
		super.setSpeed(0);
		super.setDirection(0);
		
		setMissileCount(10);
	}
	//get steering
	public int getSteering()
	{
		return steer;
	}
	//get maximum speed
	public int getMaxSpeed()
	{
		return maxspeed;
	}
	//get missile count
	public int getMissileCount()
	{
		return missileCount;
	}
	//set maximum speed
	public void setMaxSpeed(int MaxSpeed)
	{
		if(MaxSpeed>10)
			maxspeed=10;
		
	}
	//set missile count
	public void setMissileCount(int m)
	{
		missileCount=m;
	}
	//refill missiles
	public void refillMissiles()
	{
		setMissileCount(10);
	}
	//increase speed and change the ships x and y direction
	public void increament()
	{
		
		super.setSpeed(getSpeed()+1);
		super.setLocation(getLocationX()+5,getLocationY()+3);
	}
	//decrease speed and change the ships x and y direction
	public void decreament()
	{
		super.setSpeed(getSpeed()-1);
		super.setLocation(getLocationX()-5, getLocationY()-5);
	}
	//fire missiles
	public void fire()
	{
		if(missileCount>0 && missileCount<=10)
			missileCount--;
	}
	//ship spawn point
	public void spawnPoint()
	{
		super.setLocation(x/2, y/2);
	}
	//steer left
	public void steerLeft()
	{
		super.setDirection(super.getDirection()-5);
	}
	//steer right
	public void steerRight()
	{
		super.setDirection(super.getDirection()+5);
	}
	@Override
	public String toString()
	{
		return ("Ship: loc="+super.getLocationX()+","+super.getLocationY()+" color=["+super.getColorRed()+","+super.getColorGreen()+","+super.getColorBlue()+"] speed="+super.getSpeed()+" dir="+super.getDirection()+" missiles="+ getMissileCount());
	}
	public void draw(Graphics g, Point pr) {
		// TODO Auto-generated method stub
		g.setColor(ColorUtil.GREEN);
		int x = (int) (pr.getX() + super.getLocationX());
		int y = (int) (pr.getY()+super.getLocationY());
		
		g.fillRect(x, y, 50, 50);
		g.drawRect(x, y, 50, 50);
		//move();
	}
	
}
