package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandAddSpaceStation extends Command {
	private static GameWorld game;
	private static CommandAddSpaceStation ss;
	private GameWorld gw;
	public CommandAddSpaceStation(GameWorld gw)
	{
		super("Add Space Station");
		this.gw=gw;
	}
	public static CommandAddSpaceStation getInstance(GameWorld gw)
	{
		if(ss==null)
		{
			ss = new CommandAddSpaceStation(gw);
		}
		return ss;
	}
	 
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.AddSpaceStation();
	}

}
