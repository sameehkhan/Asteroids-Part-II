package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class CommandAbout extends Command {
	private GameWorld gw;
	public CommandAbout(GameWorld gw)
	{
		super("About");
		this.gw=gw;
	} 
	public void actionPerformed(ActionEvent e)
	{
		gw.commandAbout();
	}
}
