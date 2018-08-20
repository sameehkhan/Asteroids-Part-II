package com.mycompany.a3;

public interface IGameWorld {
	public int getMissiles();
	public int getClock();
	public int getScore();
	public boolean getSoundOn();
	public void printMap();
	public gameCollection getGameObjects();
	public int getLives();
}
