package de.demoncore.gameObjects;

import java.util.Timer;
import java.util.TimerTask;

import de.demoncore.game.GameLogic;
import de.demoncore.gui.Gui;
import de.demoncore.gui.Stats;

public class Timer1Sek {
	static Timer timer = new Timer();
	public static void startTimer() {
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if(!GameLogic.BallContinue) {	//wenn Ball pausiert
					try {
						Gui.startCountdown();
					} catch (Exception e) {}
				}
				
				
				StatsData.addPlaytime(1);
				if(Stats.isExistig()) {
					Stats.updateStats();
				}
				
			}
		}, 0, 1000);

	}
}
