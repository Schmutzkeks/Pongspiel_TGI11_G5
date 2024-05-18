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
		BeweglichesRechteck beispielObjekt1 = new BeweglichesRechteck(50, 100, 20, 20);		//(posX, posY, breite, hoehe) 
		spielObjekte.add(beispielObjekt1);
		beispielObjekt1.richtung = 0; // Startrichtung
		BeweglichesRechteck beispielObjekt2 = new BeweglichesRechteck(700, 260, 20, 80);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(beispielObjekt2);

		gameTimer.scheduleAtFixedRate(new TimerTask(){
			@Override
			public void run() {
				// Laufende Ausführungen im Spiel:
				beispielObjekt1.automatischeKreisbewegung();
				/*
				if (keyLeftarrowpressed) {
					beispielObjekt2.positionX -= 1;
					System.out.println(screenwidth);
				} else if (keyRightarrowpressed) {
					beispielObjekt2.positionX += 1;
				}
				 */

				if (keyUparrowpressed) {
					beispielObjekt2.positionY -= 1;
				} else if (keyDownarrowpressed) {
					beispielObjekt2.positionY += 1;
				}
			}
		}, 0, 5);
	}

}
