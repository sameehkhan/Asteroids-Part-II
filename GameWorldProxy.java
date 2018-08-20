package com.mycompany.a3;
import java.util.Observable;
public class GameWorldProxy extends Observable implements IGameWorld{

		private GameWorld game;
		
		public GameWorldProxy(GameWorld gw)
		{
			game=gw;
		}

		public int getClock()
		{
			return game.getClock();
		}
		
		public int getScore()
		{
			return game.getScore();
		}
		
		public boolean getSoundOn()
		{
			return game.getSoundOn();
		}
		public void printMap()
		{
			game.printMap();
		}

		public int getMissiles() {
			// TODO Auto-generated method stub
			return game.getMissiles();
		}


		public gameCollection getGameObjects() {
			// TODO Auto-generated method stub
			return game.getGameObjects();
		}


		public int getLives() {
			// TODO Auto-generated method stub
			return game.getLives();
		}

		
}
