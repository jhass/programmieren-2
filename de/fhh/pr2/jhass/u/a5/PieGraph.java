package de.fhh.pr2.jhass.u.a5;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

import de.fhh.pr2.common.DrawingPanel;

public class PieGraph {
	public static void main(String[] args) {
		double[] values= { 15.4, 33.1, 50.3, 27, 13.7 };
		Color[] colors= { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE };
		String[] labels= { "schwarz", "blau", "rot", "grün", "orange" };
		chart(values, colors, labels, 0.5, new DrawingPanel(400, 400));

	}
	
	/**
	* Zeichnet ein Tortendiagramm.
	* Alle Parameter-Arrays müssen dieselbe Länge haben.
	* @param values Array der abzubildenden Werte
	* @param colors Array der Farben
	* @param labels Array der Texte, die neben dem Tortendiagramm angezeigt werden
	* @param scale
	Faktor, um den das Diagramm skaliert wird. Geeignet sind in der Regel
	*
	Werte zwischen 0.1 und 0.5
	* @param panel
	Das DrawingPanel, auf dem das Tortdendiagramm zentriert
	*
	ausgegeben wird.
	*/

	public static void chart(double[] values, Color[] colors, String[] labels,
							 double scale, DrawingPanel drawingPanel) {
		if (values.length != colors.length || values.length != labels.length ||
			colors.length != labels.length) {
			throw new IllegalArgumentException("Alle Parameter-Arrays müssen dieselbe Länge haben.");
		}
		
		Dimension win = drawingPanel.getSize();
		Point center = new Point(win.width/2, win.height/2);
		Point leftTopCorner = new Point((int) ((center.x/2)),
				                        (int) ((center.y/2)));
		Point rightBottomCorner = new Point(leftTopCorner.x*2,
				                            leftTopCorner.y*2); 
		
		int absScale = (int) Math.round(scale*50);
		leftTopCorner.translate(-absScale, -absScale);
		rightBottomCorner.translate(2*absScale, 2*absScale);
		
		Graphics2D pen = drawingPanel.getGraphics();
		
		
		double startAngle = 0;
		double factor = 360/sum(values);;
		double value;
		
		for (int i=0; i<values.length; i++) {
			pen.setColor(colors[i]);
			
			value = values[i]*factor;
			if (i == values.length-1) {
				value = 360-startAngle;
			}
			pen.fillArc(leftTopCorner.x, leftTopCorner.y,
						rightBottomCorner.x, rightBottomCorner.y,
						(int) Math.round(startAngle), (int) Math.round(value));
			startAngle += value;
			
			pen.drawString(labels[i]+" ("+values[i]+")", 100, 100);
		}
	}

	private static double sum(double[] values) {
		double sum = 0;
		for (double value : values) {
			sum += value;
		}
		return sum;
	}

	
	
}
