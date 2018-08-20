package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandIncreaseShip extends Command {
private static GameWorld game;
private static CommandIncreaseShip inc;
private GameWorld gw;
	public CommandIncreaseShip(GameWorld gw)
	{
		super("Increase ship");
		this.gw=gw;
	}
	
	public static CommandIncreaseShip getInstance(GameWorld gw)
	{
		if(inc==null)
		{
			inc = new CommandIncreaseShip(gw);
		}
		return inc;
	}
	
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.IncreamentShip();
	}
}
