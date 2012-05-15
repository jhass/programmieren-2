package de.fhh.pr2.common.u.a6;

public class TuerglockeMain {
	public static void main(String[] args) {
		Klingelknopf knopf = new Klingelknopf();
		
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
		
		
		Beobachter tuerglocke = new Beobachter() {

			@Override
			public void update(BeobachtetesObjekt o) {
				if (o.getZustand().equals("gedrückt")) {
					System.out.println("Klingeling");
				} else {
					System.out.println("Stille");
				}
			}
			
		};
		
		knopf.setBeobachter(tuerglocke);
		
		knopf.knopfDruecken();
		knopf.knopfLoslassen();
		knopf.knopfDruecken();
		knopf.knopfLoslassen();
	}

}
