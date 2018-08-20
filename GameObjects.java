package com.mycompany.a3;
import java.util.*;

import com.codename1.charts.util.ColorUtil;
/**
 * Created 9/27/2017
 *GameObjects class that creates all game objects ex: ships, asteroids, missiles, space 
 *stations.
 */
public abstract class GameObjects {
		private Random rand = new Random();
		private double locX, locY;
		private int color;
		private GameWorld gw;
		private int size;
		private int currspeed;
		public GameObjects(int r, int g, int b)
		{	
			color = ColorUtil.rgb(r, g, b);
			locX= (double)rand.nextInt(1024);
			locY= (double)rand.nextInt(768);
			setSize(50);
		}
		/*public GameObjects()
		 * first attempt for asteroids
		{
			
			locX= (double)rand.nextInt(1024);
			locY= (double)rand.nextInt(768);
			size = rand.nextInt(30);
		}*/
		public GameObjects(double x, double y, int r, int g, int b)
		{
			
			locX=x;
			locY=y;
			color = ColorUtil.rgb(r, g, b);
			setSize(50);
		}
		
		public void setColor(int red, int green, int blue)
		{
			color = ColorUtil.rgb(red, green, blue);
		}
		
		public void setLocation(double x, double y)
		{
			if(x<=GameWorld.getMapWidth() && x>=0.0)
				locX=x;
			else if(x>GameWorld.getMapWidth())
				locX=GameWorld.getMapWidth();
			else
				locX=0.0;
			if(y<=GameWorld.getMapHeight() && y>=0.0)
				locY=y;
			else if(y>GameWorld.getMapHeight())
				locY=GameWorld.getMapHeight();
			else
				locY=0.0;
		}
		public double getLocationX()
		{
			return locX;
		}
		
		public double getLocationY()
		{
			return locY;
		}
		
		public int getColorRed()
		{
			return ColorUtil.red(color);
		}
		
		public int getColorGreen()
		{
			return ColorUtil.green(color);
		}
		
		public int getColorBlue()
		{
			return ColorUtil.blue(color);
		}
		
		public abstract String toString();
			/*
			 * Originally had Location class but proved too difficult to call
			 * instead location is an attribute. 
			 * public void setLocation(Location loc)
			{
				this.loc.setX(loc.getX());
				this.loc.setY(loc.getY());
				
			}
			public Location getLocation()
			{
				return this.loc;
			}
			
			public Color getColor()
			{
				return this.color;
			}
			*/
			public int getSize()
			{
				return size;
			}
			public void setSize(int size)
			{
				this.size = size;
			}
			
					
		
		
		
}
