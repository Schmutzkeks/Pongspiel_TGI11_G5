package de.gruppe5.game;

import javax.print.DocFlavor.BYTE_ARRAY;

import de.gruppe5.actions.SaveableValue;

public class StatsData {
		public static SaveableValue<Integer> Playtime = new SaveableValue<Integer>(0, "stats.timer");	//in sekunden
		private static SaveableValue<Integer> PositivPunkte = new SaveableValue<Integer>(0, "stats.addpoints");
		private static SaveableValue<Integer> NegativPunkte = new SaveableValue<Integer>(0, "stats.subpoints");
		
		private static SaveableValue<Integer> PositivPunkteAllTime = new SaveableValue<Integer>(0, "stats.addpointsat");
		private static SaveableValue<Integer> NegativPunkteAllTime = new SaveableValue<Integer>(0, "stats.subpointsat");

		public static String getPlaytime(int Playtime) {
	        int hours = Playtime / 3600;
	        int minutes = (Playtime % 3600) / 60;
	        int seconds = Playtime % 60;
	        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
		}
		
		public static void addPlaytime(int playtime) {
			Playtime.setValue(Playtime.getValue() + playtime);
		}

		public static int getPositivPunkte() {
			return PositivPunkte.getValue();
		}

		public static int getPositivPunkteAllTime() {
			return PositivPunkteAllTime.getValue();
		}
		
		public static void addPositivPunkte(int positivPunkte) {
			PositivPunkte.setValue(PositivPunkte.getValue() + positivPunkte);
			PositivPunkteAllTime.setValue(PositivPunkteAllTime.getValue() + positivPunkte);
		}

		public static int getNegativPunkte() {
			return NegativPunkte.getValue();
		}

		public static int getNegativPunkteAllTime() {
			return NegativPunkteAllTime.getValue();
		}
		
		public static void addNegativPunkte(int negativPunkte) {
			NegativPunkte.setValue(NegativPunkte.getValue() + negativPunkte);
			NegativPunkteAllTime.setValue(NegativPunkteAllTime.getValue() + negativPunkte);
		}
		
		public static int getShopPunkte() {
			return PositivPunkte.getValue() - NegativPunkte.getValue();
		}
		
		public static void reset() {
			PositivPunkte.setValue(0);
			NegativPunkte.setValue(0);
		}
}
