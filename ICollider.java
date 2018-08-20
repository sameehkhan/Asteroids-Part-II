package com.mycompany.a3;

public interface ICollider {
	boolean collidesWith(GameObjects ob);
	void handleCollision(GameObjects ob, GameWorld gw);
}
