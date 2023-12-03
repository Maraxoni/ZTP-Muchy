package pl.wipb.ztp.flies.strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

class Mucha{
	// Deklaracja Strategii
	MovementStrategy movementStrategy;
	// Prędkość
	protected final double k = 0.01;
	protected double x, y; // pozycja muchy
	protected double vx, vy; // predkosc muchy

	public Mucha(MovementStrategy strategy) {
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
		movementStrategy = strategy;
	}

	public void draw(Graphics g) {
		g.setColor(movementStrategy.getColor());
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 5, 5);
	}
	
	public void move() {
		x += vx;
		y += vy;
		if(x<0) { x = -x; vx = -vx; }
		if(x>1) { x = 2-x;vx = -vx; }
		if(y<0) { y = -y; vy = -vy; }
		if(y>1) { y = 2-y;vy = -vy; }
		if(movementStrategy instanceof MuchaCircular) {
            movementStrategy.specificMovePull(this);
        }
		if(movementStrategy instanceof MuchaRandomDirection) {
			movementStrategy.specificMovePush(vx, vy);
			vx = ((MuchaRandomDirection) movementStrategy).getRvx();
			vy = ((MuchaRandomDirection) movementStrategy).getRvy();
		}
	}
}