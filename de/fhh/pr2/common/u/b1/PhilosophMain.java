package de.fhh.pr2.common.u.b1;

public class PhilosophMain {
    public static void main(String[] args) {
        final int N= 3;
        Gabel[] gabeln= new Gabel[N];
        for (int i=1; i<=gabeln.length; i++) { 
            gabeln[i-1]= new Gabel(i); 
        }
        Philosoph[] philosophen= new Philosoph[N];
        for (int i=1; i<=philosophen.length; i++) {
            philosophen[i-1]= new Philosoph(i, gabeln[i-1], gabeln[i%N]);
            philosophen[i-1].start();
        }
    }
}
