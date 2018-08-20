package com.mycompany.a3;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;
public class CommandKillAsteroid extends Command {
	private static GameWorld game;
	private static CommandKillAsteroid kill;
	private GameWorld gw;
	public CommandKillAsteroid(GameWorld gw)
	{
		super("Kill Asteroid");
		this.gw=gw;
	}
	
	public static CommandKillAsteroid getInstance(GameWorld gw)
	{
		if(kill==null)
			kill=new CommandKillAsteroid(gw);
		return kill;
	}
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.missileHit();
		
	}
	
}
