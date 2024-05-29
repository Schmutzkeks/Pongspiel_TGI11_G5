package de.demoncore.game;

import de.demoncore.gameObjects.BeweglichesRechteck;

public class Gamelogic2 {
	
	
	int velX = BeweglichesRechteck.velX;
	int velY = BeweglichesRechteck.velY;
	
	public void CollisionLeftRight(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		BeweglichesRechteck.velX = BeweglichesRechteck.velX * (-1);


	}
	
	public void CollisionTopBottom(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		BeweglichesRechteck.velY = BeweglichesRechteck.velY * (-1);


	}
/*
	public boolean isCollidingLeftRight(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		return obj1.positionX < obj2.positionX + 20 &&
				obj1.positionX + 20 > obj2.positionX &&
				obj1.positionY < obj2.positionY + 80 &&
				obj1.positionY + 20 > obj2.positionY;

	}
	public boolean isCollidingTopBottom(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		return obj1.positionX < obj2.positionX + 20 &&
				obj1.positionX + 20 > obj2.positionX &&
				obj1.positionY < obj2.positionY + 80 &&
				obj1.positionY + 20 > obj2.positionY;

	}
	*/
	
	
	public boolean isCollidingLeftRight(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
	    // Check if the vertical ranges overlap
	    boolean verticalOverlap = (obj1.positionY < obj2.positionY + 80) && (obj1.positionY + 20> obj2.positionY);
	    
	    // Check if the horizontal edges touch or overlap 
	    boolean horizontalTouch = (obj1.positionX + 20 == obj2.positionX) || (obj1.positionX == obj2.positionX + 20);
	    boolean movingTowards = (BeweglichesRechteck.velX > 0 && obj1.positionX < obj2.positionX) || (BeweglichesRechteck.velX < 0 && obj1.positionX > obj2.positionX);
	    
	    
	    return verticalOverlap && horizontalTouch && movingTowards;
	}
	
	public boolean isCollidingTopBottom(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		
	    // Check if the horizontal ranges overlap
	    boolean horizontalOverlap = (obj1.positionX < obj2.positionX + 20) && (obj1.positionX + 20 > obj2.positionX);
	    
	    // Check if the vertical edges touch or overlap
	    boolean verticalTouch = (obj1.positionY + 20 == obj2.positionY) || (obj1.positionY == obj2.positionY + 80);
	    
	    System.out.println("Vertica  " + verticalTouch);
	    System.out.println("Horizo   " +horizontalOverlap);

	    
	    return horizontalOverlap && verticalTouch;
	}
	
}
