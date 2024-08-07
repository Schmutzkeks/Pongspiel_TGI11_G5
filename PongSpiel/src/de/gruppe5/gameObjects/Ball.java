package de.gruppe5.gameObjects;

import de.gruppe5.game.GameLogic;
import de.gruppe5.game.Vector2;

public class Ball {
	public static Vector2 velocity;
	public static BeweglichesRechteck Ball01;

	public Ball(double spX, double spY) {
		Ball.velocity = new Vector2(spX, spY);
	}
	
	public Ball(BeweglichesRechteck obj1, double spX, double spY) {
		Ball.velocity = new Vector2(spX, spY);
		Ball.Ball01 = obj1;
	}
    public void setSpeed(double spX, double spY) {
    	Ball.velocity.setXMax(spX);
    	Ball.velocity.setYMax(spY);
    }
    
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += Ball.velocity.getXCur() * x;
			obj1.positionY += Ball.velocity.getYCur() * y;
		}
	}
	
	public void TVector22(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += x;
			obj1.positionY += y;
		}
	}
	
	public double getX() {
		return Ball.velocity.getXCur();
	}
	
	public double getY() {
		return Ball.velocity.getYCur();
	}
	
	public void setX(double spX) {
		Ball.velocity.setXCur(spX);
	}
	
	public void setY(double spY) {
		Ball.velocity.setYCur(spY);
	}
	public static BeweglichesRechteck setRechteck() {
		Ball01 = new BeweglichesRechteck(393, 240, 20, 20);		//(posX, posY, breite, hoehe) 
		return Ball01;
	}

}
