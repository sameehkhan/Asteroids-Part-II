package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandAddAsteroid extends Command{
private static CommandAddAsteroid asteroid;
private static GameWorld game;
int mapWidth = GameWorld.getMapWidth();
int mapHeight = GameWorld.getMapHeight();
private Asteroid g = new Asteroid(mapWidth, mapHeight);
private GameWorld gw;
	public CommandAddAsteroid(GameWorld gw)
	{
		super("Add Asteroid");
		this.gw=gw;
	}
	
	public static CommandAddAsteroid getInstance(GameWorld gw)
	{
		if(asteroid == null)
		{
			asteroid = new CommandAddAsteroid(gw);
		}
		return asteroid;
	}
	
	public static void setPlace(GameWorld gw)
	{
		if(game == null)
			game = gw;
	} 
	
	public void actionPerformed(ActionEvent event)
	{
		gw.AddAsteriod();
		//System.out.println(g);
	}


}
