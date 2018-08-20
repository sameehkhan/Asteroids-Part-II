package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandDecreaseShip extends Command{
private static GameWorld game; 
private static CommandDecreaseShip ds;
private GameWorld gw;
	public CommandDecreaseShip(GameWorld gw)
	{
		super("Decrease Ship");
		this.gw=gw;
	}
	
	public static CommandDecreaseShip getInstance(GameWorld gw)
	{
		if(ds==null)
		{
			ds= new CommandDecreaseShip(gw);
		}
		return ds;
	}
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.DecreamentShip();
	}
}
