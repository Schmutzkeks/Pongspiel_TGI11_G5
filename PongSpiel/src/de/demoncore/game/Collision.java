package de.demoncore.game;

import de.demoncore.gameObjects.BeweglichesRechteck;
import de.demoncore.gui.Gui;

public class Collision {
	public Points punkte = new Points();




	public void CollisionLeftRight(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		BeweglichesRechteck.velX = BeweglichesRechteck.velX * (-1);
	}

	public void CollisionTopBottom(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		BeweglichesRechteck.velY = BeweglichesRechteck.velY * (-1);
	}




	public boolean isCollidingLeftRight(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if(!obj1.istAktiviert || !obj2.istAktiviert) return false;
		
		// Check if the vertical ranges overlap
		/*
		boolean verticalOverlap = (obj1.positionY < obj2.positionY + 80) && (obj1.positionY + 20> obj2.positionY);

		// Check if the horizontal edges touch or overlap 
		boolean horizontalTouch = (obj1.positionX + 20 == obj2.positionX) || (obj1.positionX == obj2.positionX + 20);
		boolean movingTowards = (BeweglichesRechteck.velX > 0 && obj1.positionX < obj2.positionX) || (BeweglichesRechteck.velX < 0 && obj1.positionX > obj2.positionX);

		return verticalOverlap && horizontalTouch && movingTowards;
		 */

		/*
		return obj1.positionY <= obj2.positionY + 80 &&
				obj1.positionY + 20 >= obj2.positionY &&
				obj1.positionX < obj2.positionX + 20 &&
				obj1.positionX + 20 > obj2.positionX;

		 */
		
		/*
        // Check if the vertical ranges overlap
        boolean verticalOverlap = (obj1.positionY < obj2.positionY + 80) && (obj1.positionY + 20 > obj2.positionY);

        // Check if the horizontal edges touch or overlap
        boolean horizontalTouch = (obj1.positionX + 20 == obj2.positionX) || (obj1.positionX == obj2.positionX + 20);
        
        // Ensure that obj1 is moving towards obj2
        boolean movingTowards = (BeweglichesRechteck.velX > 0 && obj1.positionX < obj2.positionX) || (BeweglichesRechteck.velX < 0 && obj1.positionX > obj2.positionX);

        return verticalOverlap && horizontalTouch && movingTowards;
*/
		
		
        // Check if the vertical ranges overlap
        boolean verticalOverlap = (obj1.positionY < obj2.positionY + 80) && (obj1.positionY + 20 > obj2.positionY);

        // Check if the horizontal edges touch or overlap, considering the velocity
        boolean horizontalOverlap = (obj1.positionX + 20 + Math.abs(BeweglichesRechteck.velX) >= obj2.positionX) &&
                                    (obj1.positionX <= obj2.positionX + 20 + Math.abs(BeweglichesRechteck.velX));

        // Ensure that obj1 is moving towards obj2
        boolean movingTowards = (BeweglichesRechteck.velX > 0 && obj1.positionX < obj2.positionX) || (BeweglichesRechteck.velX < 0 && obj1.positionX > obj2.positionX);

        return verticalOverlap && horizontalOverlap && movingTowards;
	}

	public boolean isCollidingTopBottom(BeweglichesRechteck obj1, BeweglichesRechteck obj2) {
		if(!obj1.istAktiviert || !obj2.istAktiviert) return false;
		
		/*
		// Check if the horizontal ranges overlap
		boolean horizontalOverlap = (obj1.positionX < obj2.positionX + 20) && (obj1.positionX + 20 > obj2.positionX);

		// Check if the vertical edges touch or overlap
		boolean verticalTouch = (obj1.positionY + 20 == obj2.positionY) || (obj1.positionY == obj2.positionY + 80);

		return horizontalOverlap && verticalTouch;

		 */

		/*
		return obj1.positionY <= obj2.positionY + 80 &&
				obj1.positionY + 20 >= obj2.positionY &&
				obj1.positionX < obj2.positionX + 20 &&
				obj1.positionX + 20 > obj2.positionX;

		 */
		
		/*
		// Check if the horizontal ranges overlap
		boolean horizontalOverlap = (obj1.positionX < obj2.positionX + 20) && (obj1.positionX + 20 > obj2.positionX);

		// Check if the vertical edges touch or overlap
		boolean verticalTouch = (obj1.positionY + 20 == obj2.positionY) || (obj1.positionY == obj2.positionY + 80);

		return horizontalOverlap && verticalTouch;
*/
        // Check if the horizontal ranges overlap
        boolean horizontalOverlap = (obj1.positionX < obj2.positionX + 20) && (obj1.positionX + 20 > obj2.positionX);

        // Check if the vertical edges touch or overlap, considering the velocity
        boolean verticalOverlap = (obj1.positionY + 20 + Math.abs(BeweglichesRechteck.velY) >= obj2.positionY) &&
                                  (obj1.positionY <= obj2.positionY + 80 + Math.abs(BeweglichesRechteck.velY));

        // Ensure that obj1 is moving towards obj2
        boolean movingTowards = (BeweglichesRechteck.velY > 0 && obj1.positionY < obj2.positionY) || (BeweglichesRechteck.velY < 0 && obj1.positionY > obj2.positionY);

        return horizontalOverlap && verticalOverlap && movingTowards;
		
		
	}


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
	}
}
