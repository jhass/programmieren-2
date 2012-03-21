package de.fhh.pr2.common.u.a2;

public class BallspielMain {

    public static void main(String[] args) {
        Ballspiel s = new Ballspiel();
        System.out.println("Ballspiel: ");
        printBasisDaten(s);

        Fussball f = new Fussball();
        System.out.println("Fussball: ");
        printBasisDaten(f);
        System.out.println("  Einwurf     : " + f.einwurfRegel());
        System.out.println("  Ecke        : " + f.eckRegel());
        
        Handball h = new Handball();
        System.out.println("Handball: ");
        printBasisDaten(h);
        System.out.println("  Sonderregel : " + h.sonderregel());
        
        Jonglieren j = new Jonglieren();
        System.out.println("Jonglieren: ");
        printBasisDaten(j);
        System.out.println("  Lernregel   : " + j.lernregel());
        
        BeachSoccer b = new BeachSoccer();
        System.out.println("Beach-Soccer: ");
        printBasisDaten(b);
        System.out.println("  Einwurf     : " + b.einwurfRegel());
        System.out.println("  Ecke        : " + b.eckRegel());
    }
    
    public static void printBasisDaten(Ballspiel s) {
        System.out.println("  Mannschaften: " + s.getMannschaften());
        System.out.println("  Spieldauer  : " + s.getSpieldauer());
        System.out.println("  Bälle       : " + s.getBaelle());
    }
}
