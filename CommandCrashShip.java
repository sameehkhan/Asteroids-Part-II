package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;

public class CommandCrashShip extends Command{
	private static CommandCrashShip crash;
	private static GameWorld game;
	private GameWorld gw;
	public CommandCrashShip(GameWorld gw)
	{
		super("Crash Ship");
		this.gw=gw;
		
	}
	
	public static CommandCrashShip getInstance(GameWorld gw)
	{
		if(crash==null)
			crash = new CommandCrashShip(gw);
		return crash;
	}
	
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.shipCrashed();
		System.out.println("Ship crashed");
	}
}
