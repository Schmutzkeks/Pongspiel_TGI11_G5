package de.demoncore.game;

import de.demoncore.gameObjects.Ball;
import de.demoncore.gameObjects.BeweglichesRechteck;

public class Vector2{
	private double xCur;	//currentSpeed
	private double yCur;	//currentSpeed
	private double xMax;	//maxSpeed
	private double yMax;	//maxSpeed
	private double acc = 0.05; // acceleration
	
	

	public Vector2() {
		this.setXCur(0);
		this.setYCur(0);
	}
	public Vector2(double x, double y) {
		this.xCur = x;
		this.yCur = y;
	}
	public void TVector2(BeweglichesRechteck obj1, double x, double y) {
		if(GameLogic.BallContinue) {
			obj1.positionX += x;
			obj1.positionY += y;
		}
	}
	
	public void speedMult(double speed) {
		this.xCur = getXCur() * speed;
		this.yCur = getYCur() * speed;
		if (this.xCur > xMax && this.yCur > yMax) {
			this.xCur = xMax;
			this.yCur = yMax;
		}
	}
	
	public void speedAdd(double speed) {
	    if (this.xCur > 0) {
	        this.xCur = getXCur() + speed;
	    } else if (this.xCur < 0) {
	        this.xCur = getXCur() - speed;
	    }

	    if (this.yCur > 0) {
	        this.yCur = getYCur() + speed;
	    } else if (this.yCur < 0) {
	        this.yCur = getYCur() - speed;
	    }

	    if (Math.abs(this.xCur) > xMax) {
	        this.xCur = xMax * Math.signum(this.xCur);  // Example:  Math.signum(-3.0) = -1.0 ; Math.signum(5.0) = 1.0 ; Math.signum(0.0) = 0.0
	    }
	    if (Math.abs(this.yCur) > yMax) {
	        this.yCur = yMax * Math.signum(this.yCur);
	    }
	}
	
	public static double moveTowards(double current, double target, double maxDelta) {
	    if (current < target) {
	        return Math.min(current + maxDelta, target);
	    } else if (current > target) {
	        return Math.max(current - maxDelta, target);
	    } else {
	        return current;
	    }
	}
	
	
	public double getYCur() {
		return yCur;
	}
	public void setYCur(double y) {
		this.yCur = y;
	}
	public double getXCur() {
		return xCur;
	}
	public void setXCur(double x) {
		this.xCur = x;
	}
	public double getAcc() {
		return acc;
	}
	public void setAcc(double acceleration) {
		this.acc = acceleration;
	}
	public double getXMax() {
		return xMax;
	}
	public void setXMax(double xMax) {
		this.xMax = xMax;
	}
	public double getYMax() {
		return yMax;
	}
	public void setYMax(double yMax) {
		this.yMax = yMax;
	}
} 
