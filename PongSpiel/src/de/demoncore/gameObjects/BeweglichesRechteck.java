package de.demoncore.gameObjects;

import de.demoncore.game.GameObject;
import de.demoncore.game.Gamelogic2;
import de.demoncore.game.Vector2;

public class BeweglichesRechteck extends GameObject {
	Gamelogic2 Detection = new Gamelogic2();
	public byte richtung;
	public int schritteInGleicherRichtung;
	int ingamescrwidth = 786;
	int ingamescrheight = 593 - 31;
	double speed;
	public static double velX = 1;
	public static double velY = 1;
	Vector2 ballVector2 = new Vector2();	
	
	

	

	public BeweglichesRechteck(int posX, int posY, int breite, int hoehe) {
		super(posX, posY, breite, hoehe);
		schritteInGleicherRichtung = 0;
	}
	
	public void Vector2(double x, double y) {
		positionX += x;
		positionY += y;
	}
	
	
	public void bouncebewegung(BeweglichesRechteck obj1, BeweglichesRechteck obj2, BeweglichesRechteck obj3 ) {
		
		// tan for the bounce. tan = g/a = velY/velX
		Vector2(velX, velY);



        // Check for collision with wall
		Detection.Collisionwall(obj1);

		
		// Check for collisions
		
		if (Detection.isCollidingLeftRight(obj1, obj2)) {
			Detection.CollisionLeftRight(obj1, obj2);
		}
		if (Detection.isCollidingLeftRight(obj1, obj3)) {
			Detection.CollisionLeftRight(obj1, obj3);
		}
		if (Detection.isCollidingTopBottom(obj1, obj2)) {
			Detection.CollisionTopBottom(obj1, obj2);
		}
		if (Detection.isCollidingTopBottom(obj1, obj3)) {
			Detection.CollisionTopBottom(obj1, obj3);
		}

		
        
	}
	

}
