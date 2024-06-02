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
	private JLabel lbGreen;
	private JLabel lbCyan;
	private JLabel lbMagenta;
	
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
		
		JLabel lbTitle = new JLabel("Title");
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
		lbWhite.setBounds(78, 140, 50, 50);
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
		lbBlue.setBounds(178, 140, 50, 50);
		contentPane.add(lbBlue);
		
		lbGreen = new JLabel("");
		lbGreen.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Theme = 2;
				clearBorder();
				lbGreen.setBorder(new LineBorder(new Color(255, 128, 0), 5));
			}
		});
		lbGreen.setOpaque(true);
		lbGreen.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbGreen.setBackground(Color.GREEN);
		lbGreen.setBounds(274, 140, 50, 50);
		contentPane.add(lbGreen);
		
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
		lbCyan.setBounds(366, 140, 50, 50);
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
		lbMagenta.setBounds(451, 140, 50, 50);
		contentPane.add(lbMagenta);
		
		JLabel[] borderLabels = {lbWhite,lbBlue,lbGreen,lbCyan,lbMagenta};
		borderLabels[Theme].setBorder(new LineBorder(new Color(255, 128, 0), 5));
	}
	
	private void clearBorder() {
		lbWhite.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbBlue.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbGreen.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbCyan.setBorder(new LineBorder(new Color(255, 255, 255), 5));
		lbMagenta.setBorder(new LineBorder(new Color(255, 255, 255), 5));
	}
	
	public static Color getTheme() {
		switch (Theme) {
		case 0: return Color.white;
		case 1: return Color.blue;
		case 2: return Color.green;
		case 3: return Color.cyan;
		case 4: return Color.magenta;
		default:
			throw new IllegalArgumentException("Unexpected value: " + Theme);
		}
	}
}
