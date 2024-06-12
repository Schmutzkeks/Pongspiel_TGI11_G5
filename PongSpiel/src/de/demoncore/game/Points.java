package de.demoncore.game;

import de.demoncore.gui.Shop;

public class Points {
		private int punktePlayer;
		private int punkteGegner;
		private int punkteShop = punktePlayer - punkteGegner;
	
	
		public static Points instancePoints;
		
	public Points() {
		
		instancePoints = this;
		punktePlayer = 0;
		punkteGegner = 0;
		punkteShop=0;
	}


	public int getPunktePlayer() {
		return punktePlayer;
	}
	public void setPunktePlayer(int points) {
		this.punktePlayer = points;
	}
	public void addPunktePlayer(int points) {
		this.punktePlayer += points;
		StatsData.addPositivPunkte(1);

        GameLogic.getPlayer2().istAktiviert = true;
	}
	
	public int getPunkteGegner() {
		return punkteGegner;
	}
	public void setPunkteGegner(int points) {
		this.punkteGegner = points;
	}
	public void addPunkteGegner(int points) {
		this.punkteGegner += points;
		StatsData.addNegativPunkte(1);
	}
	public int getPunkteShop() {
		return punkteShop;
	}
	public void setPunkteShop(int Points) {
		this.punkteShop += Points;
		Shop.updateStats();
	
	}
	
}
