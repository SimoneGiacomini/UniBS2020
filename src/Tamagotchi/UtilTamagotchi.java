package Tamagotchi;

import it.unibs.fp.mylib.*;;

public class UtilTamagotchi {

	private static String[] voci = { "Dai biscotti", "Dai carezze", "Statistiche" };
	public static MyMenu m = new MyMenu("Cosa Vuoi fare al tuo Tamagotchi?", voci);

	public static Tamagotchi creaTamabase() {

		Tamagotchi t = new Tamagotchi();
		acquisisciNome(t);
		t.setAffetto(Tamagotchi.VAL_INIZ_RECOMMEND);
		t.setSazieta(Tamagotchi.VAL_INIZ_RECOMMEND);
		return t;
	}

	public static void acquisisciNome(Tamagotchi t) {
		t.setNome(InputDati.leggiStringaNonVuota("Inserisci il nome del tuo Tamagotchi "));
	}

}
