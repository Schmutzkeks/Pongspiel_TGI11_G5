package de.demoncore.gameObjects;

import de.demoncore.game.GameLogic;
import de.demoncore.game.Vector2;

public class Ball {
	public static Vector2 velocity;
	private BeweglichesRechteck ballRechteck;

	public Ball(double spX, double spY) {
		System.out.println("new Ball");
		Ball.velocity = new Vector2(spX, spY);
	}
	
	public Ball(BeweglichesRechteck obj1, double spX, double spY) {
		Ball.velocity = new Vector2(spX, spY);
		this.ballRechteck = obj1;
	}
	
    public void setSpeed(double spX, double spY) {
    	Ball.velocity.setX(spX);
    	Ball.velocity.setY(spY);
    }
    
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += Ball.velocity.getX() * x;
			obj1.positionY += Ball.velocity.getY() * y;
		}
	}
	
	public void TVector22(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += x;
			obj1.positionY += y;
		}
	}
	
	public double getX() {
		System.out.println("Ball getX");
		return Ball.velocity.getX();
	}
	
	public double getY() {
		System.out.println("Ball getY");
		return Ball.velocity.getY();
	}
	
	public void setX(double spX) {
		System.out.println("Ball setX");
		Ball.velocity.setX(spX);
	}
	
	public void setY(double spY) {
		System.out.println("Ball setY");
		Ball.velocity.setY(spY);
	}
}
