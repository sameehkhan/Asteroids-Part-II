package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.events.ActionEvent;
public class SoundCommand extends Command{
	private GameWorld gw;
	private static SoundCommand sound;
	public SoundCommand(GameWorld gw)
	{
		super("Sound Check");
		this.gw=gw;
	}
	public static SoundCommand getInstance(GameWorld gw)
	{
		if(sound == null)
			sound = new SoundCommand(gw);
		return sound;
	}
	public void actionPerformed(ActionEvent event)
	{
		if(gw.getSoundOn()==false)
		{
			gw.setSoundOn(true);
		}
		else{
			gw.setSoundOn(false);
		}
	}

}
