package de.demoncore.gameObjects;

public class StatsData {
		private static int Playtime;	//in sekunden
		private static int PositivPunkte;
		private static int NegativPunkte;

		public static String getPlaytime() {
	        int hours = Playtime / 3600;
	        int minutes = (Playtime % 3600) / 60;
	        int seconds = Playtime % 60;
	        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
	    }

		public static void addPlaytime(int playtime) {
			Playtime += playtime;
		}

		public static int getPositivPunkte() {
			return PositivPunkte;
		}

		public static void addPositivPunkte(int positivPunkte) {
			PositivPunkte += positivPunkte;
		}

		public static int getNegativPunkte() {
			return NegativPunkte;
		}

		public static void addNegativPunkte(int negativPunkte) {
			NegativPunkte += negativPunkte;
		}
		
}
