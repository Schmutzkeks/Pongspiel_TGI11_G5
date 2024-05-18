package de.demoncore.actions;

import de.demoncore.game.GameLogic;
import de.demoncore.gui.Gui;

public class Main {

	public static void main(String[] args) {
		GameLogic spiellogik = new GameLogic();
		new Gui(spiellogik);
	}

}
