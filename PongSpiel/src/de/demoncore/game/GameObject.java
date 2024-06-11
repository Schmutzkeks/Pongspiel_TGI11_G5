package de.demoncore.game;

public class GameObject {
	
	
	// position in Vector ändern
	// eine Update Methode machen
	public int groesseX;
	public int groesseY;
	
	public double positionX;
	public double positionY;
	

	public GameObject(double posX, double posY, int breite, int hoehe) {
		positionX = posX;
		positionY = posY;
		groesseX = breite;
		groesseY = hoehe;
	}

}
