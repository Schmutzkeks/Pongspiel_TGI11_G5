package de.demoncore.game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import de.demoncore.gameObjects.Ball;
import de.demoncore.gameObjects.BeweglichesRechteck;
import de.demoncore.gameObjects.Particle;
import de.demoncore.gameObjects.Player1;
import de.demoncore.gameObjects.Player2;
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

	static BeweglichesRechteck Ball01;
	static BeweglichesRechteck player01;
	static BeweglichesRechteck player02;
	static BeweglichesRechteck trennung;

	//public boolean keyLeftarrowpressed;
	//public boolean keyRightarrowpressed;
	public boolean keyUparrowpressed;
	public boolean keyDownarrowpressed;


public static BeweglichesRechteck getPlayer1() {
	return player01;
}

public static BeweglichesRechteck getPlayer2() {
	return player02;
}


	public GameLogic() {
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		particles = new ArrayList<Particle>();

		keyUparrowpressed = false;
		keyDownarrowpressed = false;
		

		createObjects();
		

		defineObjects();
		


		gameTimer.scheduleAtFixedRate(new TimerTask(){ 
			@Override
			public void run() {

				// Laufende Ausführungen im Spiel:
				Ball01.bouncebewegung(Ball01, player01, player02);


				if (Ball01.positionY < (ingamescrheight-50) && Ball01.positionY > 30 && PlayerContinue) {
					if (Ball01.positionY + 10 > player02.positionY + 40) {
						Player2.velocity.TVector2(player02, Player2.velocity.getXCur(), Player2.velocity.getYCur());
					}
					else if (Ball01.positionY + 10 < player02.positionY + 40) {
						Player2.velocity.TVector2(player02, Player2.velocity.getXCur(), Player2.velocity.getYCur() * (-1));
					}
				}
				
				
				if (keyUparrowpressed && PlayerContinue) {
				    if (player01.positionY > 0) {
				        // Accelerate towards maxSpeed
				        Player1.velocity.setYCur(Player1.velocity.moveTowards(Player1.velocity.getYCur(), -Player1.velocity.getYMax(), Player1.velocity.getAcc()));
				        Player1.velocity.TVector2(player01, Player1.velocity.getXCur(), Player1.velocity.getYCur());
				    }
				} else if (keyDownarrowpressed && PlayerContinue) {
				    if (player01.positionY < 480) {
				        // Accelerate towards maxSpeed
				        Player1.velocity.setYCur(Player1.velocity.moveTowards(Player1.velocity.getYCur(), Player1.velocity.getYMax(), Player1.velocity.getAcc()));
				        Player1.velocity.TVector2(player01, Player1.velocity.getXCur(), Player1.velocity.getYCur());
				    }
				} else if (PlayerContinue) {
				    // Decelerate towards 0
					if (player01.positionY > 0) {
						Player1.velocity.setYCur(0);
					}
					if (player01.positionY < 480) {
						Player1.velocity.setYCur(0);
					}
				    Player1.velocity.setYCur(Player1.velocity.moveTowards(Player1.velocity.getYCur(), 0, 0.05));
				    Player1.velocity.TVector2(player01, Player1.velocity.getXCur(), Player1.velocity.getYCur());
				}
				
				
				//Partikel updaten
				for (Particle p : new ArrayList<Particle>(particles)) {
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
		Ball01 = new BeweglichesRechteck(393, 240, 20, 20);		//(posX, posY, breite, hoehe) 
		spielObjekte.add(Ball01);

		player01 = new BeweglichesRechteck(716, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(player01);

		player02 = new BeweglichesRechteck(50, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(player02);

		trennung = new BeweglichesRechteck(0, 560, 800, 20);	//(posX, posY, breite, hoehe) 
		spielObjekte.add(trennung);		//abtrennung für Bereich unten
	}

	public static void centerBall() {
		Ball01.positionX = 393;
		Ball01.positionY = 240;
	}

	public static void pauseBall() {
		Ball.velocity.setXCur(1);
		Ball.velocity.setYCur(1);
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
			particles.add(new Particle(Ball01.positionX, Ball01.positionY));
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
	public void defineObjects() {
		// You
		Player1 player1 = new Player1(player01, 0, 0);
		player1.setSpeed(0, 1.5);
		Player1.velocity.setAcc(0.05);
		
		//Bot
		Player2 player2 = new Player2(player02, 0, 1);
		player2.setSpeed(0, 1.5);
		
		//Ball
		Ball gameBall = new Ball(-1.0, -1.0);
		gameBall.setSpeed(2, 2);
		
	}

}
