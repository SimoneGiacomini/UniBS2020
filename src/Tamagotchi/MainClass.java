package Tamagotchi;

import it.unibs.fp.mylib.InputDati;

/**classe Main 
 *  @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */

public class MainClass {

	public static final String CREAZIONE_TAMA_PERSONALIZ = "Vuoi creare il tuo "+Tamagotchi.class.getSimpleName()+" con valori consigliati (S) oppure a mano (N) \u003f ";
	public final static String SALUTO = "Ciao, questo programma ti permette di avere un  "+Tamagotchi.class.getSimpleName()+" tutto tuo ;-)";
	public static final String ARRIVEDERCI = "ARRIVEDERCI";
	public static void main(String[] args){

		Tamagotchi t = null;
		System.out.println(Tamagotchi.BIG_TAMAGOTCHI + System.lineSeparator());
		System.out.println(SALUTO);
	if(InputDati.yesOrNo(CREAZIONE_TAMA_PERSONALIZ))
		t=UtilTamagotchi.creaTamagotchiReccomed();
	else 
		t=UtilTamagotchi.creaTamagotchi();
		GiocaTamagotchi.usaTamagotchi(t);
		System.out.println(ARRIVEDERCI);
		//questo system.exit e' qui in modo da non far visualizzare piu' volte l'ultima scritta "ARRIVEDERCI"
		System.exit(0);
	}

	

}
