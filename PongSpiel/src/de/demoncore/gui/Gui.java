package de.demoncore.gui;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JLabel;

import de.demoncore.actions.KeyHandler;
import de.demoncore.game.Collision;
import de.demoncore.game.GameLogic;
import java.awt.Font;

public class Gui {
	
	public static int punkteGegner;
	public static int punktePlayer;
	private int screenwidth;
	private int screenheight;
	private JFrame frame;
	static JLabel lbPointsPlayer;
	static JLabel lbPointsGegner;
	
	public Gui(GameLogic spiellogik) {
		
		screenwidth = 800;
		screenheight = 800;
		spiellogik.screenwidth = screenwidth;
		spiellogik.screenheight = screenheight;
		
		frame = new JFrame();
		frame.setSize(screenwidth, screenheight);
		frame.setTitle("Pong");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
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
		lbTextGegner.setForeground(Color.WHITE);
		lbTextGegner.setVisible(true);
		
		JLabel lbTextPlayer= new JLabel("Player");
		lbTextPlayer.setFont(new Font("Tahoma", Font.BOLD, 20));
		lbTextPlayer.setBounds(700, 600, 150, 30);
		lbTextPlayer.setForeground(Color.WHITE);
		lbTextPlayer.setVisible(true);
		
		lbPointsGegner= new JLabel("0");
		lbPointsGegner.setFont(new Font("Tahoma", Font.BOLD, 50));
		lbPointsGegner.setBounds(60, 600, 50, 100);
		lbPointsGegner.setForeground(Color.WHITE);
		lbPointsGegner.setVisible(true);
		
		lbPointsPlayer= new JLabel("0");
		lbPointsPlayer.setFont(new Font("Tahoma", Font.BOLD, 50));
		lbPointsPlayer.setBounds(700, 600, 50, 100);
		lbPointsPlayer.setForeground(Color.WHITE);
		lbPointsPlayer.setVisible(true);
		
		frame.add(lbPointsPlayer);
		frame.add(lbPointsGegner);
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
	
	

}
