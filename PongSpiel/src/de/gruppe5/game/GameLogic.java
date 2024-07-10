package de.gruppe5.game;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import de.gruppe5.gameObjects.Ball;
import de.gruppe5.gameObjects.BeweglichesRechteck;
import de.gruppe5.gameObjects.Particle;
import de.gruppe5.gameObjects.Player1;
import de.gruppe5.gameObjects.Player2;
import de.gruppe5.gui.Gui;
import de.gruppe5.gui.Shop;
import de.gruppe5.gameObjects.Player3;

public class GameLogic {

	private Timer gameTimer;
	public int screenwidth;
	public int screenheight;
	int ingamescrwidth = 786;
	int ingamescrheight = 593 - 31;
	public static int timeLeft = 0;
	public int speed;
	public static boolean BallContinue = false;
	private static boolean PlayerContinue = true;
	public static boolean MusicEnabled = true;
	public static int backgroundMusic = 1;
	public static boolean Multiplayer = false;

	public static ArrayList<GameObject> spielObjekte;
	public static ArrayList<Particle> particles;

	static BeweglichesRechteck Ball01;
	static BeweglichesRechteck player01;	//player 1
	static BeweglichesRechteck player02;	//Gegner
	static BeweglichesRechteck player03; 	//Spieler 2
	static BeweglichesRechteck trennung;

	public boolean keyUparrowpressed;
	public boolean keyDownarrowpressed;
	public boolean keyWpressed;
	public boolean keySpressed;



	private double reactionDelay = 0.5;
	private boolean isReacting = false;
	private Timer reactionTimer = new Timer();
	private Random random = new Random();

	private boolean isHesitating = false;
	private int hesitationCounter1 = 0;
	private int hesitationCounter1_towhat = 1001;
	private int hesitationCounter2 = 0;
	private int hesitationCounter2_towaht = 51;

	public static final int EASY = 1;
	public static final int MEDIUM = 2;
	public static final int HARD = 3;
	public static final int IMPOSSIBLE = 4;
	public static int botDifficulty = MEDIUM; // Default
	boolean done = false;
	double botinsecurespeed = 1;

	double randompredictionnumber = 20;
	double hesitationnumber = 0.002;
	double smoothFactor = 0.8; // Smoothing factor
	double botupdating_screenwidth = 2;



	public static BeweglichesRechteck getPlayer1() {
		return player01;
	}

	public static BeweglichesRechteck getPlayer2() {
		return player02;
	}

	public static BeweglichesRechteck getPlayer3() {
		return player03;
	}


