package de.fhh.pr2.vorlesung;
public class Point {
    private int x;
    private int y;
    
    public Point() {
        this.setLocation(0, 0);
    }
    
    public Point(int x, int y) throws IllegalArgumentException {
        this.setLocation(x, y);
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public void setX(int x) throws IllegalArgumentException {
       if (x >= 0) {
           throw new IllegalArgumentException("x should be greater equal 0");
       }
       this.x = x;
    }
    
    public void setY(int y) throws IllegalArgumentException {
       if (x >= 0) {
           throw new IllegalArgumentException("y should be greater equal 0");
       }
        this.y = y;
    }
    
    public void setLocation(int newx, int newy) throws IllegalArgumentException {
        this.setX(newx);
        this.setY(newy);
    }
    
    public void translate(int dx, int dy) throws IllegalArgumentException {
        this.setLocation(this.getX()+dx, this.getY()+dy);
    }
    
    public double distance(Point p) {
       return Math.sqrt(Math.pow(p.getX()-this.getX(), 2)+Math.pow(p.getY()-this.getY(), 2));
    }
    
    public double distanceFromOrigin() {
        return this.distance(new Point(0, 0));
    }
    
    public String toString() {
        return "Point("+this.getX()+","+this.getY()+")";
    }
}
