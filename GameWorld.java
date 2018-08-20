package com.mycompany.a3;
import java.util.Iterator;
import java.util.Observable;
import com.mycompany.a3.Asteroid;
import com.mycompany.a3.GameObjects;
import com.mycompany.a3.Missiles;
import com.mycompany.a3.Movable;
import com.mycompany.a3.Ship;
import com.mycompany.a3.SpaceStation;
import java.util.Observer;
import java.util.Vector;
import com.mycompany.a3.gameCollection;

public class GameWorld extends Observable implements IGameWorld
{
	private static int mapWidth;
	private static int mapHeight;
	private Vector<Observer> myObserver = new Vector<Observer>();
	private GameWorldProxy myp;
	private static int time;
	private int lives;
	private int currTime;
	private int tick;
	private final int missileCount=10;
	private gameCollection worldVector;
	private Vector<GameObjects> collisionList = new Vector<GameObjects>();
	private int shipCount;
	private Ship player;
	private int score;
	private boolean soundOn;
	public void init()
	{
		worldVector = new gameCollection();
		score=0;
		lives = 3;
		tick = 0;
		shipCount = 0;
		updateWorld();
	}
	//constructor
	public GameWorld()
	{
		worldVector = new gameCollection();
		this.init();
	}
	
	public void updateWorld()
	{
		notifyObservers();
	}
	public boolean getSoundOn()
	{
		return soundOn;
	}
	
	public void setSoundOn(boolean s)
	{
		this.soundOn = s;
		this.updateWorld();
	
	}
	public void commandAbout()
	{
		new About();
	}
	public void quitCommand()
	{
		new ClosingMessage();
	}
	
	//add asteroid
	public void AddAsteriod()
	{
		Asteroid asteroid = new Asteroid(mapWidth, mapHeight);
		worldVector.add(asteroid);
		System.out.println(asteroid.toString());
		updateWorld();
	}
	//add space station
	public void AddSpaceStation()
	{
		SpaceStation spaceStation = new SpaceStation();
		worldVector.add(spaceStation);
		System.out.println(spaceStation.toString());
		updateWorld();
	}
	//add ship
	public void AddShip()
	{
		if(shipCount==0)
		{
			player=new Ship(mapWidth,mapHeight);
			worldVector.add(player);
			shipCount++;
			System.out.println(player.toString());
		}
		else{
			System.out.println("Error: Only one ship allowed");
		}
		updateWorld();
	}
	// increase ship
	public void IncreamentShip()
	{
		if(shipCount==0){
			System.out.println("Error: No ship spawned");
		}
		else{
		player.increament();
		System.out.println(player.toString());
		}
		updateWorld();
	}
	//decrease ship
	public void DecreamentShip()
	{
		if(shipCount==0){
			System.out.println("Error: No ship spawned");
		}
		else{
		player.decreament();
		System.out.println(player.toString());
		}
		updateWorld();
	}
	//turn ship left
	public void turnLeft()
	{
		if(shipCount==0){
			System.out.println("Error: Cannot steer, no ship in game.");
		}
		else{
		player.steerLeft();
		System.out.println(player.toString());
		}
		updateWorld();	}
	//turn ship right
	public void turnRight()
	{
		if(shipCount==0){
			System.out.println("Error: Cannot steer, no ship in game.");
		}
		else{
		player.steerRight();
		System.out.println(player.toString());
		}
		updateWorld();
	}
	//fires missiles
	public void fireMissiles()
	{
		double x = player.getLocationX();
		double y = player.getLocationY();
		int direction = player.getDirection();
		int speed = player.getSpeed();
		if(player.getMissileCount()>0)
		{
			player.fire();
			Missiles m = new Missiles(x,y,direction,speed);
			worldVector.add(m);
			System.out.println(player.toString());
		}
		else{
			System.out.println("Error: Ship out of missiles.");
		}
		updateWorld();
	}

	//ship goes into hyper space
	public void jumpHyper()
	{
		if(shipCount<=0)
		{
			System.out.println("Error: Cannot jump, no ship in game.");
		}
		else{
		player.spawnPoint();
		System.out.println(player.toString());
		}
		updateWorld();
	}
	
	//refills missiles
	public void refillMissiles()
	{
		if(shipCount<=0)
		{
			System.out.println("Error: Cannot reload, no ship in game.");
		}
		else{
		player.refillMissiles();
		System.out.println(player.toString());
		}
		updateWorld();
	}
	
	//missile hits asteroid
	public void missileHit()
	{
		int mcount = player.getMissileCount();
		int asteroidAmount = getAsteroidCount();
		if(asteroidAmount <= 0 || mcount<=0)
		{
			System.out.println("Error: No asteroid or missiles in game.");
		}
		else{
			killAsteroid();
			killMissile();
			score++;
			mcount--;
			player.setMissileCount(missileCount);
			System.out.println("A missile struck an asteroid.");
		}
		
	}
	
	public int getLives()
	{
		return lives;
	}
	
	//ship crashes into asteroid
	public void shipCrashed()
	{
		int astCount = getAsteroidCount();
		if(shipCount<=0 || astCount<=0)
		{
			System.out.println("Error: No ship or asteroid in game to crash");
			
		}
		else
		{
			killAsteroid();
			worldVector.remove(player);
			shipCount--;
			lives--;
			System.out.println("Ship crashed into asteroid.");
			if(lives<=0)
			{
				quitCommand();
			}
		}
		updateWorld();
	}
	//asteroids collide into each other
	public void asteroidsCollide()
	{
		int asteroidCount = getAsteroidCount();
		if(asteroidCount<2)
		{
			System.out.println("Error: One asteroid only in game.");
			
		}
		else{
			killAsteroid();
			killAsteroid();
			System.out.println("Two asteroids have collided");
		}
		updateWorld();
	}
	//updates the game world 
	
