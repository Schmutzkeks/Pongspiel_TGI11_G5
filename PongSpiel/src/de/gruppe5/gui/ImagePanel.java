package de.gruppe5.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanel extends JPanel {
	
	BufferedImage image;
	
	public ImagePanel(URL url) {
		try {
			this.image = ImageIO.read(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		
		Graphics2D graphics2d = (Graphics2D)(g);
		graphics2d.drawImage(image, getX(), getY(), getWidth(), getHeight(), null);
	}

}
