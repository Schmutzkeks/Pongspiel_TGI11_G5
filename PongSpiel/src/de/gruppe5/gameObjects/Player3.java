package de.gruppe5.gameObjects;

import de.gruppe5.game.GameLogic;
import de.gruppe5.game.Vector2;

public class Player3 {
	public static Vector2 velocity;
	public static BeweglichesRechteck player03;
	
	public Player3(double spX, double spY) {
		Player3.velocity = new Vector2(spX, spY);
	}
	
	public Player3(BeweglichesRechteck obj1, double spX, double spY) {
		Player3.velocity = new Vector2(spX, spY);
		Player3.player03 = obj1;
	}
    public void setSpeed(double spX, double spY) {
    	Player3.velocity.setXMax(spX);
    	Player3.velocity.setYMax(spY);
    }
    
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += Player3.velocity.getXCur() * x;
			obj1.positionY += Player3.velocity.getYCur() * y;
		}
	}
	
	public void TVector22(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += x;
			obj1.positionY += y;
		}
	}

	public double getX() {
		return Player3.velocity.getXCur();
	}
	
	public double getY() {
		return Player3.velocity.getYCur();
	}
	
	public void setX(double spX) {
		Player3.velocity.setXCur(spX);
	}
	
	public void setY(double spY) {
		Player3.velocity.setYCur(spY);
	}
	
	public static BeweglichesRechteck setRechteck() {
		player03 = new BeweglichesRechteck(50, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		return player03;
	}
}
