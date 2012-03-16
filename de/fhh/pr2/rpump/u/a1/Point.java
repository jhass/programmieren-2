package de.fhh.pr2.rpump.u.a1;

public class Point {
	private int x;
	private int y;
	
	public Point(int initialX, int initialY){
		x = initialX;
		y = initialY;
	}
	
	public Point() {
		x = 0; y= 0;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
		
	public void setLocation(int newx, int newy) {
		x= newx;
		y= newy;
	}
	public void translate(int dx, int dy){
		setLocation(x + dx, y + dy);
	}
	
	public double distance(Point other) {
		int dx = x - other.x;
		int dy = y - other.y;
		return Math.sqrt(dx*dx + dy*dy);
	}
	
	public double distanceFromOrigin() {
		Point origin = new Point();
		return distance(origin);
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
	
	public int manhattanDistance(Point other){
		return (Math.abs(y-other.y))+(Math.abs(x-other.x));
	}
}