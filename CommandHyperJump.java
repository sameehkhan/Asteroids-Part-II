package com.mycompany.a3;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Command;
public class CommandHyperJump extends Command {
	private static CommandHyperJump jump;
	private static GameWorld game;
	private GameWorld gw;
	public CommandHyperJump(GameWorld gw)
	{
		super("Jump");
		this.gw=gw;
	}
	
	public static CommandHyperJump getInstance(GameWorld gw)
	{
		if(jump==null)
			jump=new CommandHyperJump(gw);
		return jump;
	}
	public static void setPlace(GameWorld gw)
	{
		if(game ==null)
			game = gw;
	}
	public void actionPerformed(ActionEvent event)
	{
		gw.jumpHyper();
	}
}
