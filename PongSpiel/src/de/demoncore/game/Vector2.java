package de.demoncore.game;

import de.demoncore.gameObjects.BeweglichesRechteck;

public class Vector2{
	public double x;
	public double y;
	
	

	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		obj1.positionX += x;
		obj1.positionY += y;
	}
	
	public Vector2 speed(double speed) {
		return new Vector2(x * speed, y * speed);
	}
} 
