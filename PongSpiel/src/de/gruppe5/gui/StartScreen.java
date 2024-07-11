package de.gruppe5.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;

import de.gruppe5.actions.SaveableValue;
import de.gruppe5.game.GameLogic;
import de.gruppe5.game.MusicPlayer;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class StartScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static StartScreen frame;
	int ingamescrwidth = 800;
	int ingamescrheight = 800;
	private static JPanel settings;
	private static JLabel lbTitle;
	private static JButton btnStartGame;
	private static JButton btnShop;
	private static JButton btnStats;
	private static JButton btnZeitmodus;
	private static JButton btn2Player;
	private static JLabel lbstats;
	private static JLabel lbshop;
	public static Font customFont;
	private static JLabel hoverImageLabel;
	private static JLabel hoverImageLabel2;
	private static JLabel hoverImageLabel3;

	/**
	 * Launch the application.
	 */
	public static void erstellen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StartScreen();
					frame.requestFocusInWindow();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StartScreen() {
		//Load DOOM Font
		try {
			// Load the custom font from the file
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("src/resources/font/Doom2016Text-GOlBq.ttf"));//.deriveFont(80f);
			// Register the font
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
			// If the custom font fails to load, fall back to a default font
			customFont = new Font("Tahoma", Font.BOLD, 30);
		}





		setResizable(false);
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);

		settings = new JPanel();
		settings.setVisible(false);

		lbshop = new JLabel();
		lbshop.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Shop.erstellen();
				frame.dispose();
			}
		});
		lbshop.setIcon(new ImageIcon(StartScreen.class.getResource("/resources/cart.png")));
		lbshop.setRequestFocusEnabled(false);
		lbshop.setBorder(null);
		lbshop.setBounds(266, 271, 50, 50);

		contentPane.add(lbshop);
		settings.setBounds(0, 0, ingamescrwidth, ingamescrheight);
		settings.setBackground(new Color(0, 0, 0));
		settings.setLayout(null);
		getContentPane().add(settings);

		JLabel lbSettings = new JLabel();
		lbSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(settings.isVisible()) {
					return;
				}
				toggleSettings();
			}
		});
		lbSettings.setBorder(null);
		lbSettings.setRequestFocusEnabled(false);
		lbSettings.setIcon(new ImageIcon(StartScreen.class.getResource("/resources/settings.png")));
		lbSettings.setBackground(Color.black);
		lbSettings.setBounds(10, 10, 50, 50);
		contentPane.add(lbSettings);

		JLabel lbSettings1 = new JLabel();
		lbSettings1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(!settings.isVisible()) {
					return;
				}
				toggleSettings();
			}
		});
		lbSettings1.setBorder(null);
		lbSettings1.setRequestFocusEnabled(false);
		lbSettings1.setIcon(new ImageIcon(StartScreen.class.getResource("/resources/settings.png")));
		lbSettings1.setBackground(Color.black);
		lbSettings1.setBounds(10, 10, 50, 50);
		settings.add(lbSettings1);

		JLabel title2 = new JLabel("Einstellungen");
		//title2.setFont(new Font("Tahoma", Font.BOLD, 50));
		title2.setFont(customFont.deriveFont(80f));
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

		lbTitle = new JLabel("Pong");
		lbTitle.setFont(customFont.deriveFont(120f));
		//lbTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setForeground(new Color(255, 255, 255));
		lbTitle.setBounds(0, 35, 784, 100);
		contentPane.add(lbTitle);




		//Load Image
		ImageIcon hoverImageIcon = new ImageIcon(StartScreen.class.getResource("/resources/Pong.png"));  
		hoverImageLabel = new JLabel(hoverImageIcon);  
		hoverImageLabel.setBounds(161, 380, hoverImageIcon.getIconWidth(), hoverImageIcon.getIconHeight());
		hoverImageLabel.setVisible(false); // Initially hidden
		contentPane.add(hoverImageLabel);



		btnStartGame = new JButton("Main Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui.erstellen(false, false);
				GameLogic.createObjects();
				GameLogic.getPlayer2().positionX = 50;
				GameLogic.getPlayer3().positionX = -50;
				Gui.countdown = 0;
				GameLogic.BallContinue=false;
				GameLogic.setPlayerContinue(true);
				Gui.Paused = false;
				frame.dispose();
			}
		});
		btnStartGame.setFocusable(false);
		btnStartGame.setFocusTraversalKeysEnabled(false);
		btnStartGame.setFocusPainted(false);
		btnStartGame.setBorder(null);
		btnStartGame.setBackground(new Color(255, 255, 255));
		btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStartGame.setBounds(338, 233, 126, 23);
		contentPane.add(btnStartGame);

		// Add mouse listener to the button
		btnStartGame.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hoverImageLabel.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hoverImageLabel.setVisible(false);
			}
		});


		/*
		btnShop = new JButton("Shop");
		btnShop.setBackground(new Color(255, 255, 255));
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Shop.erstellen();
				frame.dispose();
			}
		});
		btnShop.setBorder(null);
		btnShop.setFocusable(false);
		btnShop.setFocusPainted(false);
		btnShop.setFocusTraversalKeysEnabled(false);
		btnShop.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnShop.setBounds(338, 425, 126, 23);
		contentPane.add(btnShop);

		btnStats = new JButton("Statistiken");
		btnStats.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stats.erstellen();
				frame.dispose();
			}
		});
		btnStats.setBackground(new Color(255, 255, 255));
		btnStats.setFocusable(false);
		btnStats.setFocusTraversalKeysEnabled(false);
		btnStats.setFocusPainted(false);
		btnStats.setBorder(null);
		btnStats.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStats.setBounds(338, 377, 126, 23);
		contentPane.add(btnStats);*/



		//Load Image
		ImageIcon hoverImageIcon2 = new ImageIcon(StartScreen.class.getResource("/resources/Hourglass_copy.png"));  
		hoverImageLabel2 = new JLabel(hoverImageIcon2);  
		hoverImageLabel2.setBounds(236, 380, hoverImageIcon2.getIconWidth(), hoverImageIcon2.getIconHeight());
		hoverImageLabel2.setVisible(false); // Initially hidden
		contentPane.add(hoverImageLabel2);



		btnZeitmodus = new JButton("Zeitmodus");
		btnZeitmodus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui.erstellen(true, false);
				GameLogic.createObjects();
				GameLogic.getPlayer2().positionX = 50;
				GameLogic.getPlayer3().positionX = -50;
				GameLogic.timeLeft = 180;
				GameLogic.BallContinue=false;
				Gui.countdown = 0;
				GameLogic.setPlayerContinue(true);
				Gui.Paused = false;
				frame.dispose();
			}
		});
		btnZeitmodus.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnZeitmodus.setFocusable(false);
		btnZeitmodus.setFocusTraversalKeysEnabled(false);
		btnZeitmodus.setFocusPainted(false);
		btnZeitmodus.setBorder(null);
		btnZeitmodus.setBackground(Color.WHITE);
		btnZeitmodus.setBounds(338, 281, 126, 23);
		contentPane.add(btnZeitmodus);

		// Add mouse listener to the button
		btnZeitmodus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hoverImageLabel2.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hoverImageLabel2.setVisible(false);
			}
		});



		//Load Image
		ImageIcon hoverImageIcon3 = new ImageIcon(StartScreen.class.getResource("/resources/2Playernewresize.png"));  
		hoverImageLabel3 = new JLabel(hoverImageIcon3);  
		hoverImageLabel3.setBounds(209, 380, hoverImageIcon3.getIconWidth(), hoverImageIcon3.getIconHeight());
		hoverImageLabel3.setVisible(false); // Initially hidden
		contentPane.add(hoverImageLabel3);


		btn2Player = new JButton("2 Spieler");
		btn2Player.addActionListener(new ActionListener() {
			private Thread questionThread;

			public void actionPerformed(ActionEvent e) {

				if(questionThread != null) return;
				questionThread = new Thread() {
					public void run() {
						NukeDialog dialog = new NukeDialog();
						dialog.setVisible(true);
						
						frame.dispose();
						
						if(dialog != null) {
							while(dialog.response == -1) {
								try {
									Thread.currentThread().sleep(1);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}
						}

						Gui.erstellen(true, true);
						GameLogic.Multiplayer = true;
						GameLogic.nukeAllowed = dialog.response == 1;
						GameLogic.createObjects();
						GameLogic.getPlayer2().positionX = -50;
						GameLogic.getPlayer3().positionX = 50;
						GameLogic.timeLeft = 180;
						GameLogic.BallContinue=false;
						Gui.countdown = 0;
						GameLogic.setPlayerContinue(true);
						Gui.Paused = false;
					};
				};
				questionThread.start();
			}
		});
		btn2Player.setFont(new Font("Tahoma", Font.BOLD, 15));
		btn2Player.setFocusable(false);
		btn2Player.setFocusTraversalKeysEnabled(false);
		btn2Player.setFocusPainted(false);
		btn2Player.setBorder(null);
		btn2Player.setBackground(Color.WHITE);
		btn2Player.setBounds(338, 329, 126, 23);
		contentPane.add(btn2Player);

		// Add mouse listener to the button
		btn2Player.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hoverImageLabel3.setVisible(true);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hoverImageLabel3.setVisible(false);
			}
		});



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

		lbstats = new JLabel();
		lbstats.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Stats.erstellen();
				frame.dispose();
			}
		});
		lbstats.setIcon(new ImageIcon(StartScreen.class.getResource("/resources/stats.png")));
		lbstats.setRequestFocusEnabled(false);
		lbstats.setBorder(null);
		lbstats.setBounds(480, 271, 50, 50);
		contentPane.add(lbstats);
	}

	protected void reset() {
		SaveableValue.resetAllValues();
		System.exit(0);
	}

	public static void toggleSettings() {
		settings.setVisible(!settings.isVisible());
		btn2Player.setVisible(!settings.isVisible());
		lbTitle.setVisible(!settings.isVisible());
		btnStartGame.setVisible(!settings.isVisible());
		btnZeitmodus.setVisible(!settings.isVisible());
		lbshop.setVisible(!settings.isVisible());
		lbstats.setVisible(!settings.isVisible());
		/*btnShop.setVisible(!settings.isVisible());
		btnStats.setVisible(!settings.isVisible());
		 */
	}
}
