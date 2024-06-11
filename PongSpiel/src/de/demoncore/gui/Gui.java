package de.demoncore.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.demoncore.actions.KeyHandler;
import de.demoncore.game.GameLogic;
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
	static JLabel lbPointsPlayer;
	static JLabel lbPointsGegner;
	static JLabel lbCountdown;
	private static int countdown =0;
	public static boolean Paused = false;
	private static boolean startedCountdown= false;
	public static boolean Existing=false;

	public static void erstellen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Gui(spiellogik);
					frame.setLocationRelativeTo(null);
					Existing=true;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Gui(GameLogic spiellogik) {

		screenwidth = 800;
		screenheight = 800;
		spiellogik.screenwidth = screenwidth;
		spiellogik.screenheight = screenheight;

		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				togglePauseMenu();
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
					togglePauseMenu();
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

		JLabel pauseLabel = new JLabel("Pausiert");
		pauseLabel.setFont(new Font("Tahoma", Font.BOLD, 50));
		pauseLabel.setForeground(Shop.getTheme());
		pauseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pauseLabel.setBounds(200, 50, 400, 100);
		pauseMenu.add(pauseLabel);

		JButton btnContinue = new JButton("Fortsetzen"); 
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

		JButton btnBack = new JButton("Hauptmenü"); 
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				togglePauseMenu();
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

		JButton btnEnd = new JButton("Spiel Beenden"); 
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
		btnEnd.setBounds(screenwidth/2-63, 375, 126, 23);
		pauseMenu.add(btnEnd);
		
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

		if(Shop.getWeapon())
			frame.add(lblweapon);

		
		frame.add(pauseMenu);
		frame.add(lbPointsPlayer);
		frame.add(lbPointsGegner);
		frame.add(lbCountdown);
		frame.add(lbTextPlayer);
		frame.add(lbTextGegner);
		frame.add(lbldraw);
	
		frame.setVisible(true);
	}

	public static void togglePauseMenu() {
		boolean isPaused = pauseMenu.isVisible();
		pauseMenu.setVisible(!isPaused);
		if (isPaused) {
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
		System.out.println("ausgeführt "+ countdown);
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



}
