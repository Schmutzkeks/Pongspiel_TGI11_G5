package de.gruppe5.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;

import de.gruppe5.actions.KeyHandler;
import de.gruppe5.actions.SaveableValue;
import de.gruppe5.game.GameLogic;
import de.gruppe5.game.StatsData;
import de.gruppe5.game.MusicPlayer;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Gui {

	static GameLogic spiellogik = new GameLogic();
	public static int punkteGegner;
	public static int punktePlayer;
	private int screenwidth;
	private int screenheight;
	private static JFrame frame;
	private static JPanel pauseMenu;
	private static JPanel gameEnd;
	private static JPanel settings;
	static JLabel lbPointsPlayer;
	static JLabel lbPointsGegner;
	static JLabel lbCountdown;
	public static int countdown =0;
	public static boolean Paused = false;
	public static boolean startedCountdown= false;
	public static boolean Existing=false;
	private static JLabel timer;
	private static JLabel scores;
	private static JButton btnTitleScreen;
	private static JButton btnEnd;
	private static JButton btnSettings;
	private static JButton btnBack;
	private static JButton btnContinue;

	public static void erstellen(boolean timed) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Gui(spiellogik, timed);
					frame.setLocationRelativeTo(null);
					Existing=true;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui(GameLogic spiellogik, boolean timed) {

		screenwidth = 800;
		screenheight = 800;
		spiellogik.screenwidth = screenwidth;
		spiellogik.screenheight = screenheight;

		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				if(timed && GameLogic.timeLeft == 0) {
					frame.dispose();
				}
				if(settings.isVisible()) {
					toggleSettings();
				}else {
					togglePauseMenu();
				}
			}

			public void windowClosed(WindowEvent e) {
				StartScreen.erstellen();
				Existing=false;
				countdown = 0;
			}
		});
		frame.setSize(screenwidth, screenheight);
		frame.setTitle("Pong");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(new KeyHandler(spiellogik));
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					if(settings.isVisible()) {
						toggleSettings();
					}else {
						togglePauseMenu();
					}
				}
			}
		});
		frame.requestFocus();

		Draw lbldraw = new Draw(spiellogik, screenwidth, screenheight);
		lbldraw.setBounds(0,0, screenwidth, screenheight);
		lbldraw.setVisible(true);

		JLabel lbTextGegner= new JLabel("Gegner");
		lbTextGegner.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTextGegner.setBounds(20, 600, 150, 30);
		lbTextGegner.setForeground(Shop.getTheme());
		lbTextGegner.setVisible(true);

		JLabel lbTextPlayer= new JLabel("Player");
		lbTextPlayer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTextPlayer.setBounds(700, 600, 150, 30);
		lbTextPlayer.setForeground(Shop.getTheme());
		lbTextPlayer.setVisible(true);

		lbPointsGegner= new JLabel("0");
		lbPointsGegner.setFont(new Font("Tahoma", Font.BOLD, 50));
		lbPointsGegner.setBounds(60, 600, 70, 100);
		lbPointsGegner.setForeground(Shop.getTheme());
		lbPointsGegner.setVisible(true);

		lbPointsPlayer= new JLabel("0");
		lbPointsPlayer.setFont(new Font("Tahoma", Font.BOLD, 50));
		lbPointsPlayer.setBounds(700, 600, 70, 100);
		lbPointsPlayer.setForeground(Shop.getTheme());
		lbPointsPlayer.setVisible(true);

		lbCountdown = new JLabel("");
		lbCountdown.setFont(new Font("Tahoma", Font.BOLD, 50));
		lbCountdown.setBounds(200, 600, 400, 100);
		lbCountdown.setForeground(Shop.getTheme());
		lbCountdown.setVisible(true);
		lbCountdown.setHorizontalAlignment(SwingConstants.CENTER);

		pauseMenu = new JPanel();
		pauseMenu.setBounds(0, 0, screenwidth, screenheight);
		pauseMenu.setBackground(new Color(0, 0, 0, 150));
		pauseMenu.setLayout(null);
		pauseMenu.setVisible(false);

		gameEnd = new JPanel();
		gameEnd.setBounds(0, 0, screenwidth, screenheight);
		gameEnd.setBackground(new Color(0, 0, 0));
		gameEnd.setLayout(null);
		gameEnd.setVisible(false);

		settings = new JPanel();
		settings.setBounds(0, 0, screenwidth, screenheight);
		settings.setBackground(new Color(0, 0, 0));
		settings.setLayout(null);
		settings.setVisible(false);

		JLabel pauseLabel = new JLabel("Pausiert");
		pauseLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		pauseLabel.setForeground(Shop.getTheme());
		pauseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pauseLabel.setBounds(200, 50, 400, 100);
		pauseMenu.add(pauseLabel);

		btnContinue = new JButton("Fortsetzen"); 
		btnContinue.setBackground(new Color(255, 255, 255));
		btnContinue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				togglePauseMenu();
			}
		});
		btnContinue.setBorder(null);
		btnContinue.setFocusable(false);
		btnContinue.setFocusPainted(false);
		btnContinue.setFocusTraversalKeysEnabled(false);
		btnContinue.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnContinue.setBounds(screenwidth/2-63, 281, 126, 23);
		pauseMenu.add(btnContinue);

		btnBack = new JButton("Hauptmenü"); 
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//togglePauseMenu();
				frame.dispose();
			}
		});
		btnBack.setBorder(null);
		btnBack.setFocusable(false);
		btnBack.setFocusPainted(false);
		btnBack.setFocusTraversalKeysEnabled(false);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBounds(screenwidth/2-63, 329, 126, 23);
		pauseMenu.add(btnBack);

		btnSettings = new JButton("Einstellungen"); 
		btnSettings.setBackground(new Color(255, 255, 255));
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSettings();//TODO 
			}
		});
		btnSettings.setBorder(null);
		btnSettings.setFocusable(false);
		btnSettings.setFocusPainted(false);
		btnSettings.setFocusTraversalKeysEnabled(false);
		btnSettings.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSettings.setBounds(screenwidth/2-63, 375, 126, 23);
		pauseMenu.add(btnSettings);

		btnEnd = new JButton("Spiel Beenden"); 
		btnEnd.setBackground(new Color(255, 255, 255));
		btnEnd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnEnd.setBorder(null);
		btnEnd.setFocusable(false);
		btnEnd.setFocusPainted(false);
		btnEnd.setFocusTraversalKeysEnabled(false);
		btnEnd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEnd.setBounds(screenwidth/2-63, 420, 126, 23);
		pauseMenu.add(btnEnd);
		
		JButton btnEasy = new JButton("Easy");
		btnEasy.setBounds(27, 563, 100, 30);
		btnEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.botDifficulty = GameLogic.EASY;
			}
		});
		btnEasy.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnEasy.setFocusable(false);
		btnEasy.setFocusTraversalKeysEnabled(false);
		btnEasy.setFocusPainted(false);
		btnEasy.setBorder(null);
		btnEasy.setBackground(Color.WHITE);
		settings.add(btnEasy);

		JButton btnMedium = new JButton("Medium");
		btnMedium.setBounds(137, 563, 100, 30);
		btnMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.botDifficulty = GameLogic.MEDIUM;
			}
		});
		btnMedium.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnMedium.setFocusable(false);
		btnMedium.setFocusTraversalKeysEnabled(false);
		btnMedium.setFocusPainted(false);
		btnMedium.setBorder(null);
		btnMedium.setBackground(Color.WHITE);
		settings.add(btnMedium);

		JButton btnHard = new JButton("Hard");
		btnHard.setBounds(27, 604, 100, 30);
		btnHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.botDifficulty = GameLogic.HARD;
			}
		});
		btnHard.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnHard.setFocusable(false);
		btnHard.setFocusTraversalKeysEnabled(false);
		btnHard.setFocusPainted(false);
		btnHard.setBorder(null);
		btnHard.setBackground(Color.WHITE);
		settings.add(btnHard);


		JButton btnImpossible = new JButton("Impossible");
		btnImpossible.setBounds(137, 604, 100, 30);
		btnImpossible.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.botDifficulty = GameLogic.IMPOSSIBLE;
			}
		});
		btnImpossible.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnImpossible.setFocusable(false);
		btnImpossible.setFocusTraversalKeysEnabled(false);
		btnImpossible.setFocusPainted(false);
		btnImpossible.setBorder(null);
		btnImpossible.setBackground(Color.WHITE);
		settings.add(btnImpossible);

		JButton btnNewButton = new JButton("Reset");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();

			}
		});
		btnNewButton.setBounds(632, 604, 100, 30);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setFocusable(false);
		btnNewButton.setFocusTraversalKeysEnabled(false);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(Color.WHITE);
		settings.add(btnNewButton);	
		
		JLabel lblNewLabel = new JLabel("Bot difficulty:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(37, 522, 186, 30);
		settings.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("<html>Statistiken Zurücksetzen:</html>");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(630, 542, 160, 50);
		settings.add(lblNewLabel_1_1_1);

		JLabel lblweapon = new JLabel("");
		lblweapon.setBounds(525,600, 177, 100);
		lblweapon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!startedCountdown)
					Draw.instance.laserSchuss();
			}
		});
		lblweapon.setIcon(new ImageIcon(Shop.class.getResource("/resources/Weapon.png")));


		JLabel title = new JLabel("Spiel beendet");
		title.setFont(new Font("Tahoma", Font.BOLD, 50));
		title.setForeground(Shop.getTheme());
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setBounds(200, 100, 400, 150);
		gameEnd.add(title);

		JLabel title2 = new JLabel("Einstellungen");
		//title2.setFont(new Font("Tahoma", Font.BOLD, 50));
		title2.setFont(StartScreen.customFont.deriveFont(80f));
		title2.setForeground(Shop.getTheme());
		title2.setHorizontalAlignment(SwingConstants.CENTER);
		title2.setBounds(200, 50, 400, 100);
		settings.add(title2);

		JLabel lbnewJLabel = new JLabel("Lautstärke:");
		lbnewJLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		lbnewJLabel.setForeground(Shop.getTheme());
		lbnewJLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lbnewJLabel.setBounds(37, 185, 400, 50);
		settings.add(lbnewJLabel);

		JSlider sliderVolume = new JSlider();
		sliderVolume.setFocusTraversalKeysEnabled(false);
		sliderVolume.setFocusable(false);
		sliderVolume.setBackground(Color.GRAY);
		sliderVolume.setForeground(Color.GRAY);
		sliderVolume.setSnapToTicks(true);
		sliderVolume.setMajorTickSpacing(2);
		sliderVolume.setMinimum(-60);
		sliderVolume.setMaximum(-10);
		sliderVolume.setValue((int)(float)MusicPlayer.totalVolume.getValue());
		sliderVolume.addChangeListener(e -> {
			float volume = sliderVolume.getValue();
			MusicPlayer.setVolumeAll(volume);
			MusicPlayer.setVolume(GameLogic.backgroundMusic, sliderVolume.getValue()-20);
		});
		sliderVolume.setBounds(441, 200, 160, 26);
		settings.add(sliderVolume);
		
		JLabel lblNewLabel_1_1 = new JLabel("Musik Ein/Aus:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(120, 235, 400, 50);
		settings.add(lblNewLabel_1_1);
		
		JCheckBox chMusicEnabled = new JCheckBox("");
		chMusicEnabled.setBackground(Color.GRAY);
		chMusicEnabled.setForeground(Color.GRAY);
		chMusicEnabled.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GameLogic.MusicEnabled = chMusicEnabled.isSelected();
				MusicPlayer.stopSound(GameLogic.backgroundMusic);
				if(GameLogic.MusicEnabled) {
					MusicPlayer.playSound(GameLogic.backgroundMusic, true);
					MusicPlayer.setVolume(GameLogic.backgroundMusic, MusicPlayer.totalVolume.getValue() - 20);
				}
			}
		});
		chMusicEnabled.setFocusPainted(false);
		chMusicEnabled.setFocusable(false);
		chMusicEnabled.setRequestFocusEnabled(false);
		chMusicEnabled.setBounds(500, 250, 21, 23);
		chMusicEnabled.setSelected(GameLogic.MusicEnabled);
		settings.add(chMusicEnabled);

		scores = new JLabel("Gegner: 00\tPlayer:00\nPlayer gewinnt!");
		scores.setFont(new Font("Tahoma", Font.BOLD, 30));
		scores.setForeground(Shop.getTheme());
		scores.setHorizontalAlignment(SwingConstants.CENTER);
		scores.setBounds(200, 250, 400, 150);
		scores.setVisible(true);
		gameEnd.add(scores);

		btnTitleScreen = new JButton("zurück");
		btnEnd.setBackground(new Color(255, 255, 255));
		btnTitleScreen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GameLogic.setPlayerContinue(true);
			}
		});
		btnTitleScreen.setBorder(null);
		btnTitleScreen.setFocusable(false);
		btnTitleScreen.setFocusPainted(false);
		btnTitleScreen.setFocusTraversalKeysEnabled(false);
		btnTitleScreen.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTitleScreen.setHorizontalAlignment(SwingConstants.CENTER);
		btnTitleScreen.setBounds(300, 400, 200, 25);
		gameEnd.add(btnTitleScreen);



		if(Shop.getWeapon()) {
			frame.add(lblweapon);}

		timer = new JLabel("00:00");
		timer.setFont(new Font("Tahoma", Font.BOLD, 30));
		timer.setForeground(Shop.getTheme());
		timer.setHorizontalAlignment(SwingConstants.CENTER);
		timer.setBounds(200, 50, 400, 100);
		timer.setVisible(timed);

		frame.add(settings);
		frame.add(gameEnd);
		frame.add(pauseMenu);
		frame.add(lbPointsPlayer);
		frame.add(lbPointsGegner);
		frame.add(lbCountdown);
		frame.add(lbTextPlayer);
		frame.add(lbTextGegner);
		frame.add(timer);
		frame.add(lbldraw);
		setTime();

		frame.setVisible(true);
	}

	public static void togglePauseMenu() {
		boolean isPaused = pauseMenu.isVisible();
		pauseMenu.setVisible(!isPaused);
		if (isPaused && !gameEnd.isVisible()) {
			GameLogic.BallContinue=!startedCountdown;
			GameLogic.setPlayerContinue(true);
			Paused = false;
			frame.requestFocus();
		} else {
			GameLogic.BallContinue=false;
			GameLogic.setPlayerContinue(false);
			Paused = true;
		}
	}

	public static void refreshPoints() {
		lbPointsGegner.setText(punkteGegner+"");
		lbPointsPlayer.setText(punktePlayer+"");
	}

	public static void startCountdown() {
		if(gameEnd.isVisible()) {
			return;
		}
		if(countdown ==0) {
			startedCountdown = true;
			lbCountdown.setText("Achtung");
		}else if(countdown==1) {
			lbCountdown.setText("Fertig");
		}else if(countdown ==2) {
			lbCountdown.setText("Los");
		}else {
			lbCountdown.setText("");
			GameLogic.BallContinue=true;
			startedCountdown = false;
			countdown=-1;
		}
		countdown++;
	}

	public static void setTime(){
		String temp ="<html><div style='text-align: center;'>Verbleibende Zeit: <br>"+StatsData.getPlaytime(GameLogic.timeLeft)+"</div></html>";
		timer.setText(temp);
	}

	public static void GameEnd() {
		GameLogic.BallContinue = false;
		GameLogic.setPlayerContinue(false);
		gameEnd.setVisible(true);
		String winner;
		if(punktePlayer>punkteGegner) {
			winner = "Spieler hat gewonnen";
		}else if( punktePlayer<punkteGegner) {
			winner = "Gegner hat gewonnen";
		}else {
			winner = "Unentschieden";
		}

		String temp ="<html><div style='text-align: center;'> Gegner:"+punkteGegner+"&nbsp &nbsp &nbsp Spieler:"+punktePlayer+"<br> <br>"+winner+"</div></html>";
		scores.setText(temp);
	}

	public static void toggleSettings() {
		settings.setVisible(!settings.isVisible());
		btnBack.setEnabled(!settings.isVisible());
		btnContinue.setEnabled(!settings.isVisible());
		btnEnd.setEnabled(!settings.isVisible());
		btnSettings.setEnabled(!settings.isVisible());
		btnTitleScreen.setEnabled(!settings.isVisible());
	}
	
	protected void reset() {
		SaveableValue.resetAllValues();
		System.exit(0);
	}

}
