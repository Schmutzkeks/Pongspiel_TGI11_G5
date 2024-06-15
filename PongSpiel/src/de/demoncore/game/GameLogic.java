package de.demoncore.game;

import java.util.ArrayList;
import java.util.Random;
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

	
	
	
	private double reactionDelay = 0.5;
	private boolean isReacting = false;
	private Timer reactionTimer = new Timer();
	private Random random = new Random();


	
	
	
	
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

				updateBotMovement();
/*
				if (Ball01.positionY < (ingamescrheight-50) && Ball01.positionY > 30 && PlayerContinue) {
					if (Ball01.positionY + 10 > player02.positionY + 40) {
						Player2.velocity.TVector2(player02, Player2.velocity.getXCur(), Player2.velocity.getYCur());
					}
					else if (Ball01.positionY + 10 < player02.positionY + 40) {
						Player2.velocity.TVector2(player02, Player2.velocity.getXCur(), Player2.velocity.getYCur() * (-1));
					}
				}*/
				
				// Inside your game loop or key press handling logic
				if (Ball01.positionY < (ingamescrheight - 50) && Ball01.positionY > 30 && PlayerContinue) {
				    double targetY = Ball01.positionY + 10;
				    double currentY = player02.positionY + 40;
				    
				    if (targetY > currentY) {
				        // Accelerate towards the ball's position
				        Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), Player2.velocity.getYMax(), Player2.velocity.getAcc()));
				    } else if (targetY < currentY) {
				        // Accelerate towards the ball's position
				        Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), -Player2.velocity.getYMax(), Player2.velocity.getAcc()));
				    } else {
				        // Decelerate towards 0
				        Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), 0, Player2.velocity.getAcc()-5));
				    }

				    // Apply the velocity to move player02
				    Player2.velocity.TVector2(player02, Player2.velocity.getXCur(), Player2.velocity.getYCur());
				} else if (PlayerContinue) {
				    // Decelerate towards 0 when the ball is not in the middle of the screen
				    Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), 0, Player2.velocity.getAcc()-5));
				    Player2.velocity.TVector2(player02, Player2.velocity.getXCur(), Player2.velocity.getYCur());
				}
				
				
				
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
				    if (player01.positionY < 480) {
				        // Accelerate towards maxSpeed
				        Player1.velocity.setYCur(Vector2.moveTowards(Player1.velocity.getYCur(), Player1.velocity.getYMax(), Player1.velocity.getAcc()));
				        Player1.velocity.TVector2(player01, Player1.velocity.getXCur(), Player1.velocity.getYCur());
				    }
				    else if (player01.positionY >= 480) {
						Player1.velocity.setYCur(0);
						player01.positionY = 480;
					}
				} else if (PlayerContinue) {
				    // Decelerate towards 0
					if (player01.positionY <= 0) {
						Player1.velocity.setYCur(0);
						player01.positionY = 0;
					}
					if (player01.positionY >= 480) {
						Player1.velocity.setYCur(0);
						player01.positionY = 480;
					}
				    Player1.velocity.setYCur(Vector2.moveTowards(Player1.velocity.getYCur(), 0, 0.05));
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
		player1.setSpeed(0, 2.0);
		Player1.velocity.setAcc(0.10);
		
		//Bot
		Player2 player2 = new Player2(player02, 0, 0);
		player2.setSpeed(0, 2.0);
		Player2.velocity.setAcc(0.10);
		
		//Ball
		Ball gameBall = new Ball(-1.0, -1.0);
		gameBall.setSpeed(2, 2);
		
	}

	
	public void updateBotMovement() {
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

	    double targetY = predictBallPosition();
	    double currentY = player02.positionY + 40;

	    if (targetY > currentY && player02.positionY <480) {
	        Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), Player2.velocity.getYMax(), Player2.velocity.getAcc()));
	    } else if (targetY < currentY && player02.positionY > 0) {
	        Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), -Player2.velocity.getYMax(), Player2.velocity.getAcc()));
	    } else {
	        Player2.velocity.setYCur(Vector2.moveTowards(Player2.velocity.getYCur(), 0, Player2.velocity.getAcc()));
	    }

	    if (player02.positionY>=480) {
			player02.positionY = 480;
		}
	    if (player02.positionY<=0) {
			player02.positionY = 0;
		}
	    
	    // Apply speed variability
	    Player2.velocity.setYCur(Player2.velocity.getYCur() + (random.nextDouble() - 0.5) * 0.1);

	    // Cap the speed at maxSpeed
	    if (Math.abs(Player2.velocity.getYCur()) > Player2.velocity.getYMax()) {
	        Player2.velocity.setYCur(Player2.velocity.getYMax() * Math.signum(Player2.velocity.getYCur()));
	    }

	    // Simulate hesitation
	    if (random.nextDouble() < 0.01) {
	        Player2.velocity.setYCur(-Player2.velocity.getYCur());
	    }

	    Player2.velocity.setYCur(Player2.velocity.getYCur());
	    Player2.velocity.TVector2(player02, Player2.velocity.getXCur(), Player2.velocity.getYCur());
	}

	private double predictBallPosition() {
	    double ballY = Ball01.positionY;
	    double ballSpeedY = Ball.velocity.getYCur();
	    double distanceToPaddle = Math.abs(Ball01.positionX - player02.positionX);
	    double timeToReachPaddle = distanceToPaddle / Math.abs(Ball.velocity.getXCur());
	    double predictedY = ballY + ballSpeedY * timeToReachPaddle;

	    // Add a small random error to the prediction
	    predictedY += (random.nextDouble() - 0.5) * 20;

	    return predictedY;
	}


	
	
	
	
	
	
}
