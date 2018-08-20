package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandTurnRight extends Command{
	private static GameWorld game;
	private static CommandTurnRight right;
	private GameWorld gw;
	public CommandTurnRight(GameWorld gw)
	{
		super("Turn Right");
		this.gw=gw;
	}
	
	public static CommandTurnRight getInstance(GameWorld gw)
	{
		if(right==null)
			right= new CommandTurnRight(gw);
		return right;
	}
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.turnRight();
	}
}