	public GameLogic() {
		gameTimer = new Timer();
		spielObjekte = new ArrayList<GameObject>();
		particles = new ArrayList<Particle>();

		keyUparrowpressed = false;
		keyDownarrowpressed = false;


		createObjects();
		defineObjects();

		MusicPlayer.playSound(backgroundMusic, true);
		//MusicPlayer.setVolume(backgroundMusic, -40); // Macht alles kaputt inklusive meine Nerven. Bitte nicht aktivieren ~ Flo


		gameTimer.scheduleAtFixedRate(new TimerTask(){ 
			@Override
			public void run() {

				// Laufende Ausführungen im Spiel:
				
				if(!Multiplayer) {
					Ball01.bouncebewegung(Ball01, player01, player02);
				}else {
					Ball01.bouncebewegung(Ball01, player01, player03);
				}

				if (Ball01.positionX<ingamescrwidth/botupdating_screenwidth&&!Multiplayer) {
					updateBotMovement();
				}

				updatePlayerMovement();

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
		//Ball01 = new BeweglichesRechteck(393, 240, 20, 20);		//(posX, posY, breite, hoehe) 
		Ball01 = Ball.setRechteck();
		spielObjekte.add(Ball01);

		//player01 = new BeweglichesRechteck(716, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		player01 = Player1.setRechteck();;
		spielObjekte.add(player01);

		//player02 = new BeweglichesRechteck(50, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		player02 = Player2.setRechteck();
		spielObjekte.add(player02);

		//player03 = new BeweglichesRechteck(716, 240, 20, 80);	//(posX, posY, breite, hoehe) 
		player03 = Player3.setRechteck();;
		spielObjekte.add(player03);


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
		Player1 player1 = new Player1(0, 0);
		player1.setSpeed(0, 2.0);
		Player1.velocity.setAcc(0.10);

		//Bot
		Player2 player2 = new Player2(player02, 0, 0);
		player2.setSpeed(0, 2.0);
		Player2.velocity.setAcc(0.10);

		//Player 2
		Player3 player3 = new Player3(player03, 0, 0);
		player3.setSpeed(0, 2.0);
		Player3.velocity.setAcc(0.10);

		//Ball
		Ball gameBall = new Ball(-1.0, -1.0);
		gameBall.setSpeed(2, 2);

	}


	public void updateBotMovement() {
		difficultynumbers();


		double targetY = predictBallPosition();
		double currentY = player02.positionY + 40;



		if (hesitationCounter1>hesitationCounter1_towhat && botDifficulty != IMPOSSIBLE) {
			isHesitating = true;
			hesitationCounter1=0;
		}
		else if (hesitationCounter2>=hesitationCounter2_towaht && botDifficulty != IMPOSSIBLE) {
			isHesitating = false;
		}



		if (!isReacting) {
			isReacting = true;
			reactionTimer.schedule(new TimerTask() {
				@Override
				public void run() {
					isReacting = false;
				}
			}, (long) (reactionDelay * 1000));
			return;
		}

		
		if (botDifficulty == IMPOSSIBLE) {
			isHesitating = false;
		}

		if (isHesitating && hesitationCounter2 <hesitationCounter2_towaht && Ball01.positionX<screenwidth/4 && Ball.velocity.getXCur()<0  && botDifficulty != IMPOSSIBLE) {
			Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), 0, 0.02));
			hesitationCounter2++;
		}
		else {
			double newYVelocity = Vector2.moveTowards(Player2.velocity.getYCur(), targetY+10 > currentY ? Player2.velocity.getYMax() : -Player2.velocity.getYMax(), Player2.velocity.getAcc());
			Player2.velocity.setYCur(Player2.velocity.getYCur() + smoothFactor * (newYVelocity - Player2.velocity.getYCur()));
			if(botDifficulty != IMPOSSIBLE) {
				hesitationCounter1++;
				hesitationCounter2 = 0;
			}
		}


		// speed variability
		Player2.velocity.setYCur(Player2.velocity.getYCur() + (random.nextDouble() - 0.5) * 0.1);

		//  hesitation

		if (random.nextDouble() < hesitationnumber) {
			Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), 0, 0.02));
		}


		// maxSpeed
		if (Math.abs(Player2.velocity.getYCur()) > Player2.velocity.getYMax()) {
			Player2.velocity.setYCur(Player2.velocity.getYMax() * Math.signum(Player2.velocity.getYCur()));
		}

		// ensures Enemy stays within bounds
		if (player02.positionY >= 480) {
			player02.positionY = 480;
		}
		if (player02.positionY <= 0) {
			player02.positionY = 0;
		}

		
		if (currentY > targetY+10 || currentY < targetY-10 ) {
			Player2.velocity.TVector2(player02, Player2.velocity.getXCur(), Player2.velocity.getYCur());
		}
		

		


	}

	private void updatePlayerMovement() {
		//Für Spieler 1
		if(Shop.getPlayerSize())
			player01.groesseY = 160;
		else
			player01.groesseY = 80;



		if (keyUparrowpressed && PlayerContinue) {
			if (player01.positionY > 0) {
				// Accelerate towards maxSpeed
				Player1.velocity.setYCur(Vector2.moveTowards(Player1.velocity.getYCur(), -Player1.velocity.getYMax(), Player1.velocity.getAcc()));
				Player1.velocity.TVector2(player01, Player1.velocity.getXCur(), Player1.velocity.getYCur());
			}
			else if (player01.positionY <= 0) {
				Player1.velocity.setYCur(0);
				player01.positionY = 0;
			}
		} else if (keyDownarrowpressed && PlayerContinue) {
			if (player01.positionY < 480 - (Player1.player01.groesseY - 80)) {
				// Accelerate towards maxSpeed
				Player1.velocity.setYCur(Vector2.moveTowards(Player1.velocity.getYCur(), Player1.velocity.getYMax(), Player1.velocity.getAcc()));
				Player1.velocity.TVector2(player01, Player1.velocity.getXCur(), Player1.velocity.getYCur());
			}
			else if (player01.positionY >= 480 - (Player1.player01.groesseY - 80)) {
				Player1.velocity.setYCur(0);
				player01.positionY = 480 - (Player1.player01.groesseY - 80);
			}
		} else if (PlayerContinue) {
			// Decelerate towards 0
			if (player01.positionY <= 0) {
				Player1.velocity.setYCur(0);
				player01.positionY = 0;
			}
			if (player01.positionY >= 480 - (Player1.player01.groesseY - 80)) {
				Player1.velocity.setYCur(0);
				player01.positionY = 480 - (Player1.player01.groesseY - 80);
			}
			Player1.velocity.setYCur(Vector2.moveTowards(Player1.velocity.getYCur(), 0, 0.05));
			Player1.velocity.TVector2(player01, Player1.velocity.getXCur(), Player1.velocity.getYCur());
		}


		// for Resizing not out of bounds
		if (player02.positionY <= 0) {
			player02.positionY = 0;
		}
		if (player02.positionY >= 480 - (Player2.player02.groesseY - 80)) {
			player02.positionY = 480 - (Player2.player02.groesseY - 80);
		}


		if(!Multiplayer) {
			return;
		}
		//Für spieler 3
		if(Shop.getPlayerSize())
			player03.groesseY = 160;
		else
			player03.groesseY = 80;


		if (keyWpressed && PlayerContinue) {
			if (player03.positionY > 0) {
				// Accelerate towards maxSpeed
				Player3.velocity.setYCur(Vector2.moveTowards(Player3.velocity.getYCur(), -Player3.velocity.getYMax(), Player3.velocity.getAcc()));
				Player3.velocity.TVector2(player03, Player3.velocity.getXCur(), Player3.velocity.getYCur());
			}
			else if (player03.positionY <= 0) {
				Player3.velocity.setYCur(0);
				player03.positionY = 0;
			}
		} else if (keySpressed && PlayerContinue) {
			if (player03.positionY < 480 - (Player3.player03.groesseY - 80)) {
				// Accelerate towards maxSpeed
				Player3.velocity.setYCur(Vector2.moveTowards(Player3.velocity.getYCur(), Player3.velocity.getYMax(), Player3.velocity.getAcc()));
				Player3.velocity.TVector2(player03, Player1.velocity.getXCur(), Player3.velocity.getYCur());
			}
			else if (player03.positionY >= 480 - (Player3.player03.groesseY - 80)) {
				Player3.velocity.setYCur(0);
				player03.positionY = 480 - (Player3.player03.groesseY - 80);
			}
		} else if (PlayerContinue) {
			// Decelerate towards 0
			if (player03.positionY <= 0) {
				Player3.velocity.setYCur(0);
				player03.positionY = 0;
			}
			if (player03.positionY >= 480 - (Player3.player03.groesseY - 80)) {
				Player3.velocity.setYCur(0);
				player03.positionY = 480 - (Player3.player03.groesseY - 80);
			}
			Player3.velocity.setYCur(Vector2.moveTowards(Player3.velocity.getYCur(), 0, 0.05));
			Player3.velocity.TVector2(player03, Player3.velocity.getXCur(), Player3.velocity.getYCur());
		}


		// for Resizing not out of bounds
		if (player03.positionY <= 0) {
			player03.positionY = 0;
		}
		if (player03.positionY >= 480 - (Player3.player03.groesseY - 80)) {
			player03.positionY = 480 - (Player3.player03.groesseY - 80);
		}

	}

	private double predictBallPosition() {
		double ballY = Ball01.positionY;
		double ballSpeedY = Ball.velocity.getYCur();
		double distanceToPaddle = Math.abs(Ball01.positionX - player02.positionX);
		double timeToReachPaddle = distanceToPaddle / Math.abs(Ball.velocity.getXCur());
		double predictedY = ballY + ballSpeedY * timeToReachPaddle;

		// small random error 
		botinsecurespeed = Math.abs(Ball.velocity.getYCur());
		System.out.println(botinsecurespeed);
		double randomnumberforprediction = (random.nextDouble() - 0.5) * (randompredictionnumber * (botinsecurespeed + 1));
		System.out.println(randomnumberforprediction);
		predictedY += randomnumberforprediction;

		return predictedY;
	}


	private void difficultynumbers() {
		if (done==false) {
			switch (botDifficulty) {
			case EASY:
				randompredictionnumber = 150;
				hesitationnumber = 0.003;
				hesitationCounter1_towhat = 1001;
				hesitationCounter2_towaht = 71;
				smoothFactor = 0.8;
				botupdating_screenwidth = 2;
				break;
			case MEDIUM:
				randompredictionnumber = 55;
				hesitationnumber = 0.0015;
				hesitationCounter1_towhat = 1001;
				hesitationCounter2_towaht = 36;
				smoothFactor = 0.8;
				botupdating_screenwidth = 2;
				break;
			case HARD:
				randompredictionnumber = 25;
				hesitationnumber = 0.0005;
				hesitationCounter1_towhat = 2001;
				hesitationCounter2_towaht = 16;
				smoothFactor = 0.8;
				botupdating_screenwidth = 2;
				break;
			case IMPOSSIBLE:
				randompredictionnumber = 0;
				hesitationnumber = 0.0;
				hesitationCounter1_towhat = 2001;
				hesitationCounter2_towaht = 0;
				smoothFactor = 1;
				botupdating_screenwidth = 1.25;
				break;
			}
			System.out.println("Difficulty: " + botDifficulty);
			done = true;
		}

	}






}
