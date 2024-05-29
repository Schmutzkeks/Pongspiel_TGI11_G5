package de.demoncore.game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import de.demoncore.gameObjects.BeweglichesRechteck;
import de.demoncore.gui.Gui;

public class GameLogic {

	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	int ingamescrwidth = 786;
	int ingamescrheight = 593 - 31;
	public int speed;
	public ArrayList<GameObject> spielObjekte;

	//public boolean keyLeftarrowpressed;
	//public boolean keyRightarrowpressed;
	public boolean keyUparrowpressed;
	public boolean keyDownarrowpressed;




	public GameLogic() {
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();

		//keyLeftarrowpressed = false;
		//keyRightarrowpressed = false;
		keyUparrowpressed = false;
		keyDownarrowpressed = false;

		// Objekte im Spiel:
		BeweglichesRechteck Ball = new BeweglichesRechteck(393, 240, 20, 20);		//(posX, posY, breite, hoehe) 
		spielObjekte.add(Ball);
		Ball.richtung = 0; // Startrichtung
		BeweglichesRechteck beispielObjekt2 = new BeweglichesRechteck(716, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(beispielObjekt2);

		BeweglichesRechteck beispielObjekt3 = new BeweglichesRechteck(50, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(beispielObjekt3);

		Gamelogic2 Detection = new Gamelogic2();


		


		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				// Laufende Ausführungen im Spiel:
				Ball.bouncebewegung();




				
				

				
				/*
				if (Detection.isColliding(beispielObjekt1, beispielObjekt2)) {
					Detection.Collision(beispielObjekt1, beispielObjekt2);
				}
				if (Detection.isColliding(beispielObjekt1, beispielObjekt3)) {
					Detection.Collision(beispielObjekt1, beispielObjekt3);
				}
*/
				if (Ball.positionY < (ingamescrheight-50) && Ball.positionY > 30) {
					beispielObjekt3.positionY = Ball.positionY - 30;
				}


				if (keyUparrowpressed) {
					beispielObjekt2.positionY -= 1;
				} else if (keyDownarrowpressed) {
					beispielObjekt2.positionY += 1;
				}
				
				// Check for collisions
				
				if (Detection.isCollidingLeftRight(Ball, beispielObjekt2)) {
					Detection.CollisionLeftRight(Ball, beispielObjekt2);
				}
				if (Detection.isCollidingLeftRight(Ball, beispielObjekt3)) {
					Detection.CollisionLeftRight(Ball, beispielObjekt3);
				}
				if (Detection.isCollidingTopBottom(Ball, beispielObjekt2)) {
					Detection.CollisionTopBottom(Ball, beispielObjekt2);
				}
				if (Detection.isCollidingTopBottom(Ball, beispielObjekt3)) {
					Detection.CollisionTopBottom(Ball, beispielObjekt3);
				}
				

			}
		}, 0, 5);
	}

}
