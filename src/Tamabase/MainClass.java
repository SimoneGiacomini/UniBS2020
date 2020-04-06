package Tamabase;

import it.unibs.fp.mylib.*;

public class MainClass {

	public final static String SALUTO = "Ciao, questo programma ti permette di avere un Tamagotchi tutto tuo ;-)";

	public static void main(String[] args) {

		System.out.println(Tamabase.BIG_TAMABASE + '\n');
		System.out.println(SALUTO);
		Tamabase t = UtilTamabase.creaTamabase();
		byte scelta;
		do {
			scelta = (byte) UtilTamabase.m.scegli();
			switch (scelta) {
			case 1:
				System.out.println(t.daiBiscotti(InputDati.leggiIntero("Inserisci la quantita' di biscotti da dare ",
						Tamabase.MIN_VALORI_INTERNI, Tamabase.MAX_INPUT_STIMOLI)));
				System.out.println(t.feliceTriste());
				break;

			case 2:
				System.out.println(t.daiCarezze(InputDati.leggiIntero("Inserisci la quantita' di carezze da dare ",
						Tamabase.MIN_VALORI_INTERNI, Tamabase.MAX_INPUT_STIMOLI)));
				System.out.println(t.feliceTriste());
				break;

			case 3:
				System.out.println(t.getStatistiche());
			default:
				break;
			}

		} while (scelta != 0);

		System.out.println("ARRIVEDERCI");
	}

}
