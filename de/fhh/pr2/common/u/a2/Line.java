package de.fhh.pr2.common.u.a2;

import java.awt.Graphics;
import java.awt.Polygon;

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
		pen.drawLine((int) this.p1.getX(), (int) this.p1.getY(),
				     (int) this.p2.getX(), (int) this.p2.getY());
	}
	
	public void draw(Graphics pen, double thickness) {
		// compute normal vector
		Point direction = new Point(this.getP2().getX()-this.getP1().getX(),
									this.getP2().getY()-this.getP1().getY());
		Point normal = new Point(-direction.getY(), direction.getX());
		double length = normal.length();
		normal.setX((normal.getX()/length)+thickness);
		normal.setY((normal.getY()/length)+thickness);
		pen.fillOval((int) this.getP1().getX(), (int) this.getP1().getY(), 
					 (int) thickness, (int) thickness);
		pen.fillOval((int) this.getP2().getX(), (int) this.getP2().getY(), 
				 (int) thickness, (int) thickness);
		
		Point a = new Point(this.getP1());
		a.add(normal);
		Point b = new Point(this.getP2());
		b.add(normal);
		Point c = new Point(this.getP2());
		c.sub(normal);
		Point d = new Point(this.getP1());
		d.sub(normal);
		int[] xes = {(int) a.getX(), (int) b.getX(), (int) c.getX(), (int) d.getX()};
		int[] yes = {(int) a.getY(), (int) b.getY(), (int) c.getY(), (int) d.getY()};
		Polygon line = new Polygon(xes, yes, 4);
		pen.fillPolygon(line);
	}
	
	public String toString() {
		return "["+this.p1+", "+this.p2+"]";
	}
}
