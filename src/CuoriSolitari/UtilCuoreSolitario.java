package CuoriSolitari;

public class UtilCuoreSolitario {


	public static void acquisisciSolitario(Solitario s) {

		acquisisciSesso(s);

		acquisisciPseudonimo(s);

		Saluto(s);

		acquisisciSegnoSolitario(s);

		acquisisciSegnoPartner(s);

		acquisisciEta(s);

	}

	private static void acquisisciPseudonimo(Solitario s) {
		String pseudonimo;

		pseudonimo = InputDati.leggiStringaNonVuota("Immetta uno pseudonimo o nickname\n");

		s.setPseudonimo(pseudonimo);
	}

	private static void acquisisciEta(Solitario s) {
		int eta = 0;
		
			eta = InputDati.leggiIntero("Infine inserisca la sua eta'\n", Solitario.MAGGIORENNE, Solitario.ETA_MASSIMA);
			
		s.setEta((byte) eta);
	}

	private static void acquisisciSesso(Solitario s) {

		int numeroScelto;
		String tuttiSessi="";
		for (byte i = 0; i < Sesso.values().length; i++) {
			
			tuttiSessi+=(i + " --> " + Sesso.values()[i]+'\n');
		}
		numeroScelto = InputDati.leggiIntero("E' femmina o maschio?\n"+tuttiSessi, 0, Sesso.values().length-1);

		s.setSesso(Sesso.values()[numeroScelto]);
	}

	private static int acquisisciSegno(String messaggio) {

		int numeroScelto;
		String tuttiSegni = "";
		for (byte i = 0; i < SegnoZodiacale.values().length; i++) {

		
			tuttiSegni+=(i + " --> " + SegnoZodiacale.values()[i]+'\n');
		}
		numeroScelto = InputDati.leggiIntero(messaggio+tuttiSegni, 0, SegnoZodiacale.values().length-1);

		return numeroScelto;
	}

	private static void acquisisciSegnoSolitario(Solitario s) {
		s.setSegnoSolitario(SegnoZodiacale.values()[acquisisciSegno("Di che segno Zodiacale e'? \n")]);
	}

	private static void acquisisciSegnoPartner(Solitario s) {
		s.setSegnoPartner(SegnoZodiacale.values()[acquisisciSegno("Mentre di che segno Zodiacale vorrebbe il partner? \n")]);
	}
	
	public static void Saluto(Solitario s) {

		String risultato = (s.getSesso().equals(Sesso.FEMMINA)) ? "a Signora " + s.getPseudonimo()
				: "o Signor " + s.getPseudonimo();
		System.out.println("Benvenut" + risultato);

	}
}