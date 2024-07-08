package de.gruppe5.game;

import de.gruppe5.actions.SaveableValue;
import de.gruppe5.gui.Shop;

public class Points {

	SaveableValue<Integer> punktePlayer = new SaveableValue<Integer>(0, "player.point");
	SaveableValue<Integer> punkteGegner = new SaveableValue<Integer>(0, "enemy.point");

	public static Points instancePoints;

	public Points() {
		instancePoints = this;
	}


	public int getPunktePlayer() {
		return punktePlayer.getValue();
	}
	
	public void setPunktePlayer(int points) {
		this.punktePlayer.setValue(points);
	}
	
	public void addPunktePlayer(int points) {
		this.punktePlayer.setValue(this.punktePlayer.getValue()+ points);
		StatsData.addPositivPunkte(Shop.getDoublePoints() ? 2 : 1);

		GameLogic.getPlayer2().istAktiviert = true;
	}

	public int getPunkteGegner() {
		return punkteGegner.getValue();
	}
	
	public void setPunkteGegner(int points) {
		this.punkteGegner.setValue(points);
	}
	
	public void addPunkteGegner(int points) {
		this.punkteGegner.setValue(this.punkteGegner.getValue()+ points);
		StatsData.addNegativPunkte(1);
	}
	
	public int getPunkteShop() {
		return (punktePlayer.getValue()- punkteGegner.getValue())>0?(punktePlayer.getValue()- punkteGegner.getValue()):0;
	}

}
