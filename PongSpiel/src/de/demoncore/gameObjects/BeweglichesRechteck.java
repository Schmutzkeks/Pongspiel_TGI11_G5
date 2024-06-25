package de.demoncore.gameObjects;

import de.demoncore.game.GameObject;
import de.demoncore.game.Collision;
import de.demoncore.game.Vector2;
import de.demoncore.gameObjects.Ball;
import de.demoncore.gui.Shop;

public class BeweglichesRechteck extends GameObject {

	public byte richtung;
	public int schritteInGleicherRichtung;
	int ingamescrwidth = 786;
	int ingamescrheight = 593 - 31;
	double speed = 1.1;
	
	boolean check = false;
	boolean check1 = false;
	boolean check2 = false;
	boolean check3 = false;
	
	boolean only1ball = false;
	
	
	private Player1 player1;
	
	

	


	

	

	public BeweglichesRechteck(double posX, double posY, int breite, int hoehe) {
		super(posX, posY, breite, hoehe);
		//System.out.println("BeweglichesRechteck created with velocity: " + Ball.velocity.getX());
		//schritteInGleicherRichtung = 0;
		
	}

	Vector2 ballVector2 = new Vector2();	
	Collision Detection = new Collision();
	
	
	public void bouncebewegung(BeweglichesRechteck obj1, BeweglichesRechteck obj2, BeweglichesRechteck obj3 ) {
	



        // Check for collision with wall
		Detection.Collisionwall(obj1);
		//ballVector2.TVector2(obj1, velX, velY);
		//gameball.TVector22(obj1, Ball.velocity.getX(), Ball.velocity.getY());
		Ball.velocity.TVector2(obj1 , Shop.getBallSpeed() ? Ball.velocity.getXCur() / 2 : Ball.velocity.getXCur()
									, Shop.getBallSpeed() ? Ball.velocity.getYCur() / 2 : Ball.velocity.getYCur());
		
		
		
		// Check for collisions with PLayer
		
		if (Detection.isCollidingLeftRight(obj1, obj2)&check==false) {
			Detection.CollisionLeftRight(obj1, obj2);
			check = true;
		}
		if (Detection.isCollidingLeftRight(obj1, obj3)&check1==false) {
			Detection.CollisionLeftRight(obj1, obj3);
			check1 = true;
		}
		if (Detection.isCollidingTopBottom(obj1, obj2)&&check2==false) {
			Detection.CollisionTopBottom(obj1, obj2);
			check2 = true;
		}
		if (Detection.isCollidingTopBottom(obj1, obj3)&check3==false) {
			Detection.CollisionTopBottom(obj1, obj3);
			check3 = true;
		}
		
		if (Detection.isCollidingLeftRight(obj1, obj2) == false) {
			check = false;
		}
		if (Detection.isCollidingLeftRight(obj1, obj3) == false) {
			check1 = false;
		}
		if (Detection.isCollidingTopBottom(obj1, obj2) == false) {
			check2 = false;
		}
		if (Detection.isCollidingTopBottom(obj1, obj3) == false) {
			check3 = false;
		}

		
        
	}
	

}
