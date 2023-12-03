package pl.wipb.ztp.flies.strategy;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Muchy extends JPanel implements Runnable {

	private Mucha[] ar;

	public Muchy() {
		this.setPreferredSize(new Dimension(640, 480));
		ar = new Mucha[30];
		for (int i = 0; i < ar.length; i++) {
			int randomNumber = (int) Math.round(Math.random());
			if(randomNumber == 0){
				MovementStrategy strategy = new MuchaRandomDirection();
				ar[i] = new Mucha(strategy);
			} else{
				MovementStrategy strategy = new MuchaCircular();
				ar[i] = new Mucha(strategy);
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < ar.length; ++i) {
			ar[i].draw(g);
		}
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < ar.length; ++i) {
				ar[i].move();
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "true");

		JFrame frame = new JFrame("Muchy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Muchy m = new Muchy();
		frame.getContentPane().add(m);
		frame.pack();
		frame.setVisible(true);
		new Thread(m).start();
	}
}