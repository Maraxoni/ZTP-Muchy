package pl.wipb.ztp.flies.strategy;

import java.awt.Color;

public class MuchaCircular implements MovementStrategy {
    private static final double angle = 20.0 / 1000.0 * 2.0 * Math.PI;
    @Override
    public void specificMovePull(Mucha mucha) {
        double backupVx = mucha.vx, backupVy = mucha.vy;
        double sin = Math.sin(angle), cos = Math.cos(angle);
        mucha.vx = cos*backupVx - sin*backupVy;
        mucha.vy = sin*backupVx + cos*backupVy;
    }

    @Override
    public void specificMovePush(double vx, double vy) {

    }

    @Override
    public Color getColor() {
        return Color.RED; // Kolor
    }
}