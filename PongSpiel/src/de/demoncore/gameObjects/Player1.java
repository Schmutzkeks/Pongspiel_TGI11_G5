package de.demoncore.gameObjects;

import de.demoncore.game.Vector2;

public class Player1 {
	private Vector2 velocity;
	
	
	public Player1(BeweglichesRechteck obj1, double spX, double spY) {
		this.velocity = new Vector2(spX, spY);
	}
    public void setSpeed(double spX, double spY) {
        velocity.setX(spX);
        velocity.setY(spY);
    }
}
