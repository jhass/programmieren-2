package de.fhh.pr2.common.u.b1;

import java.util.Random;

public class Philosoph extends Thread {
    private String einrueckung;
    private Gabel kleinere, groessere;
    private Random random;
    public Philosoph(int nr, Gabel links, Gabel rechts) {
        super("P"+nr);
        random = new Random();
        if (links.getNr() < rechts.getNr()) {
            this.kleinere= links;
            this.groessere= rechts;
        } else {
        	this.kleinere = rechts;
        	this.groessere = links;
        }

        StringBuffer sb= new StringBuffer();
        for (int i=0; i<nr-1; i++) {
            sb.append("                         ");
        }
        einrueckung= sb.toString();
    }
    @Override public void run() {
        while (!Thread.interrupted()) {
            out("greift nach Gabel " + kleinere.getNr());
            synchronized(kleinere) {
                out("nimmt Gabel " + kleinere.getNr() + " auf");
                out("greift nach Gabel " + groessere.getNr());
                synchronized(groessere) {
                    out("nimmt Gabel " + groessere.getNr() + " auf");
                    out("ißt ...");
                    aktivWarten(10000);
                    out("legt Gabel " + groessere.getNr() + " ab");
                }
                out("legt Gabel " + kleinere.getNr() + " ab");
            }
            out("denkt ...");
            aktivWarten(10);
        }
    }
    private void out(String msg) {
        System.out.println(einrueckung + Thread.currentThread().getName() + " " + msg);
    }
    private void aktivWarten(int n) {
        long N= random.nextInt(n)*20000;
        for (long i=0; i<N; i++);
    }
}
