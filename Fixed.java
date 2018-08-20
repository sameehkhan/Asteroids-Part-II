package com.mycompany.a3;

import com.mycompany.a3.GameObjects;

/**
 * Created 9/25/2017
 * Class used for fixed objects.
 *
 */
public abstract class Fixed extends GameObjects
{
	private static int ID=0;
	public Fixed(int r, int g, int b)
	{
		super(r,g,b);
		ID++;
	}
	public void setLocationValue(double x, double y)
	{
		System.out.println("Error: Cannot move fixed object.");
	}
	
	public void setID(int i)
	{
		System.out.println("Error: Cannot change ID.");
	}
	
	public int getID()
	{
		return ID;
	}
}
