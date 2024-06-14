package de.demoncore.gui;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import de.demoncore.actions.Main;
import de.demoncore.game.GameLogic;
import de.demoncore.game.GameObject;
import de.demoncore.gameObjects.Ball;
import de.demoncore.gameObjects.Particle;

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
	
	public Draw(GameLogic spiellogik, int screenBreite, int screenHoehe) {
		objekteImSpiel = spiellogik.spielObjekte;
		particles = spiellogik.particles;
		screenwidth = screenBreite;
		screenheight = screenHoehe;
		instance=this;	
	
		try {
			laserBild = ImageIO.read(Main.class.getResourceAsStream("/resources/laser.png"));
			System.out.println(laserBild.getHeight());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// Nicht entfernen
	int laserSichtbarkeitZeit = 350;
	float laserExplosionGroesse = 0;
	
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

		// Zeichne Hintergrund
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenwidth, screenheight);
		
		// Laser explosion - von nick
		g2d.setColor(laserColor);
		g2d.fillOval((int)GameLogic.getPlayer2().positionX + 
				(int)GameLogic.getPlayer2().groesseX / 2 - (int)laserExplosionGroesse / 2,
				(int)GameLogic.getPlayer2().positionY +
				(int)GameLogic.getPlayer2().groesseY / 2 - (int)laserExplosionGroesse / 2,
		(int)laserExplosionGroesse,
		(int)laserExplosionGroesse);
		
		// Zeichne alle Spielobjekte
		g.setColor(Shop.getTheme());
		for (int i = 0; i < objekteImSpiel.size(); i++) {
			GameObject aktuellesObjekt = objekteImSpiel.get(i);
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
		
		repaint();
	}
	
}
