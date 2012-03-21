package de.fhh.pr2.common.u.a2;

import java.awt.Graphics;

import de.fhh.pr2.jhass.u.a1.Point;

public class DashedLine extends Line {
	private int[] dashes;
	
	public DashedLine(Point p1, Point p2, int[] dashes) {
		super(p1, p2);
		this.setDashes(dashes);
	}

	public int[] getDashes() {
		return this.dashes;
	}
	
	public void setDashes(int[] dashes) {
		this.dashes = dashes;
	}
	
	@Override
	public void draw(Graphics pen) {
		int currentLength = 0;
		int totalLength = (int) this.length();
		int dX = this.getP2().getX()-this.getP1().getX();
		int dY = this.getP2().getY()-this.getP1().getY();
		Point currentPoint = new Point(this.getP1());
		Point nextPoint;
		Line line = new Line(this.getP1(), this.getP2());
		boolean draw = true;
		
		do {
			for (int dashLength : this.getDashes()) {
				nextPoint = new Point(currentPoint.getX()+dX*dashLength/totalLength,
									  currentPoint.getY()+dY*dashLength/totalLength);
				
				currentLength += dashLength;
				
				line.setP1(currentPoint);
				line.setP2(nextPoint);
				
				if (currentLength > totalLength) {
					if (draw) {
						line.setP2(this.getP2());
					} else {
						break;
					}
				}
				
				if (draw) {
					line.draw(pen);
					draw = false;
				} else {
					draw = true;
				}
				
				currentPoint = nextPoint;
			}
		} while (currentLength < totalLength);
	}
	
	@Override
	public String toString() {
		return "["+super.toString()+"], dashes="+this.dashes+"]";
	}
}
