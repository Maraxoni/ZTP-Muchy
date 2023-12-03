package pl.wipb.ztp.flies.strategy;

import java.awt.*;

public class MuchaRandomDirection implements MovementStrategy {
    double Rvx, Rvy;
    @Override
    public void specificMovePull(Mucha mucha) {

    }

    @Override
    public void specificMovePush(double vx, double vy) {
        // Losowa zmiana kierunku
        double angleChange = 0.2 * (Math.random() - Math.random());
        // Ustalenie nowych kierunków prędkości
        double newVx = vx * Math.cos(angleChange) - vy * Math.sin(angleChange);
        double newVy = vx * Math.sin(angleChange) + vy * Math.cos(angleChange);
        // Nowe kierunki prędkości
        vx = newVx;
        vy = newVy;
        Rvx = vx;
        Rvy = vy;
    }

    public double getRvx() {
        return Rvx;
    }

    public double getRvy() {
        return Rvy;
    }

    @Override
    public Color getColor() {
        return Color.BLUE; // Kolor
    }
}
