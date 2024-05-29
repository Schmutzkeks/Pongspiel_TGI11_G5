package de.demoncore.gameObjects;

import de.demoncore.game.GameObject;
import de.demoncore.game.Gamelogic2;

public class BeweglichesRechteck extends GameObject {
	
	public byte richtung;
	public int schritteInGleicherRichtung;
	int ingamescrwidth = 786;
	int ingamescrheight = 593 - 31;
	double Speed;
	public static int velX = 1;
	public static int velY = 1;
	
	
	
	Gamelogic2 velLogik = new Gamelogic2();

	

	public BeweglichesRechteck(int posX, int posY, int breite, int hoehe) {
		super(posX, posY, breite, hoehe);
		schritteInGleicherRichtung = 0;
	}
	
	public void Vector2(int x, int y) {
		positionX += x;
		positionY += y;
	}
	
	/*
	public void automatischeKreisbewegung() {
		if(richtung == 0) {
			positionX += 1;
		} else if (richtung == 1) {
			positionY += 1;
		} else if (richtung == 2) {
			positionX -= 1;
		} else if (richtung == 3) {
			positionY -= 1;
		}
		if (schritteInGleicherRichtung > 75) {
			richtung += 1;
			if (richtung > 3) {
				richtung = 0;
			}
			schritteInGleicherRichtung = 0;
		} else {
			schritteInGleicherRichtung += 1;
		}
	}
	*/
	
	public void bouncebewegung() {
		
		// tan for the bounce. tan = g/a = velY/velX
		Vector2(velX, velY);



        // Check for collision with wall
        if (positionX <= 0 || positionX >= 786 - 20) {
            if (velX>0&&velY>0) velX = velX *(-1);
            else if (velX>0&&velY<0) velX = velX *(-1);
            else if (velX<0&&velY>0) velX = velX *(-1);
            else if (velX<0&&velY<0) velX = velX *(-1);
        }

        if (positionY <= 0 || positionY >= 562 - 20) {
            if (velX>0&&velY>0) velY = velY *(-1);
            else if (velX>0&&velY<0) velY = velY *(-1);
            else if (velX<0&&velY>0) velY = velY *(-1);
            else if (velX<0&&velY<0) velY = velY *(-1);
        }
		
        
	}
	

}
