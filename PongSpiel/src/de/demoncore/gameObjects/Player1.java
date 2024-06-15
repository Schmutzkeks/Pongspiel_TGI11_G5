package de.demoncore.gameObjects;

import de.demoncore.game.GameLogic;
import de.demoncore.game.Vector2;

public class Player1 {
	public static Vector2 velocity;
	private BeweglichesRechteck playeRechteck;
	
	public Player1(double spX, double spY) {
		Player1.velocity = new Vector2(spX, spY);
	}
	
	public Player1(BeweglichesRechteck obj1, double spX, double spY) {
		Player1.velocity = new Vector2(spX, spY);
		this.playeRechteck = obj1;
	}
    public void setSpeed(double spX, double spY) {
    	Player1.velocity.setX(spX);
    	Player1.velocity.setY(spY);
    }
    
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += Player1.velocity.getX() * x;
			obj1.positionY += Player1.velocity.getY() * y;
		}
	}
	
	public void TVector22(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += x;
			obj1.positionY += y;
		}
	}

	public double getX() {
		return Player1.velocity.getX();
	}
	
	public double getY() {
		return Player1.velocity.getY();
	}
	
	public void setX(double spX) {
		Player1.velocity.setX(spX);
	}
	
	public void setY(double spY) {
		Player1.velocity.setY(spY);
	}
}
