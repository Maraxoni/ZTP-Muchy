package pl.wipb.ztp.flies.template;

import java.awt.*;

public class MuchaCircular extends Mucha{
    @Override
    protected void specificMove() {
        // Prędkość
        double angleChange = 0.3;
        // Ustalenie nowych kierunków prędkości
        double newVx = vx * Math.cos(angleChange) - vy * Math.sin(angleChange);
        double newVy = vx * Math.sin(angleChange) + vy * Math.cos(angleChange);
        // Nowe kierunki prędkości
        vx = newVx;
        vy = newVy;
    }

    @Override
    protected Color getColor() {
        return Color.RED; // Kolor
    }
}
