package com.mycompany.a3;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
public class ClosingMessage extends Form{
	public ClosingMessage()
	{
		this.setTitle("Closing");
		boolean k = Dialog.show("Confirm to quit", "Are you sure you want to quit?", "ok", "cancel");
		if(k)
			Display.getInstance().exitApplication(); 
	}
}
