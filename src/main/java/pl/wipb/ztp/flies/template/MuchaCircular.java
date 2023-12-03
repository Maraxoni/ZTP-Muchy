package pl.wipb.ztp.flies.template;

import java.awt.*;

public class MuchaCircular extends Mucha{
    private static final double angle = 20.0 / 1000.0 * 2.0 * Math.PI;
    @Override
    protected void specificMove() {
        double backupVx = vx, backupVy = vy;
        double sin = Math.sin(angle), cos = Math.cos(angle);
        vx = cos*backupVx - sin*backupVy;
        vy = sin*backupVx + cos*backupVy;
    }

    @Override
    protected Color getColor() {
        return Color.RED; // Kolor
    }
}
