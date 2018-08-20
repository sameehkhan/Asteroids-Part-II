package com.mycompany.a3;
import java.util.Random;

import com.codename1.charts.models.Point;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Graphics;

public class SpaceStation extends Fixed implements IDrawable{
private int blink;
private boolean blinkingLight;
Random rand = new Random();
	//constructor
	public SpaceStation()
	{
		super(255,255,255);
		blink = rand.nextInt(11)+1;
	}
	//check blink
	public boolean checkBlink()
	{
		return blinkingLight;
	}
	//switch blink
	public void offSwitch()
	{
		if(blinkingLight)
			blinkingLight=false;
		else
			blinkingLight=true;
	}
	//get blink
	public int getBlink()
	{
		return blink;
	}
	
	
	@Override
	public String toString()
	{
		return ("station: loc="+super.getLocationX()+","+super.getLocationY()+" color=["+super.getColorRed()+","+super.getColorGreen() +","+super.getColorBlue()+"] Rate="+getBlink());
	}
	public void draw(Graphics g, Point pr) {
		// TODO Auto-generated method stub
		g.setColor(ColorUtil.BLUE);
		int x = (int) (pr.getX() + super.getLocationX());
		int y = (int) (pr.getY()+super.getLocationY());
		
		g.fillRect(x, y, 100, 50);
		g.drawRect(x, y, 100, 50);
		//move();
	}
}
