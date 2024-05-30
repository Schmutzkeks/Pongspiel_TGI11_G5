package de.demoncore.game;

public class Vector2{
	double x;
	double y;

	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2 speed(double speed) {
		return new Vector2(x * speed, y * speed);
	}
} 
