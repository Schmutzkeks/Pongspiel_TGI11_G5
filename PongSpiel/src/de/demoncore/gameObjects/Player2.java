package de.demoncore.gameObjects;

import de.demoncore.game.GameLogic;
import de.demoncore.game.Vector2;

public class Player2 {
	public static Vector2 velocity;
	private BeweglichesRechteck playeRechteck;
	

	public Player2(double spX, double spY) {
		Player2.velocity = new Vector2(spX, spY);
	}
	
	public Player2(BeweglichesRechteck obj1, double spX, double spY) {
		Player2.velocity = new Vector2(spX, spY);
		this.playeRechteck = obj1;
	}
    public void setSpeed(double spX, double spY) {
        velocity.setX(spX);
    }
    
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += velocity.getX() * x;
			obj1.positionY += velocity.getY() * y;
		}
	}
	
	public void TVector22(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += x;
			obj1.positionY += y;
		}
	}

	public double getX() {
		return velocity.getX();
	}
	
	public double getY() {
		return velocity.getY();
	}
	
	public void setX(double spX) {
        velocity.setX(spX);
	}
	
	public void setY(double spY) {
        velocity.setY(spY);
	}
}
