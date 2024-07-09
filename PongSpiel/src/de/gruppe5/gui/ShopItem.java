package de.gruppe5.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import de.gruppe5.actions.SaveableValue;
import de.gruppe5.actions.Utils;

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
				lockedIcon = ImageIO.read(Shop.class.getResourceAsStream("/resources/lock.png"));
		}catch (Exception e) {
			System.err.println("Das Byld konnte njicht geljaden werden blyat");
		}
		
		setBounds(x, y, width, height);
		
		String objectId = "" + x + "" + y + "" + width + "" + height;
		
		isItemLocked = new SaveableValue<Boolean>(true, "shop." + objectId);
	
		if(!isItemLocked())
			yValue = 50;
	}

	float yValue = 0;
	float sizeAddition = 0;
	double lastTime = 0;
	public boolean isSelected = false;

	Color unselectedColor = new Color(.1f, .1f, .1f, 1f);
	Color selectedColor = new Color(.8f, .7f, .1f, 1f);
	Color currentColor = unselectedColor;
	
	@Override
	public void paint(Graphics g) {
		
		double fps = 1000 / (System.currentTimeMillis() - lastTime);
		lastTime = System.currentTimeMillis();
		
		Graphics2D g2d = (Graphics2D)g;
		
		sizeAddition = Utils.lerp(sizeAddition, isSelected ? 15:0, 6f / (float)fps);
		RoundRectangle2D shape = new RoundRectangle2D.Float(+(int)sizeAddition / 2, +(int)sizeAddition / 2,
				getWidth() - (int)sizeAddition, getHeight() - (int)sizeAddition, 25, 25);
		RoundRectangle2D shape1 = new RoundRectangle2D.Float(0, 0,
				getWidth(), getHeight(), 25, 25);
		
		currentColor = Utils.lerpColor(currentColor, isSelected ? selectedColor : unselectedColor, 6f / (float)fps);
		
		g2d.setClip(shape1);
		
		if(isItemLocked()){
			g2d.drawImage(itemIcon, 15, 15, getWidth() -30, getHeight() -30, null);
			g2d.setColor(new Color(0, 0, 0, 0.75f));
			g2d.fillRect(-10, -10, getWidth() +20, getHeight() + 20);
			
		}else {
			g2d.drawImage(itemIcon, 15, 15, getWidth() -30, getHeight() -30, null);
		}

		yValue = Utils.lerp(yValue, isItemLocked() ? 0:200, 4f / (float)fps);
		g2d.drawImage(lockedIcon, getWidth() / 2 - getHeight() / 2, (int)yValue, getHeight(), getHeight(), null);
		
		g2d.setColor(currentColor);
		g2d.setStroke(new BasicStroke(6));
		g2d.draw(shape);
		
		repaint();
	}
	
}
