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
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import de.demoncore.game.Points;
import de.demoncore.game.StatsData;

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
	private JLabel lbWhite;
	private JLabel lbBlue;
	private JLabel lbLightGreen;
	private JLabel lbCyan;
	private JLabel lbMagenta;
	private JLabel lbRed;
	private JLabel lbYellow;
	private JLabel lbDarkGreen;
	private JLabel lbRGB;
	private JScrollPane scrollPane;
	private JPanel panel;
	
	private static JLabel lblpoints;
	
	private ShopItem lbldoublepoints;
	private ShopItem lblweapon;
	private ShopItem lblBallSpeed;
	private ShopItem lblPlayerSize;
	private ShopItem lblclone;
	
	private JLabel lbText2XP;
	private JLabel lbTextWaffe;
	private JLabel lbTextSpeed;
	private JLabel lbTextPlSize;
	private JLabel lbTextKlon;
	
	static boolean ballSpeed= false;
	static boolean weapon= false;
	static boolean playerSize= false;
	static boolean doublePoints= false;
	static boolean clone= false;	
	private JButton doublePointsUnlock;
	private JButton ballSpeedUnlock;
	private JButton playerSizeUnlock;
	private JButton ballCloneUnlock;
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
	
	public static boolean getClone() {
		return clone;
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
		lbTitleShop.setBounds(147, 40, 498, 49);
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
		
		lbRGB = new JLabel("");
		lbRGB.setBounds(580, 10, 50, 50);
		lbRGB.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 8;
				clearBorder();
				lbRGB.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbRGB.setOpaque(true);
		lbRGB.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbRGB.setBackground(new Color(0, 128, 0));
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
		lbldoublepoints.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lbldoublepoints.isItemLocked) return;
				doublePoints=!doublePoints;
				updateItemBorders();
			}
		});
		panel_1.add(lbldoublepoints);
		
		lblweapon = new ShopItem(Shop.class.getResourceAsStream("/resources/Weapon.png"), 145, 0, 177, 100);
		lblweapon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblweapon.isItemLocked) return;
				weapon=!weapon;
				updateItemBorders();
			}
		});
		panel_1.add(lblweapon);
		
		lblBallSpeed = new ShopItem(Shop.class.getResourceAsStream("/resources/lowerspeed.jpg"), 348, 0, 139, 112);
		lblBallSpeed.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblBallSpeed.isItemLocked) return;
				ballSpeed=!ballSpeed;
				updateItemBorders();
			}
		});
		panel_1.add(lblBallSpeed);		
		

		lblPlayerSize = new ShopItem(Shop.class.getResourceAsStream("/resources/PlayerSize.png"), 523, 0, 102, 100);
		lblPlayerSize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblPlayerSize.isItemLocked) return;
				playerSize=!playerSize;
				updateItemBorders();
			}
		});
		panel_1.add(lblPlayerSize);
		

		lblclone = new ShopItem(Shop.class.getResourceAsStream("/resources/Klon.jpg"), 632, 11, 139, 101);
		lblclone.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(lblclone.isItemLocked) return;
				clone=!clone;
				updateItemBorders();
			}
		});
		panel_1.add(lblclone);
		
		
		lbText2XP = new JLabel("<html>Doppelte Punkte</html>");
		lbText2XP.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbText2XP.setForeground(new Color(255, 255, 255));
		lbText2XP.setBounds(10, 453, 129, 54);
		contentPane.add(lbText2XP);
		
		lbTextWaffe = new JLabel("<html>Waffe</html>");
		lbTextWaffe.setForeground(Color.WHITE);
		lbTextWaffe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTextWaffe.setBounds(175, 453, 93, 54);
		contentPane.add(lbTextWaffe);
		
		lbTextSpeed = new JLabel("<html>Veringerte Geschwindigkeit</html>");
		lbTextSpeed.setForeground(Color.WHITE);
		lbTextSpeed.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbTextSpeed.setBounds(357, 456, 142, 67);
		contentPane.add(lbTextSpeed);
		
		lbTextPlSize = new JLabel("Spieler Größe");
		lbTextPlSize.setForeground(Color.WHITE);
		lbTextPlSize.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTextPlSize.setBounds(511, 453, 164, 54);
		contentPane.add(lbTextPlSize);
		
		lbTextKlon = new JLabel("Ball Klonen");
		lbTextKlon.setForeground(Color.WHITE);
		lbTextKlon.setFont(new Font("Tahoma", Font.BOLD, 15));
		lbTextKlon.setBounds(655, 453, 164, 54);
		contentPane.add(lbTextKlon);
		
		JPanel pnPunkte = new JPanel();
		pnPunkte.setBackground(new Color(0, 0, 0));
		pnPunkte.setBorder(null);
		pnPunkte.setBounds(588, 23, 196, 91);
		contentPane.add(pnPunkte);
		pnPunkte.setLayout(null);
		
		lblpoints = new JLabel("Coins: 0");
		lblpoints.setText("Points: " + Points.instancePoints.getPunkteShop());
		
		lblpoints.setBounds(35, 11, 119, 51);
		lblpoints.setForeground(new Color(255, 255, 255));
		lblpoints.setFont(new Font("Tahoma", Font.BOLD, 23));
		pnPunkte.add(lblpoints);
		
		doublePointsUnlock = new JButton("Freischalten");
		doublePointsUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 1) return;
				
				lbldoublepoints.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		doublePointsUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		doublePointsUnlock.setBounds(20, 518, 93, 23);
		contentPane.add(doublePointsUnlock);
		
		weaponUnlock = new JButton("Freischalten");
		weaponUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 1) return;
				
				lblweapon.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		weaponUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		weaponUnlock.setBounds(160, 518, 93, 23);
		contentPane.add(weaponUnlock);
		
		ballSpeedUnlock = new JButton("Freischalten");
		ballSpeedUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 1) return;	
				
				lblBallSpeed.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		ballSpeedUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ballSpeedUnlock.setBounds(367, 518, 93, 23);
		contentPane.add(ballSpeedUnlock);
		
		playerSizeUnlock = new JButton("Freischalten");
		playerSizeUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 1) return;		
				
				lblPlayerSize.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		playerSizeUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		playerSizeUnlock.setBounds(521, 518, 93, 23);
		contentPane.add(playerSizeUnlock);
		
		ballCloneUnlock = new JButton("Freischalten");
		ballCloneUnlock.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(StatsData.getShopPunkte() < 1) return;			
				lblclone.setItemLocked(false);
				updateFreischaltButtons();
			}
		});
		ballCloneUnlock.setFont(new Font("Tahoma", Font.PLAIN, 9));
		ballCloneUnlock.setBounds(665, 518, 93, 23);
		contentPane.add(ballCloneUnlock);
		updateStats();
		
		JLabel[] borderLabels = {lbWhite,lbBlue,lbLightGreen,lbCyan,lbMagenta,lbRed,lbYellow,lbDarkGreen};
		borderLabels[Theme].setBorder(new LineBorder(new Color(255, 128, 0), 5));
		
		updateItemBorders();
		updateFreischaltButtons();
	}
	
	private void updateFreischaltButtons() {
		ballCloneUnlock.setEnabled(lblclone.isItemLocked);
		ballSpeedUnlock.setEnabled(lblBallSpeed.isItemLocked);
		doublePointsUnlock.setEnabled(lbldoublepoints.isItemLocked);
		weaponUnlock.setEnabled(lblweapon.isItemLocked);
		playerSizeUnlock.setEnabled(lblPlayerSize.isItemLocked);
		

		ballCloneUnlock.setVisible(lblclone.isItemLocked);
		ballSpeedUnlock.setVisible(lblBallSpeed.isItemLocked);
		doublePointsUnlock.setVisible(lbldoublepoints.isItemLocked);
		weaponUnlock.setVisible(lblweapon.isItemLocked);
		playerSizeUnlock.setVisible(lblPlayerSize.isItemLocked);
	}
	
	private void updateItemBorders() {
		if(clone) {
			lblclone.setBorder(new LineBorder(new Color(255, 128, 0), 5));
		}
		else {
			lblclone.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		}
		if(playerSize) {
			lblPlayerSize.setBorder(new LineBorder(new Color(255, 128, 0), 5));
		}
		else {
			lblPlayerSize.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		}
		if(ballSpeed) {
			lblBallSpeed.setBorder(new LineBorder(new Color(255, 128, 0), 5));
		}
		else {
			lblBallSpeed.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		}
		if(weapon) {
			lblweapon.setBorder(new LineBorder(new Color(255, 128, 0), 5));
		}
		else {
			lblweapon.setBorder(new LineBorder(new Color(0, 0, 0), 0));
		}
		if(doublePoints) {
			lbldoublepoints.setBorder(new LineBorder(new Color(255, 128, 0), 5));
		}
		else {
			lbldoublepoints.setBorder(new LineBorder(new Color(0, 0, 0), 0));
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
		switch (Theme) {
		case 0: return Color.white;
		case 1: return Color.blue;
		case 2: return Color.green;
		case 3: return Color.cyan;
		case 4: return Color.magenta;
		case 5: return Color.red;
		case 6: return Color.yellow;
		case 7: return new Color(0f,0.5f,0f,1f);
		case 8: return Color.white;
		default:
			throw new IllegalArgumentException("Unexpected value: " + Theme);
			
		}
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
}
