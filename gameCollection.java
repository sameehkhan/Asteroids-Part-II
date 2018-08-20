package com.mycompany.a3;
import java.util.Vector;
/**
 * Created 9/28/2017
 * Collection of objects that are used for the game world
 * ticker.
 *
 */
public class gameCollection implements Icollections{
private Vector <GameObjects> worldVector;

public gameCollection()
{
	worldVector=new Vector<GameObjects>();
}
//remove object
public boolean remove(GameObjects o)
{
	return worldVector.remove(o);
}
//add object
public void add(GameObjects n)
{
	worldVector.addElement(n);
}
//iterator used to update the world and iterate through world vector
public Iiterator getIterator() {
	// TODO Auto-generated method stub
	return new ObjectIterator();
}
//size of worldVector
public int size()
{
	return worldVector.size();
}

//Implement Iterator
private class ObjectIterator implements Iiterator
{
	private int elementCount;
	public ObjectIterator()
	{
		elementCount=-1;
	}
	
	public GameObjects getNext()
	{
		elementCount++;
		return (worldVector.elementAt(elementCount));
	}
	
	public boolean hasNext()
	{
		if(worldVector.size()<=0)
		{
			return false;
		}
		if(elementCount==worldVector.size()-1)
		{
			return false;
		}
		
		else{
			return true;
		}
	}

	public Object get(int i) {
		// TODO Auto-generated method stub
		return worldVector.get(i);
	}

	public int size() {
		// TODO Auto-generated method stub
		return worldVector.size();
	}

	public Object elementAt(int l) {
		// TODO Auto-generated method stub
		return worldVector.elementAt(l);
	}
	
}




}
