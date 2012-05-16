package de.fhh.pr2.jhass.u.b1;

import java.awt.Color;
import java.awt.Graphics2D;

import de.fhh.pr2.common.DrawingPanel;


public class Ampel extends Thread {
	interface AmpelPhase {
		public boolean isNotSafeTo(Ampel ampel);
		public void displayOn(Ampel ampel);
		public Ampel.Phase next();
	}
	
	public enum Phase implements AmpelPhase {
		GREEN {
			@Override
			public boolean isNotSafeTo(Ampel ampel) {
				return ampel.getCurrentPhase() != RED;
			}
			
			@Override
			public void displayOn(Ampel ampel) {
				ampel.turnOffAll();
				ampel.turnOnGreen();
			}
			
			@Override
			public Phase next() {
				return YELLOW;
			}
		},
		YELLOW {
			@Override
			public boolean isNotSafeTo(Ampel ampel) {
				return ampel.getCurrentPhase() != RED_YELLOW;
			}
			
			@Override
			public void displayOn(Ampel ampel) {
				ampel.turnOffAll();
				ampel.turnOnYellow();
			}
			
			@Override
			public Phase next() {
				return RED;
			}
		}, 
		RED {
			@Override
			public boolean isNotSafeTo(Ampel ampel) {
				return ampel.getCurrentPhase() != GREEN;
			}
			
			@Override
			public void displayOn(Ampel ampel) {
				ampel.turnOffAll();
				ampel.turnOnRed();	
			}
			
			@Override
			public Phase next() {
				return RED_YELLOW;
			}
		}, RED_YELLOW {
			@Override
			public boolean isNotSafeTo(Ampel ampel) {
				return ampel.getCurrentPhase() != YELLOW;
			}
			
			public void displayOn(Ampel ampel) {
				ampel.turnOffAll();
				ampel.turnOnRed();
				ampel.turnOnYellow();
			}
			
			public Phase next() {
				return GREEN;
			}
		};
	}
	
	private DrawingPanel panel;
	private Graphics2D pen;
	private String name;
	private int[] phaseWaitTimes;
	private Phase currentPhase;
	private Phase nextPhase;
	private Ampel otherAmpel;
	
	public Ampel(String name, int[] phaseWaitTimes, Phase startPhase) {
		if (phaseWaitTimes.length != 4) {
			throw new IllegalArgumentException("phases must be exactly 4 elements");
		}
		synchronized (DrawingPanel.class) {
			this.panel = new DrawingPanel(150, 450);
		}
		// ignore that hack
		panel.setLocation((int) panel.getLocation().getX()+startPhase.ordinal()*100, (int) panel.getLocation().getY());
		
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
	
	public Phase getCurrentPhase() {
		return this.currentPhase;
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
			Thread.sleep(1000*this.phaseWaitTimes[this.currentPhase.ordinal()]);
		} catch (InterruptedException e) {}
	}
	
	private synchronized void goToNextPhase() {
		this.currentPhase = this.nextPhase;
		this.notifyAll();
		
		while (this.currentPhase.isNotSafeTo(this.otherAmpel)) {
			synchronized (this.otherAmpel) {
				try {
					this.otherAmpel.wait();
				} catch (InterruptedException e) {}
			}
		}
		
		this.currentPhase.displayOn(this);
		this.nextPhase = this.nextPhase.next();
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