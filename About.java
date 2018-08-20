package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
public class About  extends Form{
	public About()
	{
		this.setTitle("About");
		this.getAllStyles().setPadding(1, 1,25,25);
		Command k = new Command("Ok");
		Label creator = new Label("Created by: Sameeh Khan");
		Label cs = new Label("For CSC133");
		Container body = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		body.add(creator);
		body.add(cs);
		Dialog.show("About", body, k);
	}
	
	
	
}
