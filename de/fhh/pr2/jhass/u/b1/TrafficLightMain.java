package de.fhh.pr2.jhass.u.b1;

import java.awt.Color;
import java.awt.Graphics2D;

import de.fhh.pr2.common.DrawingPanel;

public class TrafficLightMain {
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(150, 400);
		Graphics2D pen = panel.getGraphics();
		
		turnOffAll(pen);
		
		while (true) {
			try {
				turnOnYellowLight(pen);
				Thread.sleep(1000);
				turnOffAll(pen);
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}

	private static void turnOnYellowLight(Graphics2D pen) {
		pen.setColor(new Color(255, 255, 0));
		pen.fillOval(20, 140, 110, 110);
	}
	
	private static void turnOffAll(Graphics2D pen) {
		pen.setColor(new Color(0, 0 ,0));
		pen.fillRect(0, 0, 150, 400);
	}
}
