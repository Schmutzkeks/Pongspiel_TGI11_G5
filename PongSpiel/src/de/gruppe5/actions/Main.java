package de.gruppe5.actions;

import de.gruppe5.game.MusicPlayer;
import de.gruppe5.gameObjects.Timer1Sek;
import de.gruppe5.gui.StartScreen;

public class Main {

	public static void main(String[] args) {
		StartScreen.erstellen();
		Timer1Sek.startTimer();
		MusicPlayer.init();
	}

}
