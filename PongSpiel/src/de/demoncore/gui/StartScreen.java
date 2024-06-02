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
				Gui.erstellen();
				GameLogic.createObjects();
				frame.dispose();
			}
		});
		btnStartGame.setFocusable(false);
		btnStartGame.setFocusTraversalKeysEnabled(false);
		btnStartGame.setFocusPainted(false);
		btnStartGame.setBorder(null);
		btnStartGame.setBackground(new Color(255, 255, 255));
		btnStartGame.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnStartGame.setBounds(330, 281, 126, 23);
		contentPane.add(btnStartGame);
		
		JButton btnButton1 = new JButton("Beispiel 1");
		btnButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Beispiel1.erstellen();
				frame.dispose();
			}
		});
		btnButton1.setBorder(null);
		btnButton1.setFocusable(false);
		btnButton1.setFocusPainted(false);
		btnButton1.setFocusTraversalKeysEnabled(false);
		btnButton1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnButton1.setBounds(330, 329, 126, 23);
		contentPane.add(btnButton1);
		
		JButton btnButton2 = new JButton("Beispiel 2");
		btnButton2.setFocusable(false);
		btnButton2.setFocusTraversalKeysEnabled(false);
		btnButton2.setFocusPainted(false);
		btnButton2.setBorder(null);
		btnButton2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnButton2.setBounds(330, 375, 126, 23);
		contentPane.add(btnButton2);
	}
}
