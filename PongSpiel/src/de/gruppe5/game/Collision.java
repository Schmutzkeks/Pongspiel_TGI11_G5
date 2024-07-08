package de.gruppe5.game;

import de.gruppe5.gameObjects.Ball;
import de.gruppe5.gameObjects.BeweglichesRechteck;
import de.gruppe5.gui.Gui;
import de.gruppe5.gui.Shop;

public class Collision {
	public Points punkte = new Points();



	public void CollisionLeftRight(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		Ball.velocity.setXCur(Ball.velocity.getXCur() * (-1));
		Ball.velocity.speedAdd(0.05);
		MusicPlayer.playSound(2, false);
		
	}

	public void CollisionTopBottom(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		Ball.velocity.setYCur(Ball.velocity.getYCur() * (-1));
		MusicPlayer.playSound(2, false);
	}




	public boolean isCollidingLeftRight(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if(!obj1.istAktiviert || !obj2.istAktiviert) return false;
		
		
		
        // Check if the vertical ranges overlap
        boolean verticalOverlap = (obj1.positionY < obj2.positionY + obj2.groesseY) && (obj1.positionY + obj1.groesseY > obj2.positionY);

        // Check if the horizontal edges touch or overlap, considering the velocity
        boolean horizontalOverlap = (obj1.positionX + obj1.groesseX + Math.abs(Ball.velocity.getXCur()) >= obj2.positionX) &&
                                    (obj1.positionX <= obj2.positionX + obj2.groesseX + Math.abs(Ball.velocity.getXCur()));

        // Ensure that obj1 is moving towards obj2
        boolean movingTowards = (Ball.velocity.getXCur() > 0 && obj1.positionX < obj2.positionX) || (Ball.velocity.getXCur() < 0 && obj1.positionX > obj2.positionX);

        return verticalOverlap && horizontalOverlap && movingTowards;
	}

