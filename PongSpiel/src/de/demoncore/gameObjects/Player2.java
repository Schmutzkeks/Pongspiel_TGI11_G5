package de.demoncore.gameObjects;

import de.demoncore.game.GameLogic;
import de.demoncore.game.Vector2;

public class Player2 {
	public static Vector2 velocity;
	public static BeweglichesRechteck player02;
	
	public Player2(double spX, double spY) {
		Player2.velocity = new Vector2(spX, spY);
	}
	
	public Player2(BeweglichesRechteck obj1, double spX, double spY) {
		Player2.velocity = new Vector2(spX, spY);
		Player2.player02 = obj1;
	}
    public void setSpeed(double spX, double spY) {
    	Player2.velocity.setXMax(spX);
    	Player2.velocity.setYMax(spY);
    }
    
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += Player2.velocity.getXCur() * x;
			obj1.positionY += Player2.velocity.getYCur() * y;
		}
	}
	
	public void TVector22(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += x;
			obj1.positionY += y;
		}
	}

	public double getX() {
		return Player2.velocity.getXCur();
	}
	
	public double getY() {
		return Player2.velocity.getYCur();
	}
	
	public void setX(double spX) {
		Player2.velocity.setXCur(spX);
	}
	
	public void setY(double spY) {
		Player2.velocity.setYCur(spY);
	}
	
	public static BeweglichesRechteck setRechteck() {
		player02 = new BeweglichesRechteck(50, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		return player02;
	}
}
