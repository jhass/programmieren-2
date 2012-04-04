package de.fhh.pr2.common;

public class ZahlenkombiMain {
    public static void main(String[] args) {
        Zahlenkombi kombi= new Zahlenkombi(100000);
        suche(kombi);
    }
    private static void suche(Zahlenkombi kombi) {
        for (int i=0; i<kombi.getMax(); i++) {
            if (kombi.istEnthalten(i)) {
                System.out.println(i);
            }
        }
    }
}
