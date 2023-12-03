package pl.wipb.ztp.flies.template;

import java.awt.*;

public class MuchaRandomDirection extends Mucha {
    @Override
    protected void specificMove() {
        // Losowa zmiana kierunku
        double angleChange = 0.3 * (Math.random() - Math.random());
        // Ustalenie nowych kierunków prędkości
        double newVx = vx * Math.cos(angleChange) - vy * Math.sin(angleChange);
        double newVy = vx * Math.sin(angleChange) + vy * Math.cos(angleChange);
        // Nowe kierunki prędkości
        vx = newVx;
        vy = newVy;
    }

    @Override
    protected Color getColor() {
        return Color.BLUE; // Kolor
    }
}
