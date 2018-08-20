package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandFireMissiles extends Command{
	private static GameWorld game;
	private static CommandFireMissiles fire;
	private GameWorld gw;
	public CommandFireMissiles(GameWorld gw)
	{
		super("Fire");
		this.gw=gw;
	}
	
	public static CommandFireMissiles getInstance(GameWorld gw)
	{
		if(fire==null)
			fire=new CommandFireMissiles(gw);
		return fire;
	}
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.fireMissiles();
	}
}
