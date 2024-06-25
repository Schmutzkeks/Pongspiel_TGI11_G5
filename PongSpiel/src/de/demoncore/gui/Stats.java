package de.demoncore.gui;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.demoncore.game.StatsData;

import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.JSeparator;

public class Stats extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JLabel lbTimePlayed;
	private static boolean existig = false;
	private static JLabel lbNegativPunkte;
	private static JLabel lbPositivPunkte;
	

	/**
	 * Launch the application.
	 */
	public static void erstellen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stats frame = new Stats();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
					existig = true;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Stats() {
		setTitle("Pong");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			public void windowClosed(WindowEvent e) {
				existig = false;
				StartScreen.erstellen();
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Statistiken");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 40, 784, 56);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(0, 0, 0));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(null);
		scrollPane.setBounds(207, 107, 360, 590);
		contentPane.add(scrollPane);
		scrollPane.getVerticalScrollBar().setUI(null);
		scrollPane.getHorizontalScrollBar().setUI(null);
		scrollPane.getVerticalScrollBar().setUnitIncrement(10);		
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(370, 690));
		panel.setBackground(new Color(110, 110, 110));
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		
		lbTimePlayed = new JLabel("");
		lbTimePlayed.setForeground(new Color(255, 255, 255));
		lbTimePlayed.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTimePlayed.setHorizontalAlignment(SwingConstants.CENTER);
		lbTimePlayed.setBounds(20, 20, 320, 50);
		panel.add(lbTimePlayed);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 81, 360, 5);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 158, 360, 5);
		panel.add(separator_1);
		
		lbPositivPunkte = new JLabel("");
		lbPositivPunkte.setHorizontalAlignment(SwingConstants.CENTER);
		lbPositivPunkte.setForeground(Color.WHITE);
		lbPositivPunkte.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbPositivPunkte.setBounds(20, 97, 320, 50);
		panel.add(lbPositivPunkte);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(0, 235, 360, 5);
		panel.add(separator_2);
		
		lbNegativPunkte = new JLabel("<html>Spiel Zeit: <br>00:00:00</html>");
		lbNegativPunkte.setHorizontalAlignment(SwingConstants.CENTER);
		lbNegativPunkte.setForeground(Color.WHITE);
		lbNegativPunkte.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbNegativPunkte.setBounds(20, 174, 320, 50);
		panel.add(lbNegativPunkte);
		updateStats();
	}
	
	
	public static void updateStats() {
		String temp = "<html>Spiel Zeit: <br>" +StatsData.getPlaytime(StatsData.Playtime)+"</html>";
		lbTimePlayed.setText(temp);
		temp ="<html><div style='text-align: center;'>Erzielte Punkte: <br>"+StatsData.getPositivPunkte()+"</div></html>";
		lbPositivPunkte.setText(temp);
		temp ="<html><div style='text-align: center;'>Erlittenen Schaden: <br>" + StatsData.getNegativPunkte() + "</div></html>";
		lbNegativPunkte.setText(temp);
		

	}

	public static boolean isExistig() {
		return existig;
	}

	public static void setExistig(boolean existig) {
		Stats.existig = existig;
	}
}
