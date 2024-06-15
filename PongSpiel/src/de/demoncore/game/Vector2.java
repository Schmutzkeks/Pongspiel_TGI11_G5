package de.demoncore.game;

import de.demoncore.gameObjects.Ball;
import de.demoncore.gameObjects.BeweglichesRechteck;

public class Vector2{
	private double x;
	private double y;
	
	

	public Vector2() {
		this.setX(0);
		this.setY(0);
	}
	public Vector2(double x, double y) {
		System.out.println("new Vector 2");
		this.x = x;
		this.y = y;
	}
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += x;
			obj1.positionY += y;
		}
	}
	
	public Vector2 speed(double speed) {
		System.out.println("Vector2 speed");
		return new Vector2(getX() * speed, getY() * speed);
	}
	
	
	public double getY() {
		return y;
	}
	public void setY(double y) {
		System.out.println("Vector2 setY");
		this.y = y;
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		System.out.println("Vector2 setX");
		this.x = x;
	}
} 
