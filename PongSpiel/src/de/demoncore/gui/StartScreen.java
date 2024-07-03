package de.demoncore.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import de.demoncore.game.GameLogic;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	static StartScreen frame;
	int ingamescrwidth = 800;
	int ingamescrheight = 800;

	/**
	 * Launch the application.
	 */
	public static void erstellen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new StartScreen();
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
		setResizable(false);
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbTitle = new JLabel("Pong");
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setForeground(new Color(255, 255, 255));
		lbTitle.setBounds(0, 40, 784, 54);
		contentPane.add(lbTitle);
		
		JButton btnStartGame = new JButton("Main Game");
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui.erstellen(false);
				GameLogic.createObjects();
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
		btnStartGame.setBounds(ingamescrwidth/2-63, 281, 126, 23);
		contentPane.add(btnStartGame);
		
		JButton btnShop = new JButton("Shop");
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
		btnShop.setBounds(337, 416, 126, 23);
		contentPane.add(btnShop);
		
		JButton btnStats = new JButton("Statistiken");
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
		btnStats.setBounds(ingamescrwidth/2-63, 375, 126, 23);
		contentPane.add(btnStats);
		
		JButton btnZeitmodus = new JButton("Zeitmodus");
		btnZeitmodus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Gui.erstellen(true);
				GameLogic.createObjects();
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
		btnZeitmodus.setBounds(337, 329, 126, 23);
		contentPane.add(btnZeitmodus);
	
		

        JButton btnEasy = new JButton("Easy");
        btnEasy.setBounds(43, 623, 90, 30);
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
        contentPane.add(btnEasy);

        JButton btnMedium = new JButton("Medium");
        btnMedium.setBounds(143, 623, 90, 30);
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
        contentPane.add(btnMedium);

        JButton btnHard = new JButton("Hard");
        btnHard.setBounds(243, 623, 100, 30);
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
        contentPane.add(btnHard);
        
        
        JButton btnimpossible = new JButton("Impossible");
        btnimpossible.setBounds(353, 623, 100, 30);
        btnimpossible.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                GameLogic.botDifficulty = GameLogic.IMPOSSIBLE;
            }
        });
        btnimpossible.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnimpossible.setFocusable(false);
        btnimpossible.setFocusTraversalKeysEnabled(false);
        btnimpossible.setFocusPainted(false);
        btnimpossible.setBorder(null);
        btnimpossible.setBackground(Color.WHITE);
        contentPane.add(btnimpossible);
    }
	
	
	
}
