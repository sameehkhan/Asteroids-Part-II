package com.mycompany.a3;
import com.codename1.ui.Command;
import com.codename1.ui.util.UITimer;
import com.codename1.ui.CheckBox;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.util.*;
import com.codename1.ui.Container;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.layouts.Layout;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import java.util.*;


public class Game extends Form implements Runnable
{
	private UITimer t;
	private MapView mv;
	private PointsView pv;
	private static int mapWidth;
	private static int mapHeight;
	private GameWorld gw;
	public Game() 
	{
		gw = new GameWorld();
		mv = new MapView();
		pv = new PointsView();
		gw.addObserver(mv);
		gw.addObserver(pv);
		setLayout(new BorderLayout());
		
		Container top = new Container();
		top.setLayout(new FlowLayout());
		top = FlowLayout.encloseCenter(pv);
		this.add(BorderLayout.NORTH,top);
		
		Container map = new Container();
		
	
	Container c = new Container();
		c.setLayout(new BoxLayout(BoxLayout.Y_AXIS));
		c.getAllStyles().setBorder(Border.createLineBorder(1));
		this.add(BorderLayout.WEST,c);
		
	Container center = new Container();
		center.getAllStyles().setBorder(Border.createLineBorder(4,ColorUtil.BLACK));
		center.getAllStyles().setBgTransparency(255);
		center.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		//center.add(mv);
		//this.add(BorderLayout.CENTER, center);
		this.add(BorderLayout.CENTER, mv);
	//south
		
	Container south = new Container();
		south.setLayout(new FlowLayout());
		Button tick = new Button("Tick Clock");
		tick.getAllStyles().setBgTransparency(255);
		tick.getUnselectedStyle().setBgColor(ColorUtil.rgb(150, 0, 150));
		tick.getAllStyles().setFgColor(ColorUtil.rgb(255, 255, 255));
		tick.setCommand(CommandTick.getInstance(gw));
		tick.getAllStyles().setPadding(TOP, 5);
		tick.getAllStyles().setPadding(BOTTOM, 5);
		
	Container temps = new Container();
			temps.setLayout(new FlowLayout());
			temps.add(tick);
			
		south = FlowLayout.encloseCenterMiddle(temps);
		south.getAllStyles().setBorder(Border.createLineBorder(4, ColorUtil.rgb(0, 0, 0)));
		this.add(BorderLayout.SOUTH, south);

		Toolbar sideMenuToolbar = new Toolbar();
		sideMenuToolbar.getAllStyles().setPadding(0,0,0,200);
		sideMenuToolbar.getAllStyles().setFgColor(ColorUtil.BLACK);
		sideMenuToolbar.getAllStyles().setBgColor(ColorUtil.WHITE);
		setToolBar(sideMenuToolbar);
		
		CheckBox sound = new CheckBox("Turn sound ON/OFF");
		sideMenuToolbar.addComponentToSideMenu(sound);
		sideMenuToolbar.setTitle("Asteroid Game");
		sound.setCommand(SoundCommand.getInstance(gw));
		sound.getAllStyles().setBgTransparency(255);
		sideMenuToolbar.setTitleCentered(true);
		
		Command about = new CommandAbout(gw);
		Button sideAbout = new Button("About");
			sideAbout.setCommand(about);
			sideMenuToolbar.addComponentToSideMenu(sideAbout);
			sideAbout.getAllStyles().setBgTransparency(255);
		
		Button sideAsteroid = new Button("Add Asteroid");
			sideAsteroid.setCommand(CommandAddAsteroid.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideAsteroid);
			sideAsteroid.getAllStyles().setBgTransparency(255);
			
		Button sideShip = new Button("Add Ship");
			sideShip.setCommand(CommandAddShip.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideShip);
			sideShip.getAllStyles().setBgTransparency(255);
			
		Button sideSpaceStation = new Button("Add Space Station");
			sideSpaceStation.setCommand(CommandAddSpaceStation.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideSpaceStation);
			sideSpaceStation.getAllStyles().setBgTransparency(255);
			
		Button sideIncrease = new Button("Increase Ship");
			sideIncrease.setCommand(CommandIncreaseShip.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideIncrease);
			sideIncrease.getAllStyles().setBgTransparency(255);
			
		Button sideDecrease = new Button("Decrease Ship");
			sideDecrease.setCommand(CommandDecreaseShip.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideDecrease);
			sideDecrease.getAllStyles().setBgTransparency(255);
			
		Button sideLeftTurn = new Button("Turn Left");
			sideLeftTurn.setCommand(CommandTurnLeft.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideLeftTurn);
			sideLeftTurn.getAllStyles().setBgTransparency(255);
			
		Button sideRightTurn = new Button("Turn Right");
			sideRightTurn.setCommand(CommandTurnRight.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideRightTurn);
			sideRightTurn.getAllStyles().setBgTransparency(255);
			
		Button sideFire = new Button("Fire");
			sideFire.setCommand(CommandFireMissiles.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideFire);
			sideFire.getAllStyles().setBgTransparency(255);
			
		Button sideHyperJump = new Button("Jump");
			sideHyperJump.setCommand(CommandHyperJump.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideHyperJump);
			sideHyperJump.getAllStyles().setBgTransparency(255);
			
		Button sideLoadShip = new Button("Load Ship");
			sideLoadShip.setCommand(CommandLoadMissiles.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideLoadShip);
			sideLoadShip.getAllStyles().setBgTransparency(255);
			
		Button sideKillAsteroid = new Button("Kill Asteroid");
			sideKillAsteroid.setCommand(CommandKillAsteroid.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideKillAsteroid);
			sideKillAsteroid.getAllStyles().setBgTransparency(255);
			
		Button sideCrashShip = new Button("Crash Ship");
			sideCrashShip.setCommand(CommandCrashShip.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideCrashShip);
			sideCrashShip.getAllStyles().setBgTransparency(255);
			
		Button sideExterminate = new Button("Exterminate");
			sideExterminate.setCommand(CommandExterminate.getInstance(gw));
			sideMenuToolbar.addComponentToSideMenu(sideExterminate);
			sideExterminate.getAllStyles().setBgTransparency(255);
			
			
			Command q = new CommandQuit(gw);
			
		Button sideQuit = new Button ("Quit");
			sideQuit.setCommand(q);
			sideMenuToolbar.addComponentToSideMenu(sideQuit);
			sideQuit.getAllStyles().setBgTransparency(255);
		
			addKeyListener('a', CommandAddAsteroid.getInstance(gw));
			addKeyListener('b',CommandAddSpaceStation.getInstance(gw));
			addKeyListener('s',CommandAddShip.getInstance(gw));
			addKeyListener('i',CommandIncreaseShip.getInstance(gw));
			addKeyListener('d',CommandDecreaseShip.getInstance(gw));
			addKeyListener('l',CommandTurnLeft.getInstance(gw));
			addKeyListener('r',CommandTurnRight.getInstance(gw));
			addKeyListener('f',CommandFireMissiles.getInstance(gw));
			addKeyListener('j',CommandHyperJump.getInstance(gw));
			addKeyListener('n',CommandLoadMissiles.getInstance(gw));
			addKeyListener('k',CommandKillAsteroid.getInstance(gw));
			addKeyListener('c',CommandCrashShip.getInstance(gw));
			addKeyListener('x',CommandExterminate.getInstance(gw));
			addKeyListener('t',CommandTick.getInstance(gw));
			addKeyListener('q',q);
			t = new UITimer(this);
			t.schedule(30, true, this);
			
			this.show();
			mapWidth = mv.getWidth();
			mapHeight = mv.getHeight();
			gw.setMapHeight(mapHeight);
			gw.setMapWidth(mapWidth);
			System.out.println(mv.getWidth());
			System.out.println(mv.getHeight());
			gw.updateWorld();
			
	}
	public void run() {
		// TODO Auto-generated method stub
		gw.gameClock();
	} 
	
}
