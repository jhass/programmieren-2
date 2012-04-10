package de.fhh.pr2.jhass.u.a3;

import de.fhh.pr2.common.Zahlenkombi;

public class ZahlenkombiMain {
    public static void main(String[] args) {
        ZahlenkombiMitZeitmessung kombi= new ZahlenkombiMitZeitmessung(100000);
        suche(kombi);
        System.out.println("Durschnittliche Zeit: "+kombi.getAverageNeededTime()+"ms");
        
        ZahlenkombiSortiert kombi2= new ZahlenkombiSortiert(100000);
        suche(kombi2);
        System.out.println("Durschnittliche Zeit: "+kombi2.getAverageNeededTime()+"ms");
    }
    private static void suche(Zahlenkombi kombi) {
        for (int i=0; i<kombi.getMax(); i++) {
            if (kombi.istEnthalten(i)) {
                System.out.println(i);
            }
        }
    }
}
