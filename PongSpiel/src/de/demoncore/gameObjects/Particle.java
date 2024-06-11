package de.demoncore.gameObjects;

public class Particle {
	private BeweglichesRechteck particle;
	double dx, dy;
	public int updates=0;
	
    public Particle(double x, double y) {
        particle = new BeweglichesRechteck(x, y, 5, 5);
        this.dx = (Math.random() - 0.5) * 4;
        this.dy = (Math.random() - 0.5) * 4;
    }

    public double getX() {
        return particle.positionX;
    }

    public double getY() {
        return particle.positionY;
    }

    public int getSize() {
        return particle.groesseX;
    }
    public void update() {
    	updates++;
    	particle.positionX+=dx*Math.random();
    	particle.positionY+=dy*Math.random();
    }
}
