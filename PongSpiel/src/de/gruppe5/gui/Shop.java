package de.gruppe5.gui;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.gruppe5.actions.Main;
import de.gruppe5.game.Points;
import de.gruppe5.game.StatsData;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.Dimension;
import javax.swing.ScrollPaneConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Shop extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	static int Theme = 0;
	private ColorSwatch lbWhite;
	private ColorSwatch lbBlue;
	private ColorSwatch lbLightGreen;
	private ColorSwatch lbCyan;
	private ColorSwatch lbMagenta;
	private ColorSwatch lbRed;
	private ColorSwatch lbYellow;
	private ColorSwatch lbDarkGreen;
	private ColorSwatch lbRGB;
	private JScrollPane scrollPane;
	private JPanel panel;
	
	private static JLabel lblpoints;
	
	private ShopItem lbldoublepoints;
	private ShopItem lblweapon;
	private ShopItem lblBallSpeed;
	private ShopItem lblPlayerSize;
	
	private JLabel lbText2XP;
	private JLabel lbTextWaffe;
	private JLabel lbTextSpeed;
	private JLabel lbTextPlSize;
	
	static boolean ballSpeed= false;
	static boolean weapon= false;
	static boolean playerSize= false;
	static boolean doublePoints= false;	
	private JButton doublePointsUnlock;
	private JButton ballSpeedUnlock;
	private JButton playerSizeUnlock;
	private JButton weaponUnlock;
	
	public static boolean getBallSpeed() {
		return ballSpeed;
	}
	
	public static boolean getWeapon() {
		return weapon;
	}
	
	public static boolean getPlayerSize() {
		return playerSize;
	}
	
	public static boolean getDoublePoints() {
		return doublePoints;
	}
	
	
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

	public Shop() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				StartScreen.erstellen();
			}
		});
		setTitle("Pong");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 613);
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
		lbTitleShop.setBounds(128, 53, 498, 49);
		lbTitleShop.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitleShop.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbTitleShop.setForeground(new Color(255, 255, 255));
		contentPane.add(lbTitleShop);
		
		lbWhite = new ColorSwatch(0, 0);
		lbWhite.setBounds(20, 10, 50, 50);
		lbWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbWhite.isColorLocked()) return;
				Theme = 0;
				clearBorder();
				lbWhite.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		panel.setLayout(null);
		panel.setLayout(null);
		lbWhite.setOpaque(true);
		lbWhite.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbWhite);
		
		lbBlue = new ColorSwatch(1, 1);
		lbBlue.setBounds(90, 10, 50, 50);
		lbBlue.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbBlue.isColorLocked()) return;
				Theme = 1;
				clearBorder();
				lbBlue.setBorder(new LineBorder(new Color(255, 128, 0), 5));
				
				updateItemBorders();
			}
		});
		lbBlue.setOpaque(true);
		lbBlue.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbBlue);
		
		lbLightGreen = new ColorSwatch(2, 2);
		lbLightGreen.setBounds(160, 10, 50, 50);
		lbLightGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbLightGreen.isColorLocked()) return;
				Theme = 2;
				clearBorder();
				lbLightGreen.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbLightGreen.setOpaque(true);
		lbLightGreen.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbLightGreen);
		
		lbCyan = new ColorSwatch(3, 3);
		lbCyan.setBounds(230, 10, 50, 50);
		lbCyan.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbCyan.isColorLocked()) return;
				Theme = 3;
				clearBorder();
				lbCyan.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbCyan.setOpaque(true);
		lbCyan.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbCyan);
		
		lbMagenta = new ColorSwatch(4, 4);
		lbMagenta.setBounds(300, 10, 50, 50);
		lbMagenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbMagenta.isColorLocked()) return;
				Theme = 4;
				clearBorder();
				lbMagenta.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbMagenta.setOpaque(true);
		lbMagenta.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbMagenta);
		
		lbRed = new ColorSwatch(5, 5);
		lbRed.setBounds(370, 10, 50, 50);
		lbRed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbRed.isColorLocked()) return;
				Theme = 5;
				clearBorder();
				lbRed.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		
		lbRed.setOpaque(true);
		lbRed.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbRed);
		
		lbYellow = new ColorSwatch(6, 6);
		lbYellow.setBounds(440, 10, 50, 50);
		lbYellow.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbYellow.isColorLocked()) return;
				Theme = 6;
				clearBorder();
				lbYellow.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbYellow.setOpaque(true);
		lbYellow.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbYellow);
		
		lbDarkGreen = new ColorSwatch(7, 7);
		lbDarkGreen.setBounds(510, 10, 50, 50);
		lbDarkGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbDarkGreen.isColorLocked()) return;
				Theme = 7;
				clearBorder();
				lbDarkGreen.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbDarkGreen.setOpaque(true);
		lbDarkGreen.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbDarkGreen);
		
		lbRGB = new ColorSwatch(8, 8);
		lbRGB.setBounds(580, 10, 50, 50);
		lbRGB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbRGB.isColorLocked()) return;
				Theme = 8;
				clearBorder();
				lbRGB.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbRGB.setOpaque(true);
		lbRGB.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		panel.add(lbRGB);
		
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
		
		lbldoublepoints = new ShopItem(Shop.class.getResourceAsStream("/resources/2xPoints.png"), 10, 0, 102, 101);
		lbldoublepoints.setSize(91, 87);
		lbldoublepoints.setLocation(102, 13);
		lbldoublepoints.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbldoublepoints.isItemLocked.getValue()) return;
				doublePoints=!doublePoints;
				updateItemBorders();
			}
		});
		panel_1.add(lbldoublepoints);
		
		lblweapon = new ShopItem(Shop.class.getResourceAsStream("/resources/Weapon.png"), 145, 0, 177, 100);
		lblweapon.setSize(165, 87);
		lblweapon.setLocation(237, 13);
		lblweapon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblweapon.isItemLocked.getValue()) return;
				weapon=!weapon;
				updateItemBorders();
			}
		});
		panel_1.add(lblweapon);
		
		lblBallSpeed = new ShopItem(Shop.class.getResourceAsStream("/resources/lowerspeed.jpg"), 348, 0, 139, 112);
		lblBallSpeed.setSize(130, 93);
		lblBallSpeed.setLocation(434, 10);
		lblBallSpeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblBallSpeed.isItemLocked.getValue()) return;
				ballSpeed=!ballSpeed;
				updateItemBorders();
			}
		});
		panel_1.add(lblBallSpeed);		
		

		lblPlayerSize = new ShopItem(Shop.class.getResourceAsStream("/resources/PlayerSize.png"), 523, 0, 102, 100);
		lblPlayerSize.setSize(91, 87);
		lblPlayerSize.setLocation(601, 13);
		lblPlayerSize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblPlayerSize.isItemLocked.getValue()) return;
				playerSize=!playerSize;
				updateItemBorders();
			}
		});
		panel_1.add(lblPlayerSize);
		
		
		
		lbText2XP = new JLabel("<html>Doppelte Punkte</html>");
		lbText2XP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbText2XP.setForeground(new Color(255, 255, 255));
		lbText2XP.setBounds(89, 453, 129, 54);
		contentPane.add(lbText2XP);
		
		lbTextWaffe = new JLabel("<html>Waffe</html>");
		lbTextWaffe.setForeground(Color.WHITE);
		lbTextWaffe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTextWaffe.setBounds(254, 453, 93, 54);
		contentPane.add(lbTextWaffe);
		
		lbTextSpeed = new JLabel("<html>Veringerte Geschwindigkeit</html>");
		lbTextSpeed.setForeground(Color.WHITE);
		lbTextSpeed.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTextSpeed.setBounds(436, 456, 142, 67);
		contentPane.add(lbTextSpeed);
		
		lbTextPlSize = new JLabel("Spieler Größe");
		lbTextPlSize.setForeground(Color.WHITE);
		lbTextPlSize.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTextPlSize.setBounds(590, 453, 164, 54);
		contentPane.add(lbTextPlSize);
		
		JPanel pnPunkte = new JPanel();
		pnPunkte.setBackground(new Color(0, 0, 0));
		pnPunkte.setBorder(null);
		pnPunkte.setBounds(588, 23, 196, 91);
		contentPane.add(pnPunkte);
		pnPunkte.setLayout(null);
		
		lblpoints = new JLabel("Coins: 0");
		lblpoints.setText("Points: " + Points.instancePoints.getPunkteShop());
		
		lblpoints.setBounds(35, 34, 151, 46);
		lblpoints.setForeground(new Color(255, 255, 255));
		lblpoints.setFont(new Font("Tahoma", Font.BOLD, 23));
		pnPunkte.add(lblpoints);
		
		doublePointsUnlock = new JButton("<html>Freischalten: 15 Points</html>");
		doublePointsUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 15) return;
				
				lbldoublepoints.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		doublePointsUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		doublePointsUnlock.setBounds(99, 518, 93, 47);
		contentPane.add(doublePointsUnlock);
		
		weaponUnlock = new JButton("<html>Freischalten: 35 Points</html>");
		weaponUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 35) return;
				
				lblweapon.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		weaponUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		weaponUnlock.setBounds(239, 518, 93, 47);
		contentPane.add(weaponUnlock);
		
		ballSpeedUnlock = new JButton("<html>Freischalten: 10 Points</html>");
		ballSpeedUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 10) return;	
				
				lblBallSpeed.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		ballSpeedUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ballSpeedUnlock.setBounds(446, 518, 93, 47);
		contentPane.add(ballSpeedUnlock);
		
		playerSizeUnlock = new JButton("<html>Freischalten: 25 Points</html>");
		playerSizeUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 25) return;		
				
				lblPlayerSize.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		playerSizeUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		playerSizeUnlock.setBounds(600, 518, 93, 47);
		contentPane.add(playerSizeUnlock);
		updateStats();
		
		JLabel[] borderLabels = {lbWhite,lbBlue,lbLightGreen,lbCyan,lbMagenta,lbRed,lbYellow,lbDarkGreen,lbRGB};
		borderLabels[Theme].setBorder(new LineBorder(new Color(255, 128, 0), 5));
		
		updateItemBorders();
		updateFreischaltButtons();
	}

	private void updateFreischaltButtons() {
		ballSpeedUnlock.setEnabled(lblBallSpeed.isItemLocked.getValue());
		doublePointsUnlock.setEnabled(lbldoublepoints.isItemLocked.getValue());
		weaponUnlock.setEnabled(lblweapon.isItemLocked.getValue());
		playerSizeUnlock.setEnabled(lblPlayerSize.isItemLocked.getValue());
		ballSpeedUnlock.setVisible(lblBallSpeed.isItemLocked.getValue());
		doublePointsUnlock.setVisible(lbldoublepoints.isItemLocked.getValue());
		weaponUnlock.setVisible(lblweapon.isItemLocked.getValue());
		playerSizeUnlock.setVisible(lblPlayerSize.isItemLocked.getValue());
	}
	
	private void updateItemBorders() {
		if(playerSize) {
			lblPlayerSize.isSelected = true;
		}
		else {
			lblPlayerSize.isSelected = false;
		}
		if(ballSpeed) {
			lblBallSpeed.isSelected = true;
		}
		else {
			lblBallSpeed.isSelected = false;
		}
		if(weapon) {
			lblweapon.isSelected = true;
		}
		else {
			lblweapon.isSelected = false;
		}
		if(doublePoints) {
			lbldoublepoints.isSelected = true;
		}
		else {
			lbldoublepoints.isSelected = false;
		}
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
	
	public static void updateStats() {
		lblpoints.setText("Points: " + StatsData.getShopPunkte());
	}
	
	public static Color getTheme() {
		return getTheme(false);
	}
	public static Color getTheme(boolean ball) {
		Color[] RGB = {Color.white,Color.blue,Color.green,Color.cyan,Color.magenta,Color.red,Color.yellow, new Color(0f,0.5f,0f,1f)};
		switch (Theme) {
		case 0: return Color.white;
		case 1: return Color.blue;
		case 2: return Color.green;
		case 3: return Color.cyan;
		case 4: return Color.magenta;
		case 5: return Color.red;
		case 6: return Color.yellow;
		case 7: return new Color(0f,0.5f,0f,1f);
		case 8:if(ball) { return RGB[(int) (Math.random()*RGB.length)];} else {return Color.white;}
		default:
			throw new IllegalArgumentException("Unexpected value: " + Theme);
			
		}
	}
	
	public static Color getTheme(int colorId) {

		Color[] RGB = {Color.white,Color.blue,Color.green,Color.cyan,Color.magenta,Color.red,Color.yellow, new Color(0f,0.5f,0f,1f)};
		
		switch (colorId) {
		case 0: return Color.white;
		case 1: return Color.blue;
		case 2: return Color.green;
		case 3: return Color.cyan;
		case 4: return Color.magenta;
		case 5: return Color.red;
		case 6: return Color.yellow;
		case 7: return new Color(0f,0.5f,0f,1f);
		case 8: return RGB[(int) (Math.random()*RGB.length)];
		default:
			throw new IllegalArgumentException("Unexpected value: " + Theme);
			
		}
	}
}
