package de.demoncore.game;

public class Points {
		private int punktePlayer;
		private int punkteGegner;
	
	
	public Points() {
		punktePlayer = 0;
		punkteGegner = 0;
	}


	public int getPunktePlayer() {
		return punktePlayer;
	}
	public void setPunktePlayer(int points) {
		this.punktePlayer = points;
	}
	public void addPunktePlayer(int points) {
		this.punktePlayer += points;
	}
	
	public int getPunkteGegner() {
		return punkteGegner;
	}
	public void setPunkteGegner(int points) {
		this.punkteGegner = points;
	}
	public void addPunkteGegner(int points) {
		this.punkteGegner += points;
	}
}