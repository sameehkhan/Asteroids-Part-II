package com.mycompany.a3;
import com.codename1.ui.Container;
import com.codename1.ui.Label;
import java.util.Observable;
import java.util.Observer;
import com.codename1.charts.util.ColorUtil;
public class PointsView extends Container implements Observer{
	private Label score;
	private Label scoreData;
	private Label livesLeft;
	private Label time;
	private Label timeValue;
	private Label missiles;
	private Label missileV;
	private Label sound;
	private Label soundV;
	private Label lives;
	public PointsView()
	{
		lives = new Label("Lives left: ");
		score = new Label("Score: ");
		time = new Label("Time: ");
		missiles = new Label("Missile Count: ");
		sound = new Label("Sound: ");
		
		livesLeft = new Label("XXX");
		scoreData = new Label("XXX");
		timeValue = new Label("XXX");
		missileV = new Label("XXX");
		soundV = new Label("XXX");
		
		time.getAllStyles().setFgColor(ColorUtil.BLUE);
		timeValue.getAllStyles().setFgColor(ColorUtil.BLUE);
		timeValue.getAllStyles().setPadding(1, 1,1,5);
		
		score.getAllStyles().setFgColor(ColorUtil.BLUE);
		scoreData.getAllStyles().setFgColor(ColorUtil.BLUE);
		scoreData.getAllStyles().setPadding(1, 1,1,5);
		
		lives.getAllStyles().setFgColor(ColorUtil.BLUE);
		livesLeft.getAllStyles().setFgColor(ColorUtil.BLUE);
		livesLeft.getAllStyles().setPadding(1,1,1,5);
		
		sound.getAllStyles().setFgColor(ColorUtil.BLUE);
		soundV.getAllStyles().setFgColor(ColorUtil.BLUE);
		
		missiles.getAllStyles().setFgColor(ColorUtil.BLUE);
		missileV.getAllStyles().setFgColor(ColorUtil.BLUE);
		missileV.getAllStyles().setPadding(1,1,1,5);
		
		add(score);
		add(scoreData);
		add(time);
		add(timeValue);
		add(lives);
		add(livesLeft);
        add(missiles);
        add(missileV);
		add(sound);
        add(soundV);
		/*score.getAllStyles().setPadding(1, 1,1,1);
		score.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		
		value.getAllStyles().setPadding(1, 1,5,1);
		time.getAllStyles().setPadding(1, 1,1,1);
		timeValue.getAllStyles().setPadding(1, 1,5,1);
		m.getAllStyles().setPadding(1, 1,1,1);
		missileV.getAllStyles().setPadding(1, 1,5,1);
		sound.getAllStyles().setPadding(1, 1,1,1);
		soundV.getAllStyles().setPadding(1, 1,1,1);
		
		
		time.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		m.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		sound.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
	
		timeValue.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		missileV.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		soundV.getAllStyles().setFgColor(ColorUtil.rgb(0, 0, 255));
		Container playerScore = new Container();
		
		playerScore.add(score);
		playerScore.add(value);
		
		
		this.add(time);
		this.add(timeValue);
		this.add(m);
		this.add(missileV);
		this.add(sound);
		this.add(soundV);*/
	}

	public void update(Observable o, Object j) {
		// TODO Auto-generated method stub
		/*IGameWorld gw = (IGameWorld)o;
		
		int mcount = ((IGameWorld)o).getMissiles();
		int currTime = ((IGameWorld)o).getClock();
		int currscore = ((IGameWorld)o).getScore();
		
		missileV.setText(Integer.toString(mcount));
		timeValue.setText(Integer.toString(currTime));
		value.setText(Integer.toString(currscore));
		
		
		if(gw.getSoundOn()==true)
		{
			soundV.setText("ON");
		}
		else{
			soundV.setText("OFF");
		}
		
	}*/
		
		IGameWorld gameWorld = (IGameWorld)o;
		timeValue.setText(String.valueOf(gameWorld.getClock()));
		timeValue.getParent().revalidate();

		livesLeft.setText(String.valueOf(gameWorld.getLives()));
		livesLeft.getParent().revalidate();

		missileV.setText(String.valueOf(gameWorld.getMissiles()));
		missileV.getParent().revalidate();

		scoreData.setText(String.valueOf(gameWorld.getScore()));
		scoreData.getParent().revalidate();

		if(gameWorld.getSoundOn() == false){
			soundV.setText("OFF");
		}
		else{
			soundV.setText("ON");
		}
		soundV.getParent().revalidate();

	
		
		
}
}
