package de.fhh.pr2.rpump.u.a2;

import java.awt.Graphics;

import de.fhh.pr2.common.DrawingPanel;

public class LineMain {
	public static void main(String[] args) {
		DrawingPanel Zeichner = new DrawingPanel(200,200);
//		Line line = new Line(new Point(50,50),new Point (200,200),5);
//		line.draw(Zeichner.getGraphics());
//		Line line = new Line(new Point(1,1),new Point (200,200));
//		System.out.println(line);
//		System.out.println(line.getP1()+""+line.getP2());
//		line.draw(Zeichner.getGraphics());	//test draw
		
		//Aufgabe3:
		drawZebra(Zeichner.getGraphics());	
		
		//Aufgabe 4:
//		int[] zebrastreifen = {15,25};
//		DashedLine zebra = new DashedLine(new Point(10,10), new Point(190,10), zebrastreifen);
//		zebra.draw(Zeichner.getGraphics());
//		System.out.println(zebra);
//		
		//Aufgabe 4 Test mit Uebungs-Code
		DrawingPanel pnl = new DrawingPanel(100, 100);
		Graphics g = pnl.getGraphics();
		int[] d= new int[] { 15, 10 };
		DashedLine dl;
		dl=new DashedLine(new Point(10,10), new Point(90,10), d); dl.draw(g);
		dl=new DashedLine(new Point(10,10), new Point(90,37), d); dl.draw(g);
		dl=new DashedLine(new Point(10,10), new Point(90,63), d); dl.draw(g);
		dl=new DashedLine(new Point(10,10), new Point(90,90), d); dl.draw(g);
		dl=new DashedLine(new Point(10,10), new Point(63,90), d); dl.draw(g);
		dl=new DashedLine(new Point(10,10), new Point(37,90), d); dl.draw(g);
		dl=new DashedLine(new Point(10,10), new Point(10,90), d); dl.draw(g);
		
		
	}
	
	public static void drawZebra(Graphics g) {
		DashedLine drawingLine;
		int[] dashes = {10,0};
		for(int diff = 0; diff <= 200; diff+= 10){
			drawingLine = new DashedLine(new Point(0,diff), new Point(diff,0),10000, dashes);
			drawingLine.draw(g);
			if(diff<200){
				drawingLine = new DashedLine(new Point(diff,200), new Point(200,diff), 10000, dashes);
				drawingLine.draw(g);
			}
		}
	}
}
