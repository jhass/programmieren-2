package de.fhh.pr2.jhass.u.b1;

import java.awt.Color;
import java.awt.Graphics2D;

import de.fhh.pr2.common.DrawingPanel;

public class Ampel extends Thread {
	private DrawingPanel panel;
	private Graphics2D pen;
	private String name;
	private int[] phaseWaitTimes;
	private int currentPhase;
	private int nextPhase;
	private Ampel otherAmpel;
	
	public Ampel(String name, int[] phaseWaitTimes, int startPhase) {
		if (phaseWaitTimes.length != 4) {
			throw new IllegalArgumentException("phases must be exactly 4 elements");
		}
		if (startPhase < 0 || startPhase > 3) {
			throw new IllegalArgumentException("startPhase must be between 0 and 3");
		}
		synchronized (DrawingPanel.class) {
			this.panel = new DrawingPanel(150, 450);
		}
		// ignore that hack
		panel.setLocation((int) panel.getLocation().getX()+startPhase*100, (int) panel.getLocation().getY());
		
		this.pen = panel.getGraphics();
		this.name = name;
		this.phaseWaitTimes = phaseWaitTimes;
		this.nextPhase = startPhase;
		this.turnOffAll();
		this.pen.drawString(this.name, 10, 435);
	}
	
	public void setOtherAmpel(Ampel ampel) {
		this.otherAmpel = ampel;
	}
	
	public boolean isGreen() {
		return this.currentPhase == 0;
	}
	
	public boolean isYellow() {
		return this.currentPhase == 1;
	}

	public boolean isRed() {
		return this.currentPhase == 2;
	}
	
	public boolean isRedYellow() {
		return this.currentPhase == 3;
	}
	
	
	@Override
	public void run() {
		if (this.otherAmpel == null) {
			throw new IllegalArgumentException("Can't start without knowing other Ampel");
		}
		
		while(true) {
			this.goToNextPhase();
			this.waitForNextPhase();
		}
	}
	
	private void waitForNextPhase() {
		try {
			Thread.sleep(1000*this.phaseWaitTimes[this.currentPhase]);
		} catch (InterruptedException e) {}
	}
	
	private synchronized void goToNextPhase() {
		this.currentPhase = this.nextPhase;
		this.notifyAll();
		
		while (!this.displayCurrentPhase()) {
			synchronized (this.otherAmpel) {
				try {
					this.otherAmpel.wait();
				} catch (InterruptedException e) {}
			}
		}
	}
	
	private boolean displayCurrentPhase() {
		boolean success;
		switch(this.currentPhase) {
			case 0:
				success = this.displayGreenPhase();
				break;
			case 1:
				success = this.displayYellowPhase();
				break;
			case 2:
				success = this.displayRedPhase();
				break;
			case 3:
				success = this.displayRedYellowPhase();
				break;
			default:
				throw new IllegalArgumentException("Phase "+this.currentPhase+" not known");
		}
		
		return success;
	}
	
	private boolean displayGreenPhase() {
		if (this.otherAmpel.isRed()) {
			this.turnOffAll();
			this.turnOnGreen();
			this.nextPhase = 1;
			return true;
		}
		return false;
	}

	private boolean displayYellowPhase() {
		if (this.otherAmpel.isRedYellow()) {
			this.turnOffAll();
			this.turnOnYellow();
			this.nextPhase = 2;
			return true;
		}
		return false;
	}

	private boolean displayRedPhase() {
		if (this.otherAmpel.isGreen()) {
			this.turnOffAll();
			this.turnOnRed();
			this.nextPhase = 3;
			return true;
		}
		return false;
	}

	private boolean displayRedYellowPhase() {
		if (this.otherAmpel.isYellow()) {
			this.turnOffAll();
			this.turnOnRed();
			this.turnOnYellow();
			this.nextPhase = 0;
			return true;
		}
		return false;
	}

	public void turnOffAll() {
		this.pen.setColor(Color.BLACK);
		this.pen.fillRect(10, 10, 130, 410);
	}
	
	public void turnOnRed() {
		this.pen.setColor(Color.RED);
		this.pen.fillOval(20, 20, 110, 110);
	}

	public void turnOnYellow() {
		this.pen.setColor(Color.YELLOW);
		this.pen.fillOval(20, 150, 110, 110);
	}
	
	public void turnOnGreen() {
		this.pen.setColor(Color.GREEN);
		this.pen.fillOval(20, 280, 110, 110);
	}
}