	public boolean isCollidingTopBottom(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if(!obj1.istAktiviert || !obj2.istAktiviert) return false;
		

        // Check if the horizontal ranges overlap
        boolean horizontalOverlap = (obj1.positionX < obj2.positionX + obj2.groesseX) && (obj1.positionX + obj1.groesseX > obj2.positionX);

        // Check if the vertical edges touch or overlap, considering the velocity
        boolean verticalOverlap = (obj1.positionY + obj1.groesseY + Math.abs(Ball.velocity.getYCur()) >= obj2.positionY) &&
                                  (obj1.positionY <= obj2.positionY + obj2.groesseY + Math.abs(Ball.velocity.getYCur()));

        // Ensure that obj1 is moving towards obj2
        boolean movingTowards = (Ball.velocity.getYCur() > 0 && obj1.positionY < obj2.positionY) || (Ball.velocity.getYCur() < 0 && obj1.positionY > obj2.positionY);

        return horizontalOverlap && verticalOverlap && movingTowards;
		
		
	}

	
	public void Collisionwall(BeweglichesRechteck obj1) {
		
	    if (obj1.positionX <= 0 || obj1.positionX >= 786 - 20) {
	        if (Ball.velocity.getXCur() > 0 && Ball.velocity.getYCur() > 0) {
	            Ball.velocity.setXCur(Ball.velocity.getXCur() * (-1));
	            punkte.addPunkteGegner(1);
	            GameLogic.createParticles(30);
	            GameLogic.pauseBall();
	            MusicPlayer.playSound(3, false);
	        } else if (Ball.velocity.getXCur() > 0 && Ball.velocity.getYCur() < 0) {
	            Ball.velocity.setXCur(Ball.velocity.getXCur() * (-1));
	            punkte.addPunkteGegner(1);
	            GameLogic.createParticles(30);
	            GameLogic.pauseBall();
	            MusicPlayer.playSound(3, false);
	        } else if (Ball.velocity.getXCur() < 0 && Ball.velocity.getYCur() > 0) {
	            Ball.velocity.setXCur(Ball.velocity.getXCur() * (-1));
	            punkte.addPunktePlayer(Shop.getDoublePoints() ? 2 : 1);
	            GameLogic.createParticles(30);
	            GameLogic.pauseBall();
	            MusicPlayer.playSound(3, false);
	        } else if (Ball.velocity.getXCur() < 0 && Ball.velocity.getYCur() < 0) {
	            Ball.velocity.setXCur(Ball.velocity.getXCur() * (-1));
	            punkte.addPunktePlayer(Shop.getDoublePoints() ? 2 : 1);
	            GameLogic.createParticles(30);
	            GameLogic.pauseBall();
	            MusicPlayer.playSound(3, false);
	        }
	        Gui.punkteGegner = punkte.getPunkteGegner();
	        Gui.punktePlayer = punkte.getPunktePlayer();
	        Gui.refreshPoints();
	    }
	    if (obj1.positionY <= 0 || obj1.positionY >= 562 - 20) {
	        if (Ball.velocity.getXCur() > 0 && Ball.velocity.getYCur() > 0) {
	            Ball.velocity.setYCur(Ball.velocity.getYCur() * (-1));
	            MusicPlayer.playSound(2, false);
	        } else if (Ball.velocity.getXCur() > 0 && Ball.velocity.getYCur() < 0) {
	            Ball.velocity.setYCur(Ball.velocity.getYCur() * (-1));
	            MusicPlayer.playSound(2, false);
	        } else if (Ball.velocity.getXCur() < 0 && Ball.velocity.getYCur() > 0) {
	            Ball.velocity.setYCur(Ball.velocity.getYCur() * (-1));
	            MusicPlayer.playSound(2, false);
	        } else if (Ball.velocity.getXCur() < 0 && Ball.velocity.getYCur() < 0) {
	            Ball.velocity.setYCur(Ball.velocity.getYCur() * (-1));
	            MusicPlayer.playSound(2, false);
	        }
	    }
	}
	
	
	
	
/*
	public void Collisionwall(BeweglichesRechteck obj1) {
		if (obj1.positionX <= 0 || obj1.positionX >= 786 - 20) {
			if (BeweglichesRechteck.velX>0&&BeweglichesRechteck.velY>0) {BeweglichesRechteck.velX = BeweglichesRechteck.velX *(-1); punkte.addPunkteGegner(1);GameLogic.createParticles(30); GameLogic.pauseBall();}
			else if (BeweglichesRechteck.velX>0&&BeweglichesRechteck.velY<0) {BeweglichesRechteck.velX = BeweglichesRechteck.velX *(-1); punkte.addPunkteGegner(1); GameLogic.createParticles(30); GameLogic.pauseBall();}
			else if (BeweglichesRechteck.velX<0&&BeweglichesRechteck.velY>0) {BeweglichesRechteck.velX = BeweglichesRechteck.velX *(-1); punkte.addPunktePlayer(1); GameLogic.createParticles(30); GameLogic.pauseBall();}
			else if (BeweglichesRechteck.velX<0&&BeweglichesRechteck.velY<0) {BeweglichesRechteck.velX = BeweglichesRechteck.velX *(-1); punkte.addPunktePlayer(1); GameLogic.createParticles(30); GameLogic.pauseBall();}
			Gui.punkteGegner = punkte.getPunkteGegner();
			Gui.punktePlayer = punkte.getPunktePlayer();
			Gui.refreshPoints();
		}
		if (obj1.positionY <= 0 || obj1.positionY >= 562 - 20) {
			if (BeweglichesRechteck.velX>0&&BeweglichesRechteck.velY>0) BeweglichesRechteck.velY = BeweglichesRechteck.velY *(-1);
			else if (BeweglichesRechteck.velX>0&&BeweglichesRechteck.velY<0) BeweglichesRechteck.velY = BeweglichesRechteck.velY *(-1);
			else if (BeweglichesRechteck.velX<0&&BeweglichesRechteck.velY>0) BeweglichesRechteck.velY = BeweglichesRechteck.velY *(-1);
			else if (BeweglichesRechteck.velX<0&&BeweglichesRechteck.velY<0) BeweglichesRechteck.velY = BeweglichesRechteck.velY *(-1);
		}
	}*/
}
