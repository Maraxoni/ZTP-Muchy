package pl.wipb.ztp.flies.strategy;

import java.awt.*;

public interface MovementStrategy {
    // Pull
    void specificMovePull(Mucha mucha);
    // Push
    void specificMovePush(double vx, double vy);

    //void specificMove(double x, double y, double vx, double vy);

    Color getColor();
}
