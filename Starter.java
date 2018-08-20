package com.mycompany.a3;


import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Dialog;
import com.codename1.ui.Label;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.codename1.io.Log;
import com.codename1.ui.Toolbar;
import java.io.IOException;

public class Starter{
	private Form current;
    private Resources theme;
	private Display display;

    public void init(Object context) {
        theme = UIManager.initFirstTheme("/theme");

        Toolbar.setGlobalToolbar(true);

       
	
    }
    
    public void start() {
        if(current != null){
            current.show();
            return;
        }
        new Game();
        
        //Form hi = new Form("Hi World");
       // hi.addComponent(new Label("Hi World"));
        //hi.show();
    }


    public void stop() {
        current = Display.getInstance().getCurrent();
        if(current instanceof Dialog) {
            ((Dialog)current).dispose();
            current = Display.getInstance().getCurrent();
        }
    }
    
    public void destroy() {
    }

}
