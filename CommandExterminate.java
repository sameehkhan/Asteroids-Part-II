package com.mycompany.a3;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;
public class CommandExterminate extends Command {
	private static GameWorld game;
	private static CommandExterminate ex;
	private GameWorld gw;
	public CommandExterminate(GameWorld gw)
	{
		super("Exterminate");
		this.gw=gw;
	}
	
	public static CommandExterminate getInstance(GameWorld gw)
	{
		if(ex==null)
			ex = new CommandExterminate(gw);
		return ex;
	}
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.asteroidsCollide();
	}
}
