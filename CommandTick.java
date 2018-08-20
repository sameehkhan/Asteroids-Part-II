package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandTick extends Command {
	private static GameWorld game;
	private static CommandTick tick;
	private GameWorld gw;
	public CommandTick(GameWorld gw)
	{
		super("Tick");
		this.gw=gw;
	}
	
	
	public static CommandTick getInstance(GameWorld gw)
	{
		if(tick==null)
			tick= new CommandTick(gw);
		return tick;
	}
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.gameClock();
	}
}
