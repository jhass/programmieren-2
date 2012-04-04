package de.fhh.pr2.rpump.u.a2;

import java.awt.Graphics;
import java.util.Arrays;

public class DashedLine extends Line {
	private int[] dashes;

	public DashedLine(Point p1, Point p2, int thickness, int[] dashes) {
		super(p1, p2, thickness);
		this.dashes = dashes;
		}
	
	public DashedLine(Point p1, Point p2, int[] dashes){
		super(p1, p2);
		this.dashes = dashes;
		
	}
	
	@Override
	public void draw(Graphics g) {
		int counter = 0;
		int dashLen;
		Point P = this.getP1();
		Point Pnext;
		double currentLen = 0;
		double totalLen= this.getDistance();
		int dX = this.getP2().getX() - this.getP1().getX();
		int dY = this.getP2().getY() - this.getP1().getY();
		do {
			if(counter< dashes.length){
				dashLen= this.dashes[counter];
			}else{
				counter = 0;
				dashLen= this.dashes[counter];
				}
			Pnext = new Point((int)Math.round(P.getX() + dX * dashLen / totalLen),
									(int)Math.round(P.getY() + dY * dashLen / totalLen));
			currentLen = currentLen + dashLen;
			if(currentLen > totalLen && counter%2 == 0){
				Line Pline = new Line(P, new Point(Math.min(this.getP2().getX(), Pnext.getX()), 
												   Math.min(this.getP2().getY(), Pnext.getY())));
				Pline.draw(g);
				break;
			}
			if(counter%2 == 0){
				Line Pline = new Line(P,Pnext);
				Pline.draw(g);
			}
			counter++;
			P = Pnext;
			}while(currentLen < totalLen);
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("["+super.toString()+", dashes="+Arrays.toString(dashes));
		return sb.toString();
	}

}
