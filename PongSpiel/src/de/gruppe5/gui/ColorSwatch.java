package de.gruppe5.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import de.gruppe5.actions.SaveableValue;
import de.gruppe5.game.Points;

public class ColorSwatch extends JLabel {

	private static final long serialVersionUID = -6571687844271771138L;
	
	static BufferedImage lockedIcon;
	
	boolean isColorLocked = true;
	
	private int colorId;
	private int price;
	
	public boolean isColorLocked() {
		return isColorLocked;
	}

	public void setCoorLocked(boolean isColorLocked) {
		this.isColorLocked = isColorLocked;
		repaint();
	}

	public ColorSwatch(int colorId, int price) {
		try {
			if(lockedIcon == null)
				lockedIcon = ImageIO.read(Shop.class.getResourceAsStream("/resources/lock.png"));
		}catch (Exception e) {
			System.err.println("Das Byld konnte njicht geljaden werden blyat");
		}
		
		this.colorId = colorId;
		this.price = price;
		
		if(Points.instancePoints != null) {
			if(Points.instancePoints.getPunkteShop() >= price)
				isColorLocked = false;
		}
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D)g;
		
		if(isColorLocked()) {
			g2d.drawImage(lockedIcon, 0, 0, getWidth(), getHeight(), null);
		}else {
			g2d.setColor(Shop.getTheme(colorId));
			g2d.fillRect(4, 4, getWidth() - 8, getHeight() - 8);
		}
		
		repaint();
	}	
}
