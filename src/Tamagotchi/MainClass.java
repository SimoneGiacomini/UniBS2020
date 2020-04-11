package Tamagotchi;

import it.unibs.fp.mylib.*;

public class MainClass {

	public final static String SALUTO = "Ciao, questo programma ti permette di avere un Tamagotchi tutto tuo ;-)";

	public static void main(String[] args) {

		System.out.println(Tamagotchi.BIG_TAMABASE + '\n');
		System.out.println(SALUTO);
		Tamagotchi t = UtilTamagotchi.creaTamabase();
		byte scelta;
		do {
			scelta = (byte) UtilTamagotchi.m.scegli();
			switch (scelta) {
			case 1:
				System.out.println(t.daiBiscotti(InputDati.leggiIntero("Inserisci la quantita' di biscotti da dare ",
						Tamagotchi.MIN_VALORI_INTERNI, Tamagotchi.MAX_INPUT_STIMOLI)));
				System.out.println(t.feliceTriste());
				break;

			case 2:
				System.out.println(t.daiCarezze(InputDati.leggiIntero("Inserisci la quantita' di carezze da dare ",
						Tamagotchi.MIN_VALORI_INTERNI, Tamagotchi.MAX_INPUT_STIMOLI)));
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
