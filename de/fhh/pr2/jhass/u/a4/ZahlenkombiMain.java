package de.fhh.pr2.jhass.u.a4;

public class ZahlenkombiMain {

    public static void main(String[] args) {
        final int max= 100000;
        IZahlenkombi[] kombis= { new Zahlenkombi(max), new ZahlenkombiMitTreeSet(max) };
        for (IZahlenkombi kombi : kombis) {
            long start= System.currentTimeMillis();
            int count= suche(kombi);
            long end= System.currentTimeMillis();
            System.out.println(kombi.getClass().getName());
            System.out.println("  Dauer: " + (end-start) + " ms");
            System.out.println("  count = " + count);
        }
    }
    private static int suche(IZahlenkombi kombi) {
        int count= 0;
        for (int i=0; i<kombi.getMax(); i++) {
            if (kombi.istEnthalten(i)) {
                count++;
            }
        }
        return count;
    }
}