	public int getClock()
	{
		return tick;
	}
	public void gameClock()
	{
		Iiterator itr = (Iiterator) worldVector.getIterator();
		while(itr.hasNext())
		{
			GameObjects object = (GameObjects) itr.getNext();
			if(object instanceof Movable)
			{
				Movable m = (Movable)object;
				m.move();
			}
			if(object instanceof Missiles)
			{
				((Missiles)object).removeFuel();
				if(((Missiles)object).getFuel()==0)
					worldVector.remove(object);
			}
			if(object instanceof SpaceStation)
			{
				int blinkRate = ((SpaceStation)object).getBlink();
				if(tick%blinkRate==0)
					((SpaceStation)object).offSwitch();
			}
			
		}
		tick++;
		System.out.println("Game World clock updated!");
		updateWorld();
		collision();
		
		if(currTime+20<tick)
		{
			for(int i = 0; i<collisionList.size();i++)
			{
				collisionList.remove(i);
			}
		}
	}
	
	//displays score, missile count, and world clock
	public void display()
	{
		System.out.println("Score: "+score);
		System.out.println("Missile Count: "+player.getMissileCount());
		System.out.println("World Clock: "+tick);
		
		
	}
	
	//ma

	
	//quits game
	public void quitGame()
	{
		System.exit(0);
	}
	//removes asteroid
	public boolean removeAsteroids(GameObjects a)
	{
		boolean r = false;
		Iiterator itr = (Iiterator) worldVector.getIterator();
		while(itr.hasNext())
		{
			GameObjects stuff = (GameObjects) itr.getNext();
			if(stuff instanceof Asteroid)
			{
				worldVector.remove(stuff);
			}
		}
		return true;
	}
	public void killAsteroid()
	{
		Iiterator itr = (Iiterator) worldVector.getIterator();
		while(itr.hasNext())
		{
			GameObjects stuff = (GameObjects) itr.getNext();
			if(stuff instanceof Asteroid)
			{
				worldVector.remove(stuff);
				break;
			}
		}
	}
	//removes missile
	public void killMissile()
	{
		Iiterator itr = (Iiterator) worldVector.getIterator();
		while(itr.hasNext())
		{
			GameObjects stuff = (GameObjects) itr.getNext();
			if(stuff instanceof Missiles)
			{
				worldVector.remove(stuff);
				break;
			}
		}
		updateWorld();
	}
	
	public int getAsteroidCount()
	{
		int asteroidCount = 0;
		Iiterator aitr = worldVector.getIterator();
		while(aitr.hasNext())
		{
			GameObjects item = (GameObjects) aitr.getNext();
			if(item instanceof Asteroid)
			{
				asteroidCount++;
			}
		}
		return asteroidCount;
	}

	public int getTime()
	{
		return time;
	}
	
	public int getScore()
	{
		return score;
		
	}
	
	public void addObserver(Observer o)
	{
		myObserver.add(o);
	}
	public void notifyObservers()
	{
		this.setChanged();
		myp=new GameWorldProxy(this);
		for(Observer o : myObserver)
		{
			o.update((Observable)myp, null);
		}
			
		
	}
	public gameCollection getGameObjects()
	{
		return worldVector;
	}
	public int getMissiles() {
		// TODO Auto-generated method stub
		int missiles =0;
		if(shipCount>0)
		{
			missiles = player.getMissileCount();
		}
		return missiles;
	}
	public void printMap() {
		// TODO Auto-generated method stub
		System.out.println("Displaying Map:");
        System.out.println( "Map Height: " + getMapHeight() + "  Map Width: " + getMapWidth() );
        Iiterator it = worldVector.getIterator();
        while(it.hasNext())
        {
        	GameObjects stuff = (GameObjects) it.getNext();
        	System.out.println(stuff.toString());
        }
	}
	public void displayCollection() {
		// TODO Auto-generated method stub
		
	}
	public static int getMapWidth()
	{
		return mapWidth;
	}
	
	public static int getMapHeight()
	{
		return mapHeight;
	}
	public void setMapWidth(int width)
	{
		mapWidth = width;
	}
	public void setMapHeight(int height)
	{
		mapHeight = height;
	}
	
private void collision ()
{
	Object one;
	Object two;
	Iiterator itr = worldVector.getIterator();
	while(itr.hasNext())
	{
		one = itr.getNext();
		if(one instanceof Asteroid)
		{
			Asteroid ast = (Asteroid) one;
			Iiterator itr2 = worldVector.getIterator();
			while(itr2.hasNext())
			{
				two = itr2.getNext();
				if(two instanceof Asteroid)
				{
					Asteroid asteroid2 = (Asteroid) two;
					if(ast.collidesWith(asteroid2))
					{
						currTime = tick;
						ast.handleCollision(asteroid2, this);
						addCollision(ast);
						//for(int i = 0; i<=collisionList.size();i++)
						//{
						//	removeAsteroids(collisionList.get(i));
						//}
						
					}
				}
			}
		}
	}
}
public boolean collisionCheck(Asteroid a)
{
	for(int i =0; i<collisionList.size();i++)
	{
		if(collisionList.get(i)==a)
		{
			return true;
		}
	}
	return false;
}
public void addCollision(Asteroid ast)
{
	collisionList.add(ast);
}
}
