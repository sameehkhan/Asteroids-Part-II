package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandTurnLeft extends Command {
private static GameWorld game;
private static CommandTurnLeft left;
private GameWorld gw;
	public CommandTurnLeft(GameWorld gw)
	{
		super("Turn left");
		this.gw=gw;
	}
	
	public static CommandTurnLeft getInstance(GameWorld gw)
	{
		if(left==null)
		{
			left = new CommandTurnLeft(gw);
		}
		return left;
	}
	
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.turnLeft();
	}
}
