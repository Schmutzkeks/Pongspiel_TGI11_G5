package de.demoncore.game;

public class GameObject {
	
	
	// position in Vector ändern
	// eine Update Methode machen
	public int groesseX;
	public int groesseY;
	
	public int positionX;
	public int positionY;
	

	public GameObject(int posX, int posY, int breite, int hoehe) {
		positionX = posX;
		positionY = posY;
		groesseX = breite;
		groesseY = hoehe;
	}

}
