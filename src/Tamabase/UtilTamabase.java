package Tamabase;

import util.mylib.*;

public class UtilTamabase {

	private static String[] voci = { "Dai biscotti", "Dai carezze", "Statistiche" };
	public static MyMenu m = new MyMenu("Cosa Vuoi fare al tuo Tamagotchi?", voci);

	public static Tamabase creaTamabase() {

		Tamabase t = new Tamabase();
		acquisisciNome(t);
		t.setAffetto(Tamabase.VAL_INIZ_RECOMMEND);
		t.setSazieta(Tamabase.VAL_INIZ_RECOMMEND);
		return t;
	}

	public static void acquisisciNome(Tamabase t) {
		t.setNome(InputDati.leggiStringaNonVuota("Inserisci il nome del tuo Tamagotchi "));
	}

}
