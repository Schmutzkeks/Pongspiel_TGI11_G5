package de.demoncore.game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import de.demoncore.gameObjects.BeweglichesRechteck;

public class GameLogic {

	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	int ingamescrwidth = 786;
	int ingamescrheight = 593 - 31;
	public int speed;
	public static ArrayList<GameObject> spielObjekte;
	
	static BeweglichesRechteck Ball;
	static BeweglichesRechteck beispielObjekt2;
	static BeweglichesRechteck beispielObjekt3;
	static BeweglichesRechteck trennung;
	
	//public boolean keyLeftarrowpressed;
	//public boolean keyRightarrowpressed;
	public boolean keyUparrowpressed;
	public boolean keyDownarrowpressed;




	public GameLogic() {
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		Vector2 ballVector2 = new Vector2();

		//keyLeftarrowpressed = false;
		//keyRightarrowpressed = false;
		keyUparrowpressed = false;
		keyDownarrowpressed = false;

		createObjects();


		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {

				// Laufende Ausführungen im Spiel:
				Ball.bouncebewegung(Ball, beispielObjekt2, beispielObjekt3);

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
					if(beispielObjekt2.positionY>0) {
					beispielObjekt2.positionY -= 1;
					}
				} else if (keyDownarrowpressed) {
					if(beispielObjekt2.positionY<480) {
					beispielObjekt2.positionY += 1;
					}
				}
				

				

			}
		}, 0, 5);
	}
	
	public static void createObjects() {
		try {
			spielObjekte.clear();
		} catch (Exception e) {}
		// Objekte im Spiel:
		Ball = new BeweglichesRechteck(393, 240, 20, 20);		//(posX, posY, breite, hoehe) 
		spielObjekte.add(Ball);

		beispielObjekt2 = new BeweglichesRechteck(716, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(beispielObjekt2);

		beispielObjekt3 = new BeweglichesRechteck(50, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(beispielObjekt3);

		trennung = new BeweglichesRechteck(0, 560, 800, 20);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(trennung);		//abtrennung für Bereich unten
	}
	
	public static void centerBall() {
		Ball.positionX = 393;
		Ball.positionY = 240;
	}

}
