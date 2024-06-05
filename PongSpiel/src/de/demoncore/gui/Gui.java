package de.demoncore.gui;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import de.demoncore.actions.KeyHandler;
import de.demoncore.game.GameLogic;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.concurrent.CountDownLatch;

public class Gui {
	
	static GameLogic spiellogik = new GameLogic();
	public static int punkteGegner;
	public static int punktePlayer;
	private int screenwidth;
	private int screenheight;
	private static JFrame frame;
	static JLabel lbPointsPlayer;
	static JLabel lbPointsGegner;
	static JLabel lbCountdown;
	private static int countdown =0;
	
	public static void erstellen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new Gui(spiellogik);
					frame.setLocationRelativeTo(null);
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
			public void windowClosed(WindowEvent e) {
				StartScreen.erstellen();
			}
		});
		frame.setSize(screenwidth, screenheight);
		frame.setTitle("Pong");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(new KeyHandler(spiellogik));
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
		
		frame.add(lbPointsPlayer);
		frame.add(lbPointsGegner);
		frame.add(lbCountdown);
		frame.add(lbTextPlayer);
		frame.add(lbTextGegner);
		frame.add(lbldraw);
		
		frame.setVisible(true);
		//New Test
	}
	
	public static void refreshPoints() {
		lbPointsGegner.setText(punkteGegner+"");
		lbPointsPlayer.setText(punktePlayer+"");
	}
	
	public static void startCountdown() {
		if(countdown ==0) {
		lbCountdown.setText("Achtung");
		}else if(countdown==1) {
		lbCountdown.setText("Fertig");
		}else if(countdown ==2) {
		lbCountdown.setText("Los");
		}else {
			lbCountdown.setText("");
		GameLogic.BallContinue=true;
		countdown=-1;
		}
		countdown++;
	}
	
	

}
