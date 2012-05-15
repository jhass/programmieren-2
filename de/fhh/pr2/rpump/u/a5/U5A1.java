package de.fhh.pr2.rpump.u.a5;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import de.fhh.pr2.common.*;

public class U5A1 {

		public static void main(String[] args) {
		int size = 500;
		int count = 8;
		String ausgabe = "Test";
		
		DrawingPanel Screen = new DrawingPanel(size,size);
		Graphics2D pen = Screen.getGraphics();
		pen.translate(250, 250);
		
		FontMetrics charsizes = pen.getFontMetrics();
		Rectangle2D rect = charsizes.getStringBounds(ausgabe, pen);
		
		
		for(int i = 0; i< count; i++) {
			
			pen.drawString(ausgabe, 100, 100);
			pen.drawRect(100-5, 100-(int)rect.getHeight()-5, (int)rect.getWidth()+10, (int)rect.getHeight()+10);
			pen.rotate(Math.toRadians(360/count));
			
		}
		
		double[] values= { 15.4, 33.1, 50.3, 27, 13.7 };
		Color[] colors= { Color.BLACK, Color.BLUE, Color.RED, Color.GREEN, Color.ORANGE };
		String[] labels= { "schwarz", "blau", "rot", "grün", "orange" };
		chart(values, colors, labels, 0.5, new DrawingPanel(400, 400));
		

	}
		public static void chart(double[] values, Color[] colors, String[] labels, double scale, DrawingPanel panel){
			Graphics2D dummy = panel.getGraphics();
			int radiant = 0;
			double sum = 0;
			for(int i =0; i < values.length; i++){
				sum += values[i];
			}
			dummy.scale(scale, scale);
			dummy.translate(panel.getWidth()/2, panel.getHeight()/2);
			for(int i = 0; i < values.length; i++){
				int difference = (int)Math.round(((values[i])/sum)*360);
//				dummy.fillArc(x, y, width, height, startAngle, arcAngle);
				dummy.setColor(colors[i]);
				dummy.fillArc(-(int)(panel.getWidth()*scale/2), -(int)(panel.getHeight()*scale/2), (int)(panel.getWidth()*scale), (int)(panel.getHeight()*scale), radiant, difference);
				dummy.drawString(labels[i], (int)((100*scale)*Math.cos((difference/2)+radiant)), -(int)((100*scale)*Math.sin((difference/2)+radiant)));
				radiant += difference;
			}
		}

}
