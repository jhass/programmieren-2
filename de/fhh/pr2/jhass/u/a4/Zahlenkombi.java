package de.fhh.pr2.jhass.u.a4;

import java.util.Random;

public class Zahlenkombi implements IZahlenkombi {

    private int[] zahlen;
    private int max;
    
    // Erzeugt eine Zahlenkombi mit 10000 Zahlen im Intervall [0,max-1]
    public Zahlenkombi(int max) {
        this.max= max;
        zahlen= new int[10000];
        Random rand= new Random();
        for (int i=0; i<zahlen.length; i++) {
            zahlen[i]= rand.nextInt(max);
        }
    }
    
    // Liefert die obere Intervallgrenze -1
    public int getMax() {
        return max;
    }
    
    // Liefert true, wenn die zahl enthalten ist.
    public boolean istEnthalten(int zahl) {
        for (int i=0; i<zahlen.length; i++) {
            if (zahlen[i]== zahl) {
                return true;
            }
        }
        return false;
    }
    
    protected int[] getZahlenArray() {
        return zahlen;
    }
}
