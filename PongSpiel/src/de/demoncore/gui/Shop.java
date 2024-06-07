package de.demoncore.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;

public class Shop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static int Theme = 0;
	private JLabel lbWhite;
	private JLabel lbBlue;
	private JLabel lbLightGreen;
	private JLabel lbCyan;
	private JLabel lbMagenta;
	private JLabel lbRed;
	private JLabel lbYellow;
	private JLabel lbDarkGreen;
	private JScrollPane scrollPane;
	private JPanel panel;
	private JLabel lblweapon;
	private JLabel lblBallSpeed;
	private JLabel lblPlayerSize;
	private JLabel lblclone;
	private JLabel lblDP;
	private JLabel lblWaffe;
	private JLabel lblballspeed;
	private JLabel lblSpSize;
	private JLabel lblKlon;
	
	/**
	 * Launch the application.
	 */
	public static void erstellen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Shop frame = new Shop();
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
	public Shop() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				StartScreen.erstellen();
			}
		});
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.getHorizontalScrollBar().setUI(null);
		scrollPane.getHorizontalScrollBar().setUnitIncrement(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 225, 784, 20);
		contentPane.add(separator);
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setOpaque(true);
		separator.setBackground(new Color(255, 255, 255));
		
		scrollPane.setBorder(null);
		scrollPane.setBackground(new Color(255, 255, 255));
		scrollPane.setForeground(new Color(0, 0, 0));
		scrollPane.setBounds(0, 125, 784, 100);
		scrollPane.setOpaque(false);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		panel.setPreferredSize(new Dimension(1000, 100));
		panel.setBorder(null);
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 0));
		scrollPane.setViewportView(panel);
		
		System.out.println();
		
		JLabel lbTitleShop = new JLabel("Shop");
		lbTitleShop.setBounds(0, 40, 784, 49);
		lbTitleShop.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitleShop.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbTitleShop.setForeground(new Color(255, 255, 255));
		contentPane.add(lbTitleShop);
		
		lbWhite = new JLabel("");
		lbWhite.setBounds(20, 10, 50, 50);
		lbWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 0;
				clearBorder();
				lbWhite.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		panel.setLayout(null);
		panel.setLayout(null);
		lbWhite.setBackground(Color.WHITE);
		lbWhite.setOpaque(true);
		lbWhite.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbWhite);
		
		lbBlue = new JLabel("");
		lbBlue.setBounds(90, 10, 50, 50);
		lbBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 1;
				clearBorder();
				lbBlue.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbBlue.setOpaque(true);
		lbBlue.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbBlue.setBackground(Color.BLUE);
		panel.add(lbBlue);
		
		lbLightGreen = new JLabel("");
		lbLightGreen.setBounds(160, 10, 50, 50);
		lbLightGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 2;
				clearBorder();
				lbLightGreen.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbLightGreen.setOpaque(true);
		lbLightGreen.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbLightGreen.setBackground(Color.GREEN);
		panel.add(lbLightGreen);
		
		lbCyan = new JLabel("");
		lbCyan.setBounds(230, 10, 50, 50);
		lbCyan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 3;
				clearBorder();
				lbCyan.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbCyan.setOpaque(true);
		lbCyan.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbCyan.setBackground(Color.CYAN);
		panel.add(lbCyan);
		
		lbMagenta = new JLabel("");
		lbMagenta.setBounds(300, 10, 50, 50);
		lbMagenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 4;
				clearBorder();
				lbMagenta.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbMagenta.setOpaque(true);
		lbMagenta.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbMagenta.setBackground(Color.MAGENTA);
		panel.add(lbMagenta);
		
		lbRed = new JLabel("");
		lbRed.setBounds(370, 10, 50, 50);
		lbRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 5;
				clearBorder();
				lbRed.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		
		lbRed.setOpaque(true);
		lbRed.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbRed.setBackground(new Color(255, 0, 0));
		panel.add(lbRed);
		
		lbYellow = new JLabel("");
		lbYellow.setBounds(440, 10, 50, 50);
		lbYellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 6;
				clearBorder();
				lbYellow.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbYellow.setOpaque(true);
		lbYellow.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbYellow.setBackground(new Color(255, 255, 0));
		panel.add(lbYellow);
		
		lbDarkGreen = new JLabel("");
		lbDarkGreen.setBounds(510, 10, 50, 50);
		lbDarkGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 7;
				clearBorder();
				lbDarkGreen.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbDarkGreen.setOpaque(true);
		lbDarkGreen.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbDarkGreen.setBackground(new Color(0, 128, 0));
		panel.add(lbDarkGreen);
		
		JLabel lbTitlePowerUp = new JLabel("PowerUp's");
		lbTitlePowerUp.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitlePowerUp.setForeground(Color.WHITE);
		lbTitlePowerUp.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbTitlePowerUp.setBounds(0, 267, 784, 49);
		contentPane.add(lbTitlePowerUp);
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(1000, 100));
		panel_1.setBorder(null);
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 346, 1000, 112);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lbldoublepoints = new JLabel("New label");
		lbldoublepoints.setBounds(10, 0, 102, 100);
		lbldoublepoints.setIcon(new ImageIcon(Shop.class.getResource("/recources/2xPoints.jpg")));
		panel_1.add(lbldoublepoints);
		
		lblweapon = new JLabel("");
		lblweapon.setBounds(145, 0, 177, 100);
		lblweapon.setIcon(new ImageIcon(Shop.class.getResource("/recources/Weapon.jpg")));
		panel_1.add(lblweapon);
		
		lblBallSpeed =  new JLabel("");
		lblBallSpeed.setBounds(348, 0, 139, 112);
		lblBallSpeed.setIcon(new ImageIcon(Shop.class.getResource("/recources/lowerspeed.jpg")));
		panel_1.add(lblBallSpeed);
		
		lblPlayerSize = new JLabel("");
		lblPlayerSize.setIcon(new ImageIcon(Shop.class.getResource("/recources/PlayerSize.png")));
		lblPlayerSize.setBounds(523, 0, 102, 100);
		panel_1.add(lblPlayerSize);
		
		lblclone = new JLabel("New label");
		lblclone.setIcon(new ImageIcon(Shop.class.getResource("/recources/Klon.jpg")));
		lblclone.setBounds(632, 11, 139, 101);
		panel_1.add(lblclone);
		
		lblDP = new JLabel("Doppelte Punkte");
		lblDP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblDP.setForeground(new Color(255, 255, 255));
		lblDP.setBounds(10, 453, 164, 54);
		contentPane.add(lblDP);
		
		lblWaffe = new JLabel("Waffe");
		lblWaffe.setForeground(Color.WHITE);
		lblWaffe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWaffe.setBounds(167, 453, 93, 54);
		contentPane.add(lblWaffe);
		
		lblballspeed = new JLabel("Veringerte Geschwindigkeit");
		lblballspeed.setForeground(Color.WHITE);
		lblballspeed.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblballspeed.setBounds(285, 447, 255, 67);
		contentPane.add(lblballspeed);
		
		lblSpSize = new JLabel("Spieler Größe");
		lblSpSize.setForeground(Color.WHITE);
		lblSpSize.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSpSize.setBounds(511, 453, 164, 54);
		contentPane.add(lblSpSize);
		
		lblKlon = new JLabel("Ball Klonen");
		lblKlon.setForeground(Color.WHITE);
		lblKlon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblKlon.setBounds(655, 453, 164, 54);
		contentPane.add(lblKlon);
		
		
		JLabel[] borderLabels = {lbWhite,lbBlue,lbLightGreen,lbCyan,lbMagenta,lbRed,lbYellow,lbDarkGreen};
		borderLabels[Theme].setBorder(new LineBorder(new Color(255, 128, 0), 5));
	}
	
	private void clearBorder() {
		lbWhite.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbBlue.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbLightGreen.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbCyan.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbMagenta.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbRed.setBorder(new LineBorder(new Color(255,255,255),5));	
		lbYellow.setBorder(new LineBorder(new Color(255,255,255),5));	
		lbDarkGreen.setBorder(new LineBorder(new Color(255,255,255),5));	
		
		System.out.println();
	}
	

	
	public static Color getTheme() {
		switch (Theme) {
		case 0: return Color.white;
		case 1: return Color.blue;
		case 2: return Color.green;
		case 3: return Color.cyan;
		case 4: return Color.magenta;
		case 5: return Color.red;
		case 6: return Color.yellow;
		case 7: return new Color(0f,0.5f,0f,1f);
		default:
			throw new IllegalArgumentException("Unexpected value: " + Theme);
			
		}
	}
}
