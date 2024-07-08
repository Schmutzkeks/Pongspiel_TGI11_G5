package de.gruppe5.game;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MusicPlayer {
	private static Clip clip;
	public static float totalVolume = -20F;
	static String[] fileLocations = {"/resources/music/bg1.wav","/resources/music/bg2.wav","/resources/music/pong.wav","/resources/music/pop.wav"};

	static ArrayList<Clip> clipsType1 = new ArrayList<Clip>();
	static ArrayList<Clip> clipsType2 = new ArrayList<Clip>();
	static ArrayList<Clip> clipsType3 = new ArrayList<Clip>();
	static ArrayList<Clip> clipsType4 = new ArrayList<Clip>();

	static ArrayList<FloatControl> volumeType1 = new ArrayList<FloatControl>();
	static ArrayList<FloatControl> volumeType2 = new ArrayList<FloatControl>();
	static ArrayList<FloatControl> volumeType3 = new ArrayList<FloatControl>();
	static ArrayList<FloatControl> volumeType4 = new ArrayList<FloatControl>();
	
	static ArrayList<ArrayList<Clip>> Lists = new ArrayList<ArrayList<Clip>>();
	static ArrayList<ArrayList<FloatControl>> volumeControlsLists = new ArrayList<ArrayList<FloatControl>>();

	public static void init() {
		Lists.clear();
		//Musik dateien
		Lists.add(clipsType1);
		Lists.add(clipsType2);
		Lists.add(clipsType3);
		Lists.add(clipsType4);

		//Lautstärke für clips
		volumeControlsLists.add(volumeType1);
		volumeControlsLists.add(volumeType2);
		volumeControlsLists.add(volumeType3);
		volumeControlsLists.add(volumeType4);
	}


	public static void playSound(int fileNR, boolean loop) {
		try {
			// Music datei laden
			InputStream audioSrc = MusicPlayer.class.getResourceAsStream(fileLocations[fileNR]);
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioSrc);
			clip = AudioSystem.getClip();
			//Datei abspielen
			clip.open(audioStream);
			clip.start();
			if(loop) {	//evt mit loop
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			}
			FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);;
			
			//Lautstärke der Datei anpassen
			Lists.get(fileNR).add(clip);
			volumeControlsLists.get(fileNR).add(volumeControl);

			setVolume(fileNR, totalVolume);
		}	 
		catch (UnsupportedAudioFileException | IOException | LineUnavailableException e)
		{
			e.printStackTrace();
		}
	}
	public static void pauseSound(int fileNR) {		//pausieren einer Musik Dateien art
	    for (Clip clip : Lists.get(fileNR)) {
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	        }
	    }
	}

	public static void continueSound(int fileNR) {	//fortsetzen einer Musik Dateien Art
	    for (Clip clip : Lists.get(fileNR)) {
	        if (clip != null && !clip.isRunning()) {
	            clip.start();
	        }
	    }
	}

	public static void stopSound(int fileNR) {		//stopen einer Musik Dateien art
	    for (Clip clip : Lists.get(fileNR)) {
	        if (clip != null && clip.isRunning()) {
	            clip.stop();
	            clip.close();
	        }
	    }
	}

	public static void pauseAllSound() {	//pausieren aller Sounds
	    for (int fileNR = Lists.size() - 1; fileNR >= 0; fileNR--) {
	        for (int i = Lists.get(fileNR).size() - 1; i >= 0; i--) {
	            Clip clip = Lists.get(fileNR).get(i);
	            if (clip != null && clip.isRunning()) {
	                clip.stop();
	            }
	        }
	    }
	}

	public static void continueAllSound() {		//Fortsetzen aller Sounds
	    for (int fileNR = Lists.size() - 1; fileNR >= 0; fileNR--) {
	        for (int i = Lists.get(fileNR).size() - 1; i >= 0; i--) {
	            Clip clip = Lists.get(fileNR).get(i);
	            if (clip != null && !clip.isRunning()) {
	                clip.start();
	            }
	        }
	    }
	}

	public static void stopAllSound() {		//stopen aller Sounds
		for(int fileNR = Lists.size()-1; fileNR>=0;fileNR--) {
			for(int i = Lists.get(fileNR).size()-1; i>=0;i--) {
				if(Lists.get(fileNR).get(0) != null && Lists.get(fileNR).get(0).isRunning()) {
					Lists.get(fileNR).get(i).stop();
					Lists.get(fileNR).get(i).close();
					Lists.get(fileNR).remove(i);
				}
			}
		}
	}

	public static void setVolume(int fileNR, float volume) {	//Einstellen der Lautstärke  einer Musik Datei Art
		ArrayList<FloatControl> volumeControlsList = volumeControlsLists.get(fileNR);
		for(int i = volumeControlsList.size()-1;i>=0;i--) {
			FloatControl volumeControl = volumeControlsList.get(i);
			if (volumeControl != null && volume>-80 && volume<-10) {
				volumeControl.setValue(volume);
			}
		}
	}

	public static void setVolumeAll(float volume) {		//Allgemeine Lautstärke für alle SOunds setzen
		totalVolume = volume;
		for(int i = volumeControlsLists.size()-1; i>=0;i--) {
			ArrayList<FloatControl> volumeControlsList = volumeControlsLists.get(i);
			for (FloatControl volumeControl : volumeControlsList) {
				if (volumeControl != null && volume>-80 && volume<-10) {
					volumeControl.setValue(volume);
				}
			}
		}
	}

	public static float getVolume(int fileType) {	//Lautstärke einer Datei Art erhalten
		return volumeControlsLists.get(fileType).get(0).getValue();
	}
}