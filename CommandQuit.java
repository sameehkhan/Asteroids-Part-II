package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandQuit extends Command{
	private static GameWorld gw;
	public static CommandQuit commandQ;
	public CommandQuit(GameWorld gw)
	{
		super("Quit");
		this.gw=gw;
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		gw.quitCommand();
	}
}
