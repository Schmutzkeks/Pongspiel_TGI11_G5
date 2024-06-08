package de.demoncore.game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import de.demoncore.gameObjects.BeweglichesRechteck;
import de.demoncore.gameObjects.Particle;
import de.demoncore.gameObjects.Player1;
import de.demoncore.gui.Gui;

public class GameLogic {

	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	int ingamescrwidth = 786;
	int ingamescrheight = 593 - 31;
	public int speed;
	public static boolean BallContinue = false;
	private static boolean PlayerContinue = true;

	public static ArrayList<GameObject> spielObjekte;
	public static ArrayList<Particle> particles;

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
		particles = new ArrayList<Particle>();
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

				
				if (keyUparrowpressed && PlayerContinue) {
					if(beispielObjekt2.positionY>0) {
						beispielObjekt2.positionY -= 1;

					}
				} else if (keyDownarrowpressed && PlayerContinue) {
					if(beispielObjekt2.positionY<480) {
						beispielObjekt2.positionY += 1;
					}
				}

				//Partikel updaten
				for (Particle p : particles) {
					p.update();
				}

				try {	//partikel auflösen
					if (particles.get(0).updates >= 30) {
						if (particles.size() == 1) {
							GameLogic.clearParticle();
						} else {
							ArrayList<Particle> particlesToRemove = new ArrayList<>();
							int removalCount = particles.size() / 2;
							for (int i = 0; i < removalCount; i++) {
								particlesToRemove.add(particles.get(i));
							}

							particles.removeAll(particlesToRemove);
							particles.get(0).updates = 15;
						}
					}
				} catch (Exception e) {}

				

			}
		}, 0, 5);
	}

	public static void createObjects() {
		try {
			spielObjekte.clear();
		} catch (Exception e) {}

		try {
			particles.clear();
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

	public static void pauseBall() {
		BallContinue = false;
		centerBall();
		Gui.startCountdown();
		centerBall();
	}

	public static void continueBall() {
		BallContinue = true;
	}

	public static void createParticles(int Number) {
		for(int i = 0;i<Number;i++) {
			particles.add(new Particle(Ball.positionX, Ball.positionY));
		}
	}

	public static void clearParticle() {
		try {
			particles.clear();
		} catch (Exception e) {}
	}

	public static boolean isPlayerContinue() {
		return PlayerContinue;
	}

	public static void setPlayerContinue(boolean playerContinue) {
		PlayerContinue = playerContinue;
	}


}
