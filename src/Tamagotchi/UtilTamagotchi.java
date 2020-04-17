package Tamagotchi;

import it.unibs.fp.mylib.InputDati;

/**
 * classe utile per interfacciarsi al {@linkplain Tamagotchi}
 * 
 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */
public class  UtilTamagotchi {
	public static final byte ERR_TOO_LOW = -1;

	public static final byte ERR_TOO_HIGH = +1;

	public static final byte OK = 0;

	// ERRORI
	static final String ERR_NUM_INSERT_TOO_HIGHT = "ATTENZIONE, IL NUMERO INSERITO \u00e8 TROPPO ALTO, MASSIMO ";

	static final String ERR_NUM_INSERT_TOO_LOW = "ATTENZIONE, IL NUMERO INSERITO \u00e8 TROPPO BASSO, MINIMO ";


	/**
	 * Costante {@linkplain String} utilizzata per l'acquisizione/modifica del nome
	 * del {@linkplain Tamagotchi}
	 */
	private static final String NEW_NOME_TAMAGOTCHI = System.lineSeparator() + "Inserisci il nome del tuo "
			+ Tamagotchi.class.getSimpleName() + " ";

	/**
	 * Costante {@linkplain String} utilizzata per l'acquisizione/modifica della
	 * Sazieta del {@linkplain Tamagotchi}
	 */
	private static final String NEW_SAZIETA_TAMAGOTCHI = System.lineSeparator() + "Inserisci la " + Tamagotchi.SAZIETA
			+ " del tuo " + Tamagotchi.class.getSimpleName() + " ";
	/**
	 * Costante {@linkplain String} utilizzata per l'acquisizione/modifica della
	 * affetto del {@linkplain Tamagotchi}
	 */
	private static final String NEW_AFFETTO_TAMAGOTCHI = System.lineSeparator() + "Inserisci l'" + Tamagotchi.AFFETTO
			+ " del tuo " + Tamagotchi.class.getSimpleName() + " ";

	/**
	 * Metodo che permette di creare un {@link Tamagotchi}
	 * 
	 
	 * @return un oggetto {@linkplain Tamagotchi} con valori di <b>affetto</b> e di
	 *         <b>sazieta</b> a {@linkplain Tamagotchi#VAL_INIZ_RECOMMEND}
	 * @since 2020/4/14
	 */
	public static Tamagotchi creaTamagotchiReccomed() {
		Tamagotchi t = new Tamagotchi();
		modificaNome(t);
		return t;
	}

	/**
	 * Metodo che permette di creare un {@link Tamagotchi}
	 * 
	 * @param
	 * @return un oggetto {@linkplain Tamagotchi} con valori di <b>affetto</b> e di
	 *         <b>sazieta</b> inseriti dall'utente
	 * @since 2020/4/14
	 */
	public static Tamagotchi creaTamagotchi() {

		Tamagotchi t = new Tamagotchi(InputDati.leggiStringa(NEW_NOME_TAMAGOTCHI),
				InputDati.leggiIntero(NEW_AFFETTO_TAMAGOTCHI, Tamagotchi.MAX_INPUT_STIMOLI,
						Tamagotchi.MAX_VALORI_INTERNI),
				InputDati.leggiIntero(NEW_SAZIETA_TAMAGOTCHI, Tamagotchi.MAX_INPUT_STIMOLI,
						Tamagotchi.MAX_VALORI_INTERNI));
		return t;
	}

	/**
	 * Metodo che permette di modificare il <b>nome</b> di un {@link Tamagotchi}
	 * 
	 * @param
	 * @since 2020/4/14
	 */
	public static void modificaNome(Tamagotchi t) {
		t.setNome(InputDati.leggiStringaNonVuota(NEW_NOME_TAMAGOTCHI));
	}

	/**
	 * controlla se <b>valore </b>e' all'interno del range
	 * {@code (numeroInput<massimo && numeroInput>minimo)}
	 * 
	 * @return
	 *         <p>
	 *         <b>{@link ERR_TOO_HIGH}</b> se il numero passato e' maggiore del
	 *         massimo
	 *         </p>
	 *         <p>
	 *         <b>{@link ERR_TOO_LOW}</b> se il numero passato e' minore del minimo
	 *         <p>
	 *         <b>{@link OK}</b> se il numero e' all'interno del range
	 *         </p>
	 */
	public static int inRange(float valore, int massimo, int minimo) {
		// primo check, se il numero passato e' maggiore di massimo, viene ritornato +1
		if (valore > (float) massimo)
			return ERR_TOO_HIGH;
	
		// secondo check se il numero passato e' sotto minimo, viene ritornato -1
		if (valore < (float) minimo)
			return ERR_TOO_LOW;
	
		return OK;
	}

	/**
	 * controlla se il <b>valore </b>e' all'interno di un range
	 * 
	 * @see inRange
	 * 
	 * @throws IllegalArgumentException
	 *             se il numero passato e' maggiore del massimo
	 * @throws IllegalArgumentException
	 *             se il numero passato e' minore del minimo
	 * 
	 */
	public static void checkErrInBuild(float valore, int massimo, int minimo) {
		switch (inRange(valore, massimo, minimo)) {
		case ERR_TOO_HIGH:
			throw new IllegalArgumentException(ERR_NUM_INSERT_TOO_HIGHT + massimo);
		case ERR_TOO_LOW:
			throw new IllegalArgumentException(ERR_NUM_INSERT_TOO_LOW + minimo);
		default:
			break;
		}
	}

	/**
	 * Metodo che calcola la percentuale
	 * <p>
	 * <b>PER ESEMPIO</b> se inserisco <b>valorePercentuale</b>=10 e come
	 * <b>massimoValore</b>=33 il valore ritornato e' 3.3
	 * </p>
	 * 
	 * @param
	 * @since 2020/4/14
	 */
	public static float percentuale(float valoreDiPercentuale, float massimoValore) {
		return (float) (massimoValore * valoreDiPercentuale / 100.0);
	}

}
