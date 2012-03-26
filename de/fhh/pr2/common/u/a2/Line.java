package de.fhh.pr2.common.u.a2;

import java.awt.Graphics;

import de.fhh.pr2.common.u.a1.Point;

public class Line {
	private Point p1;
	private Point p2;
	
	public Line(Point p1, Point p2) {
		this.setP1(p1);
		this.setP2(p2);
	}
	
	public Point getP1() {
		return new Point(this.p1);
	}
	
	public Point getP2() {
		return new Point(this.p2);
	}
	
	protected void setP1(Point p) {
		this.p1 = new Point(p);
	}
	
	protected void setP2(Point p) {
		this.p2 = new Point(p);
	}
	
	public double length() {
		return this.p1.distance(this.p2);
	}
	
	public void draw(Graphics pen) {
		pen.drawLine(this.p1.getX(), this.p1.getY(),
				     this.p2.getX(), this.p2.getY());
	}
	
	public String toString() {
		return "["+this.p1+", "+this.p2+"]";
	}
}
