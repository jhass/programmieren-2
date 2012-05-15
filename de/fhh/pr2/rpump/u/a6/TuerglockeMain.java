package de.fhh.pr2.rpump.u.a6;

public class TuerglockeMain {
	public static void main(String[] args) {
//		Klingelknopf knopf = new Klingelknopf();
//		class Tuerglocke implements Beobachter{
//
//			@Override
//			public void update(BeobachtetesObjekt o) {
//				if(o.getZustand().equals("gedrueckt")){
//					System.out.println("Klingeling!");
//				}else{
//					System.out.println("Stille.");
//				}
//				
//			}
//			
//		}
//		knopf.setBeobachter(new Tuerglocke());
//
//		knopf.knopfDruecken();
//		knopf.knopfLoslassen();
//		knopf.knopfDruecken();
//		knopf.knopfLoslassen();
//	}
		Klingelknopf knopf = new Klingelknopf();
		
		knopf.setBeobachter(new Beobachter(){ 

			@Override
			public void update(BeobachtetesObjekt o) {
				if(o.getZustand().equals("gedrueckt")){
					System.out.println("Klingeling!");
				}else{
					System.out.println("Stille.");
				}
				
			}
			
		});

		knopf.knopfDruecken();
		knopf.knopfLoslassen();
		knopf.knopfDruecken();
		knopf.knopfLoslassen();
	}
}
