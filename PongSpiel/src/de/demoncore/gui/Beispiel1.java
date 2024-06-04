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

public class Beispiel1 extends JFrame {

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
	
	/**
	 * Launch the application.
	 */
	public static void erstellen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Beispiel1 frame = new Beispiel1();
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
	public Beispiel1() {
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
		
		JLabel lbTitle = new JLabel("Farbauswahl");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbTitle.setForeground(new Color(255, 255, 255));
		lbTitle.setBounds(0, 40, 784, 49);
		contentPane.add(lbTitle);
		
		lbWhite = new JLabel("");
		lbWhite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 0;
				clearBorder();
				lbWhite.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbWhite.setBackground(Color.WHITE);
		lbWhite.setOpaque(true);
		lbWhite.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbWhite.setBounds(39, 140, 50, 50);
		contentPane.add(lbWhite);
		
		lbBlue = new JLabel("");
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
		lbBlue.setBounds(131, 140, 50, 50);
		contentPane.add(lbBlue);
		
		lbLightGreen = new JLabel("");
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
		lbLightGreen.setBounds(215, 140, 50, 50);
		contentPane.add(lbLightGreen);
		
		lbCyan = new JLabel("");
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
		lbCyan.setBounds(303, 140, 50, 50);
		contentPane.add(lbCyan);
		
		lbMagenta = new JLabel("");
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
		lbMagenta.setBounds(393, 140, 50, 50);
		contentPane.add(lbMagenta);
		
		lbRed = new JLabel("");
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
		lbRed.setBounds(485, 140, 50, 50);
		contentPane.add(lbRed);
		
		lbYellow = new JLabel("");
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
		lbYellow.setBounds(573, 140, 50, 50);
		contentPane.add(lbYellow);
		
		lbDarkGreen = new JLabel("");
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
		lbDarkGreen.setBounds(655, 140, 50, 50);
		contentPane.add(lbDarkGreen);
		
		JLabel[] borderLabels = {lbWhite,lbBlue,lbLightGreen,lbCyan,lbMagenta};
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
