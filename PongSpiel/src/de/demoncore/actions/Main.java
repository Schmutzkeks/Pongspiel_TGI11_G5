package de.demoncore.actions;

import de.demoncore.game.MusicPlayer;
import de.demoncore.gameObjects.Timer1Sek;
import de.demoncore.gui.StartScreen;

public class Main {

	public static void main(String[] args) {
		StartScreen.erstellen();
		Timer1Sek.startTimer();
		MusicPlayer.init();
	}

}
