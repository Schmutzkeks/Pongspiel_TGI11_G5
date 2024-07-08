package de.gruppe5.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import de.gruppe5.actions.SaveableValue;

public class ShopItem extends JLabel {

	private static final long serialVersionUID = -6571687844271771138L;
	BufferedImage colorIcon;
	BufferedImage itemIcon;
	static BufferedImage lockedIcon;
	
	SaveableValue<Boolean> isItemLocked;
	
	public boolean isItemLocked() {
		return isItemLocked.getValue();
	}

	public void setItemLocked(boolean isItemLocked) {
		this.isItemLocked.setValue(isItemLocked);
		repaint();
	}

	public ShopItem(InputStream imageStream, int x, int y, int width, int height) {
		try {			
			itemIcon = ImageIO.read(imageStream);
			if(lockedIcon == null)
				lockedIcon = ImageIO.read(Shop.class.getResourceAsStream("/resources/lock.jpg"));
		}catch (Exception e) {
			System.err.println("Das Byld konnte njicht geljaden werden blyat");
		}
		
		setBounds(x, y, width, height);
		
		String objectId = "" + x + "" + y + "" + width + "" + height;
		
		isItemLocked = new SaveableValue<Boolean>(true, "shop." + objectId);
	}
	
	
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D)g;
		g2d.drawImage(isItemLocked.getValue() ? lockedIcon : itemIcon, 0, 0, getWidth(), getHeight(), null);
		super.paint(g);
	}

	
}
