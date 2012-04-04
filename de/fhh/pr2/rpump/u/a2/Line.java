package de.fhh.pr2.rpump.u.a2;

import java.awt.Graphics;

public class Line {
	private Point p1;
	private Point p2;
	private int thickness = 10;
	
	public Line(Point p1, Point p2, int thickness) {
		this.p1 = p1;
		this.p2 = p2;
		this.thickness= thickness;
	}
	
	public Line (Point p1, Point p2){
		this(p1,p2,2);
	}
	
	public Point getP1() {
		return p1;
	}
	
	public Point getP2() {
		return p2;
	}
	
	public String toString(){
		return "["+p1.toString()+","+p2.toString()+"]";
	}
	
	public double getDistance(){
		return p1.distance(p2);
	}
	
//	public void draw(Graphics g){
//		this.draw(g, thickness);
//	}
	
	public void draw(Graphics g){
		Point dir = new Point(this.p2.getX()-this.p1.getX(), 
							  this.p2.getY()-this.p1.getY());
		Point n = new Point(-dir.getY(), dir.getX());
		Point nNormal = new Point((int)(Math.round((n.getX()/n.vectorLength()))), 
								  (int)(Math.round((n.getY()/n.vectorLength()))));
		
		int[] xes = {p1.getX()+(nNormal.getX()*(thickness/2)), 
					 p1.getX()-(nNormal.getX()*(thickness/2)), 
					 p2.getX()-(nNormal.getX()*(thickness/2)), 
					 p2.getX()+(nNormal.getX()*(thickness/2))};
		
		int[] yes = {p1.getY()+(nNormal.getY()*(thickness/2)), 
					 p1.getY()-(nNormal.getY()*(thickness/2)), 
					 p2.getY()-(nNormal.getY()*(thickness/2)), 
					 p2.getY()+(nNormal.getY()*(thickness/2))};
		
		g.fillOval((int)Math.round(p1.getX()-(thickness/2)), (int)Math.round(p1.getY()-(thickness/2)), thickness, thickness);
		g.fillPolygon(xes, yes, 4);
		g.fillOval((int)Math.round(p2.getX()-(thickness/2)), (int)Math.round(p2.getY()-(thickness/2)), thickness, thickness);
	}

}
