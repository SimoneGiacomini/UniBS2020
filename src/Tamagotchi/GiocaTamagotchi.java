package Tamagotchi;

import it.unibs.fp.mylib.EstrazioniCasuali;
import it.unibs.fp.mylib.InputDati;
import it.unibs.fp.mylib.MyMenu;
/**Classe per far giocare un {@linkplain Tamagotchi}
 *@author Simone s.giacomini008@studenti.unibs.it */
public class GiocaTamagotchi {
	public static final byte MIN_STIMOLI = Tamagotchi.MIN_VALORI_INTERNI+1;
	/**Voci del menu'*/
		private static final String[] voci = { "Dai biscotti", "Dai carezze", "Statistiche" };
		/**<b>Menu'</b>*/
	private final static MyMenu m = new MyMenu("Cosa Vuoi fare al tuo Tamagotchi?", voci);
	/**
	 * metodo che permette di usare il tamagotchi
	 * 
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public static void usaTamagotchi(Tamagotchi t){
		byte valoreIn;
		byte scelta;
		do {
			
			if(GiocaTamagotchi.endGame(t))
				if(!GiocaTamagotchi.rePlay())
					break;
			
			scelta = (byte) m.scegli();
			switch (scelta) {
			case 1:
				// prima si ottiene il numero e poi viene estratto
				valoreIn = (byte) EstrazioniCasuali.estraiIntero(MIN_STIMOLI,
						InputDati.leggiIntero("Inserisci la quantita' di biscotti da dare ",
								MIN_STIMOLI, Tamagotchi.MAX_INPUT_STIMOLI));
				System.out.println("Biscotti estratti: " + valoreIn);
				System.out.println(t.daiBiscotti(valoreIn));
				break;
	
			case 2:
				// prima si ottiene il numero e poi viene estratto
				valoreIn = (byte) EstrazioniCasuali.estraiIntero(MIN_STIMOLI,
						InputDati.leggiIntero("Inserisci la quantita' di carezze da dare ",
								MIN_STIMOLI, Tamagotchi.MAX_INPUT_STIMOLI));
				System.out.println("Carezze estratte: " + valoreIn);
				System.out.println(t.daiCarezze(valoreIn));
					
				break;
	
			case 3:
				System.out.println(t.toString());
			default:
				break;
			}
	
		} while (scelta != 0);
	}
	/**Scopre se il gioco attuale del tamagotchi e' finito  */
	
	public static boolean endGame(Tamagotchi t) {
		if (t.isMorto())
			return true;
		return false;
	
	}
	/**Chiede se si vuole giocare una nuova partita*/
	public static boolean rePlay(){
		if (InputDati.yesOrNo("Vuoi giocare ancora \u003f ")) {
			MainClass.main(null);
		}
		return false;
	}
	

}
