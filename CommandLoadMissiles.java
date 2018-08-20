package com.mycompany.a3;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;
public class CommandLoadMissiles extends Command {
	private static CommandLoadMissiles lm;
	private static GameWorld game;
	private GameWorld gw;
	public CommandLoadMissiles(GameWorld gw)
	{
		super("Load Missiles");
		this.gw=gw;
	}
	
	public static CommandLoadMissiles getInstance(GameWorld gw)
	{
		if(lm==null)
			lm=new CommandLoadMissiles(gw);
		return lm;
	}
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.refillMissiles();
	}
}
