package de.fhh.pr2.u.a1;

public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point(1,1);
        Point p2 = new Point(2,2);
        
        System.out.println("p1: "+p1);
        System.out.println("p2: "+p2);
        System.out.println("Distance p2 to p1: "+p1.distance(p2));
        System.out.println("Manhatten distance p2 to p1: "+p1.manhattenDistance(p2));
    }
}
