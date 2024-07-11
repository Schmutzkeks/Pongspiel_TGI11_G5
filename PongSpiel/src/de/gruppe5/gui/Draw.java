package de.gruppe5.gui;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import de.gruppe5.actions.Main;
import de.gruppe5.game.GameLogic;
import de.gruppe5.game.GameObject;
import de.gruppe5.gameObjects.Ball;
import de.gruppe5.gameObjects.Particle;

@SuppressWarnings("serial")
public class Draw extends JLabel{

	public static Draw instance;
	boolean laserSichtbar;
	private int screenwidth;
	private int screenheight;
	ArrayList<GameObject> objekteImSpiel;
	ArrayList<Particle> particles;

	BufferedImage laserBild;
	public Color laserColor;

	public Image nukeImage;
	public Image explosionImage;
	public Image shockwaveImage;

	public Draw(GameLogic spiellogik, int screenBreite, int screenHoehe) {
		objekteImSpiel = spiellogik.spielObjekte;
		particles = spiellogik.particles;
		screenwidth = screenBreite;
		screenheight = screenHoehe;
		instance=this;

		try {
			explosionImage = ImageIO.read(Main.class.getResourceAsStream("/resources/Explosion.png"));
			nukeImage = ImageIO.read(Main.class.getResourceAsStream("/resources/NukeRaw.png"));
			shockwaveImage = ImageIO.read(Main.class.getResourceAsStream("/resources/Shockwave.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			laserBild = ImageIO.read(Main.class.getResourceAsStream("/resources/laser.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Nicht entfernen
	int laserSichtbarkeitZeit = 350;
	float laserExplosionGroesse = 0;

	boolean isExplosion = false;

	public void laserSchuss() {
		// Laser schuss - von nick

		if(laserSichtbar || 
				!GameLogic.getPlayer2().istAktiviert) return;

		laserColor = Color.red;

		for(int i = 0; i < 50; i++) {

			particles.add(new Particle(GameLogic.getPlayer2().positionX + 
					GameLogic.getPlayer2().groesseX / 2,
					GameLogic.getPlayer2().positionY +
					GameLogic.getPlayer2().groesseY / 2));
		}


		Thread sleep = new Thread("laser") {
			public void run() {
				// Boolean true
				laserSichtbar=true;
				laserExplosionGroesse = 0;

				GameLogic.getPlayer2().istAktiviert = false;

				for(int i = 0; i < laserSichtbarkeitZeit; i++) {
					try {
						Thread.currentThread().sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					laserColor = new Color(1f, 0f, 0f, 1 - ((float)i / (float)laserSichtbarkeitZeit));
					laserExplosionGroesse += (4f * Math.pow(1 - ((float)i / laserSichtbarkeitZeit), 2));
				}

				laserSichtbar=false;
				// Boolean false
			};
		};
		sleep.start();
	}

	public void paintComponent(Graphics g){

		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if(isExplosion) {
			g.translate((int)(((Math.random() * 100 - 50)  * ((float)laserColor.getAlpha() / 255))),
						(int)(((Math.random() * 100 - 50)  * ((float)laserColor.getAlpha() / 255))));
		}
		
		// Zeichne Hintergrund
		g.setColor(Color.BLACK);
		g.fillRect(-150, -150, screenwidth + 300, screenheight + 300);

		// Laser explosion - von nick
		if(laserSichtbar) {

			g2d.setColor(laserColor);
			g2d.fillOval((int)GameLogic.getPlayer2().positionX + 
					(int)GameLogic.getPlayer2().groesseX / 2 - (int)laserExplosionGroesse / 2,
					(int)GameLogic.getPlayer2().positionY +
					(int)GameLogic.getPlayer2().groesseY / 2 - (int)laserExplosionGroesse / 2,
					(int)laserExplosionGroesse,
					(int)laserExplosionGroesse);
		}

		// Zeichne alle Spielobjekte
		g.setColor(Shop.getTheme());
		for (int i = 0; i < objekteImSpiel.size(); i++) {
			GameObject aktuellesObjekt = objekteImSpiel.get(i);
			if(aktuellesObjekt == Ball.Ball01)
				g.setColor(Shop.getTheme(true));
			else {
				g.setColor(Shop.getTheme());
			}
			if(aktuellesObjekt.istAktiviert)
				g.fillRect((int)aktuellesObjekt.positionX, (int)aktuellesObjekt.positionY, aktuellesObjekt.groesseX, aktuellesObjekt.groesseY);
		}

		//zeichen von Partikeln
		g.setColor(Shop.getTheme());
		try {
			for (Particle p : particles) {
				g.fillRect((int)p.getX(), (int)p.getY(), p.getSize(), p.getSize());
			}
		} catch (Exception e) {}

		g.setColor(Color.white);
		g.drawImage(nukeImage, getWidth() / 2 - 25, (int)nukeYPos - 250 - 25, 50, 50, null);

		//Zeichne Laser - von nick
		if (laserSichtbar) {
			g2d.setStroke(new BasicStroke(10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
			g2d.setColor(laserColor);

			TexturePaint paint = new TexturePaint(laserBild, new Rectangle(75, 75));
			g2d.setPaint(paint);

			g2d.drawLine(525 + 25, 600 + 25, 
					(int)GameLogic.getPlayer2().positionX + 
					(int)GameLogic.getPlayer2().groesseX / 2,
					(int)GameLogic.getPlayer2().positionY +
					(int)GameLogic.getPlayer2().groesseY / 2);
		}

		if(isExplosion && laserColor != null) {
			
			g2d.setColor(new Color(1, 0, 0, (float)laserColor.getAlpha() / 255));

			g2d.fillOval((int)getWidth() / 2 - (int)laserExplosionGroesse / 2,
					(int)getHeight() / 2 - (int)laserExplosionGroesse / 2,
					(int)laserExplosionGroesse,
					(int)laserExplosionGroesse);

			g2d.setColor(new Color(0.75f, 0.75f, 0, (float)laserColor.getAlpha() / 255));

			g2d.fillOval((int)getWidth() / 2 - (int)((laserExplosionGroesse / 2) / 1.5f),
					(int)getHeight() / 2 - (int)((laserExplosionGroesse / 2) / 1.5f),
					(int)(laserExplosionGroesse / 1.5f),
					(int)(laserExplosionGroesse / 1.5f));

			Composite bComposite = g2d.getComposite();
	        Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER,(float)laserColor.getAlpha() / 255);
	        g2d.setComposite(comp);
			
			g2d.drawImage(explosionImage, (int)getWidth() / 2 - (int)((laserExplosionGroesse / 2) / 2.5f),
					(int)getHeight() / 2 - (int)((laserExplosionGroesse / 2) / 2.5f),
					(int)(laserExplosionGroesse / 2.5f),
					(int)(laserExplosionGroesse / 2.5f), null);

			g2d.rotate(Math.toRadians(45 + 250 * ((float)laserColor.getAlpha() / 255)), getWidth() / 2, getHeight() / 2);
			g2d.drawImage(explosionImage, (int)getWidth() / 2 - (int)((laserExplosionGroesse / 2)),
					(int)getHeight() / 2 - (int)((laserExplosionGroesse / 2)),
					(int)(laserExplosionGroesse),
					(int)(laserExplosionGroesse), null);
			g2d.rotate(Math.toRadians(-45 + -250 * ((float)laserColor.getAlpha() / 255)), getWidth() / 2, getHeight() / 2);
			
			Composite com1 = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ((float)laserColor.getAlpha() / 255) / 2);
			g2d.setComposite(com1);
			
			g2d.drawImage(shockwaveImage, (int)getWidth() / 2 - (int)((laserExplosionGroesse / 2) / 0.75f),
					(int)getHeight() / 2 - (int)((laserExplosionGroesse / 2) / 0.75f),
					(int)(laserExplosionGroesse / 0.75f),
					(int)(laserExplosionGroesse / 0.75f), null);
			
			g2d.setComposite(bComposite);
			
			g2d.setColor(new Color(1, 1, 1, (float)laserColor.getAlpha() / 255));
			g2d.fillRect(-150, -150, getWidth() + 300, getHeight() + 300);
		}
		
		repaint();
	}

	public float nukeYPos = 0;

	public void dropNuke() {

		Thread thread = new Thread() {
			public void run() {
				for(int i = 0; i < 500; i++) {
					nukeYPos++;
					try {
						sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				nukeYPos = 0;
				isExplosion=true;
				laserExplosionGroesse = 0;

				GameLogic.getPlayer3().istAktiviert = false;
				GameLogic.getPlayer2().istAktiviert = false;
				GameLogic.getPlayer1().istAktiviert = false;
				
				int explosionTime = 2500;
				for(int i = 0; i < explosionTime; i++) {
					try {
						Thread.currentThread().sleep(1);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					laserColor = new Color(1f, 0f, 0f, 1 - ((float)i / (float)explosionTime));
					laserExplosionGroesse += (3f * Math.pow(1 - ((float)i / explosionTime), 2));
				}
				
				isExplosion = false;
				
				try {					
					sleep(2250);
				}catch (Exception e) {

				}

				GameLogic.getPlayer3().istAktiviert = true;
				GameLogic.getPlayer2().istAktiviert = true;
				GameLogic.getPlayer1().istAktiviert = true;
			};
		};
		thread.start();
	}

}
