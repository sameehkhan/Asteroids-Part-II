package com.mycompany.a3;
import com.codename1.charts.models.Point;
import com.codename1.ui.Container;
import com.codename1.ui.Graphics;

import java.util.Observer;
import java.util.Observable;
public class MapView extends Container implements Observer{
	private gameCollection game;
	public MapView()
	{
		
	}

	public void update(Observable o, Object data) {
		// TODO Auto-generated method stub
		System.out.println("Map Width: " + GameWorld.getMapWidth()+" Map Height: "+GameWorld.getMapHeight());
		IGameWorld gw = (IGameWorld) o;
		game = gw.getGameObjects();
		Iiterator gameitr = game.getIterator();
		while(gameitr.hasNext())
		{
			System.out.println(gameitr.getNext());
		}
		
		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		int x = getX();
		int y = getY();
		
		/*Iiterator itr = game.getIterator();
		while(itr.hasNext())
		{
			Object n = itr.getNext();
			Point pnt = new Point(this.getX(),this.getY());
			if(n instanceof Ship)
			{
				Ship s = (Ship)n;
				s.draw(g, pnt);
			}
			if(n instanceof Asteroid)
			{
				Asteroid a = (Asteroid)n;
				a.draw(g, pnt);
				a.move();
			}
		}*/
		Point p = new Point(this.getX(),this.getY());
		Iiterator gi = game.getIterator();
		while(gi.hasNext())
		{
			Object o = gi.getNext();
			if(o instanceof Asteroid)
			{
				((Asteroid)o).draw(g, p);
			}
			
			if(o instanceof Ship)
			{
				((Ship)o).draw(g, p);
			}
		}
	}
	
}
