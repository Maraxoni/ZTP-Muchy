package pl.wipb.ztp.flies.template;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract class Mucha {
	
	private final double k = 0.01;
	protected double x, y; // pozycja muchy
	protected double vx, vy; // predkosc muchy

	public Mucha() {
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
	}

	public void draw(Graphics g) {
		g.setColor(this.getColor());
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
		specificMove();
	}

	// Abstrakcyjna metoda do nadpisania w klasach potomnych
	protected abstract void specificMove();

	// Abstrakcyjna metoda do nadpisania w klasach potomnych
	protected abstract Color getColor();

}