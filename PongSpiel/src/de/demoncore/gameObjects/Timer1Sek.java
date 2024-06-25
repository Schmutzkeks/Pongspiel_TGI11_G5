package de.demoncore.gameObjects;

import java.util.Timer;
import java.util.TimerTask;

import de.demoncore.game.GameLogic;
import de.demoncore.game.StatsData;
import de.demoncore.gui.Gui;
import de.demoncore.gui.Stats;

public class Timer1Sek {
	static Timer timer = new Timer();
	public static void startTimer() {
		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				if(!GameLogic.BallContinue && !Gui.Paused) {	//wenn Ball pausiert
					if(Gui.Existing==true) {
						try {
							Gui.startCountdown();
						} catch (Exception e) {}
					}
				}


				StatsData.addPlaytime(1);
				if(Stats.isExistig()) {
					Stats.updateStats();
				}
				
				if(GameLogic.timeLeft == 1 && GameLogic.BallContinue) {
					GameLogic.timeLeft=0;
					Gui.GameEnd();
				}
				
				if(GameLogic.timeLeft > 1 && GameLogic.BallContinue) {
					GameLogic.timeLeft-=1;
					try {
						Gui.setTime();
					} catch (Exception e) {}
				}
			}
		}, 0, 1000);

	}
}
