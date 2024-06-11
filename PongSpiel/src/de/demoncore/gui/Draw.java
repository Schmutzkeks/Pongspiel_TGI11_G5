package de.demoncore.gui;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.JLabel;

import de.demoncore.game.GameLogic;
import de.demoncore.game.GameObject;
import de.demoncore.gameObjects.Particle;

@SuppressWarnings("serial")
public class Draw extends JLabel{
	
	private int screenwidth;
	private int screenheight;
	ArrayList<GameObject> objekteImSpiel;
	ArrayList<Particle> particles;

	public Draw(GameLogic spiellogik, int screenBreite, int screenHoehe) {
		objekteImSpiel = spiellogik.spielObjekte;
		particles = spiellogik.particles;
		screenwidth = screenBreite;
		screenheight = screenHoehe;
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Zeichne Hintergrund
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, screenwidth, screenheight);
		
		// Zeichne alle Spielobjekte
		g.setColor(Shop.getTheme());
		for (int i = 0; i < objekteImSpiel.size(); i++) {
			GameObject aktuellesObjekt = objekteImSpiel.get(i);
			g.fillRect((int)aktuellesObjekt.positionX, (int)aktuellesObjekt.positionY, aktuellesObjekt.groesseX, aktuellesObjekt.groesseY);
		}
		
		//zeichen von Partikeln
		g.setColor(Shop.getTheme());
		try {
			for (Particle p : particles) {
			    g.fillRect((int)p.getX(), (int)p.getY(), p.getSize(), p.getSize());
			}
		} catch (Exception e) {}
		
		
		repaint();
	}
	
}
