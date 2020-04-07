package Tamagotchi;

/**
 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */
public class Tamabase {

	private String nome;
	private byte affetto;

	private byte sazieta;

	/**
	 * E' una stringa autoFormattata, recante il nome del progetto, che metto in
	 * tutti i miei lavori
	 * 
	 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
	 * 
	 */
	public static final String BIG_TAMABASE = "¶¶¶¶¶¶    ¶¶    ¶¶   ¶¶   ¶¶    ¶¶¶¶¶¶    ¶¶     ¶¶¶¶   ¶¶¶¶¶¶¶ \n"
			+ "¶ ¶¶ ¶   ¶¶¶¶   ¶¶¶ ¶¶¶  ¶¶¶¶    ¶¶  ¶¶  ¶¶¶¶   ¶¶  ¶¶   ¶¶   ¶ \n"
			+ "  ¶¶    ¶¶  ¶¶  ¶¶¶¶¶¶¶ ¶¶  ¶¶   ¶¶  ¶¶ ¶¶  ¶¶  ¶¶¶      ¶¶ ¶   \n"
			+ "  ¶¶    ¶¶  ¶¶  ¶¶¶¶¶¶¶ ¶¶  ¶¶   ¶¶¶¶¶  ¶¶  ¶¶   ¶¶¶     ¶¶¶¶   \n"
			+ "  ¶¶    ¶¶¶¶¶¶  ¶¶ ¶ ¶¶ ¶¶¶¶¶¶   ¶¶  ¶¶ ¶¶¶¶¶¶     ¶¶¶   ¶¶ ¶   \n"
			+ "  ¶¶    ¶¶  ¶¶  ¶¶   ¶¶ ¶¶  ¶¶   ¶¶  ¶¶ ¶¶  ¶¶  ¶¶  ¶¶   ¶¶   ¶ \n"
			+ " ¶¶¶¶   ¶¶  ¶¶  ¶¶   ¶¶ ¶¶  ¶¶  ¶¶¶¶¶¶  ¶¶  ¶¶   ¶¶¶¶   ¶¶¶¶¶¶¶ by Simone Giacomini";
	/**
	 * Massimo numero di biscotti e di carezze
	 */
	public static final byte MAX_INPUT_STIMOLI = 20;
	/**
	 * UnitÃ  di affetto/sazieta' che si sottraggono quando si danno o
	 * carezze/biscotti
	 */
	public static final byte DIMINUZIONE = 5;
	/**
	 * Massimo numero possibile di affetto/sazieta'
	 */
	public static final byte MAX_VALORI_INTERNI = 100;

	/**
	 * Minor numero possibile di affetto/sazieta' 
	 */
	public static final byte MIN_VALORI_INTERNI = 1;

	/**
	 * Soglia della TRISTEZZA
	 */
	public static final byte SOGLIA_TRISTEZZA = 30;

	/**
	 * Soglia della Felicita'
	 */
	public static final byte SOGLIA_FELICITA = 80;

	/**
	 * E' un valore consigliato per quando si istanzia un Tamabase. Esso e' uguale
	 * a{@code(SOGLIA_FELICITA+SOGLIA_TRISTEZZA)/2}
	 */
	public static final byte VAL_INIZ_RECOMMEND = (SOGLIA_FELICITA + SOGLIA_TRISTEZZA) / 2;
	/**
	 * faccina felice(≡^∇^≡)
	 */
	public static final String HAPPY = "(≡^∇^≡)";
	/**
	 * faccina triste(T^T)
	 */
	public static final String SAD = "(T^T)";
	/**
	 * faccina normale
	 */
	public static final String NORMAL = "(^ω^)";

	// TUTTI GLI ERRORI
	private static final String ERR_STRINGA_VUOTA = "ATTENZIONE IL PARAMETRO NON PUO' ESSERE UNA STRINGA VUOTA";
	private static final String ERR_NUM_INSERT_TOO_HIGHT = "ATTENZIONE, IL NUMERO INSERITO e' TROPPO ALTO, IL MASSIMO e' ";
	private static final String ERR_NUM_INSERT_TOO_LOW = "ATTENZIONE, IL NUMERO INSERITO e' TROPPO BASSO, MINIMO ";
	private static final String ERR_TAMAGOTCHI_AFFETTO_MAX = "ATTENZIONE, IL TAMAGOTCHI ti adora al massimo <3. NON Puoi dare piu' CAREZZE";
	private static final String ERR_TAMAGOTCHI_SAZIO_AL_MAX = "ATTENZIONE, IL TAMAGOTCHI e' Sazio al massimo! NON Puoi dare piu' BISCOTTI";

	private static final byte ERR_TOO_LOW = -1;
	private static final byte ERR_TOO_HIGH = +1;
	private static final byte OK = 0;
	// tutti gli AVVERTIMENTI che si possono avere
	private static final String WARNING_AFFETTO_LOW = "ATTENZIONE!! Il valore d'affetto e' al minimo!!";
	private static final String WARNING_AFFETTO_HIGH = "ATTENZIONE!! Il valore d'affetto' e' al massimo!!";
	private static final String WARNING_SAZIETA_HIGH = "ATTENZIONE!! Il valore di sazieta' e' al massimo!!";
	private static final String WARNING_SAZIETA_LOW = "ATTENZIONE!! Il valore d'affetto e' al minimo!!";

	/**
	 * Costruttore a cui si passano tutti gli attributi
	 */
	public Tamabase(String nome, int affetto, int sazieta) {

		setNome(nome);
		setAffetto(affetto);
		setSazieta(sazieta);
	}

	/**
	 * Costruttore vuoto
	 */
	public Tamabase() {
		nome = null;
		sazieta = affetto = VAL_INIZ_RECOMMEND;
	}

	// metodi attributi nome
	public String getNome() {
		return nome;
	}

	/**
	 * viene assegnato all'attributo nome la stringa passata in ingresso
	 * 
	 * @throws IllegalArgumentException
	 *             se la stringa passata è vuota o nulla
	 * @param nome
	 */
	public void setNome(String nome) {
		if (nome.isEmpty() || nome.equalsIgnoreCase(null))
			throw new IllegalArgumentException(ERR_STRINGA_VUOTA);

		this.nome = nome;
	}

	// metodi attributi affetto
	public int getAffetto() {
		return (int) affetto;
	}

	/**
	 * Imposta il numero dato in ingresso al numero dell'attributo affetto.
	 * 
	 * @param affetto
	 * @see Tamabase#checkErrInBuild
	 */
	public void setAffetto(int affetto) {

		checkErrInBuild(affetto, MAX_VALORI_INTERNI, MIN_VALORI_INTERNI);
		this.affetto = (byte) affetto;

	}

	// metodi attributi sazieta
	public int getSazieta() {
		return (int) sazieta;
	}

	/**
	 * imposta il numero dato in ingresso al numero dell'attributo sazieta
	 * 
	 * @see Tamabase#checkErrInBuild
	 * 
	 * @param sazieta
	 */
	public void setSazieta(int sazieta) {
		checkErrInBuild(sazieta, MAX_VALORI_INTERNI, MIN_VALORI_INTERNI);
		this.sazieta = (byte) sazieta;

	}

	public String getSazietaFormattata() {
		return "(" + getSazieta() + "/" + MAX_VALORI_INTERNI + ") \n";
	}

	public String getAffettoFormattato() {
		return "(" + getAffetto() + "/" + MAX_VALORI_INTERNI + ") \n";
	}

	/**
	 * controlla se numeroInput è all'interno di un range
	 * 
	 * @see Tamabase#checkErrInput
	 * 
	 * @throws IllegalArgumentException
	 *             se il numero passato è maggiore del massimo
	 * @throws IllegalArgumentException
	 *             se il numero passato è minore del minimo
	 * 
	 */
	private void checkErrInBuild(int numeroInput, int massimo, int minimo) {
		switch (checkErrInput(numeroInput, massimo, minimo)) {
		case ERR_TOO_HIGH:
			throw new IllegalArgumentException(ERR_NUM_INSERT_TOO_HIGHT + massimo);
		case ERR_TOO_LOW:
			throw new IllegalArgumentException(ERR_NUM_INSERT_TOO_LOW + minimo);
		default:
			break;
		}
	}

	/**
	 * controlla se numeroInput è all'interno del range
	 * {@code (numeroInput<massimo && numeroInput>minimo)}
	 * 
	 * @return <b>+1 </b>se il numero passato è maggiore del massimo, <b>-1 </b>se
	 *         il numero passato è minore del minimo, <b>0 </b>se il numero è
	 *         all'interno del range
	 */
	private int checkErrInput(int numeroInput, int massimo, int minimo) {
		// primo check, se il numero passato e' maggiore di massimo, viene ritornato +1
		if (numeroInput > massimo)
			return ERR_TOO_HIGH;

		// secondo check se il numero passato e' sotto minimo, viene ritornato -1
		if (numeroInput < minimo)
			return ERR_TOO_LOW;

		return OK;
	}

	/**
	 * dando in input X biscotti essi<b> aumenteranno di X l'attributo sazieta</b> e
	 * <b>diminuiranno di 5 l affetto</b>. In più questo metodo <b>controlla tutte
	 * le possibili combinazioni possibili</b> per non settare a un valore,
	 * stabilito da noi, troppo alto o basso gli attributi interni
	 * 
	 * @param int
	 *            numeroBiscotti
	 * @return String con i parametri aggiornati e tutti i messaggi d'errore del
	 *         caso
	 * 
	 */
	public String daiBiscotti(int numeroBiscotti) {
		StringBuffer error = new StringBuffer();

		/**
		 * @see Tamabase#checkErrInput
		 */
		switch (checkErrInput(numeroBiscotti, MAX_INPUT_STIMOLI, MIN_VALORI_INTERNI)) {
		case ERR_TOO_HIGH:
			return ERR_NUM_INSERT_TOO_HIGHT + MAX_INPUT_STIMOLI;
		case ERR_TOO_LOW:
			return ERR_NUM_INSERT_TOO_LOW + MIN_VALORI_INTERNI;
		default:
			break;
		}

		// terzo check se la sazieta'  e' gia'  al massimo, non si puo' piu' dare
		// biscotti
		if (getSazieta() >= MAX_VALORI_INTERNI)

			return ERR_TAMAGOTCHI_SAZIO_AL_MAX;

		/**
		 * questi due try catch servono se viene lanciata un eccezione da checkErrBuild
		 * per capire meglio leggere il suo specifico javaDoc
		 */
		try {
			// lanciata eccezione se si prova ad impostare l'affetto a meno di
			// MIN_VALORI_INTERNI
			setAffetto(getAffetto() - DIMINUZIONE);

		} catch (IllegalArgumentException e) {

			setAffetto(MIN_VALORI_INTERNI);
			;
		}
		try {
			setSazieta(getSazieta() + numeroBiscotti);
		} catch (IllegalArgumentException e) {
			setSazieta(MAX_VALORI_INTERNI);
		}
		if (getAffetto() == MIN_VALORI_INTERNI)
			error.append(WARNING_AFFETTO_LOW);

		if (getSazieta() == MAX_VALORI_INTERNI) {
			if (error.length() > 0)
				error.append('\t');
			error.append(WARNING_SAZIETA_HIGH);
		}
		return "\nIl valore di Sazieta' e' " + getSazietaFormattata() + "Il valore di Affetto e' "
				+ getAffettoFormattato() + error.toString();
	}

	/**
	 * dando in input X carezze essi<b> aumenteranno di X l'attributo affetto</b> e
	 * <b>diminuiranno di 5 la sazita'</b>. In più questo metodo <b>controlla tutte
	 * le possibili combinazioni possibili</b>, per non settare a un valore,
	 * stabilito da noi, troppo alto o basso gli attributi interni
	 * 
	 * @param int
	 *            numeroCarezze
	 * @return String con i parametri aggiornati e tutti i messaggi d'errore del
	 *         caso
	 * 
	 */
	public String daiCarezze(int numeroCarezze) {
		StringBuffer error = new StringBuffer();

		/**
		 * leggere checkErrInput
		 */
		switch (checkErrInput(numeroCarezze, MAX_INPUT_STIMOLI, MIN_VALORI_INTERNI)) {
		case ERR_TOO_HIGH:
			return ERR_NUM_INSERT_TOO_HIGHT + MAX_INPUT_STIMOLI;
		case ERR_TOO_LOW:
			return ERR_NUM_INSERT_TOO_LOW + MIN_VALORI_INTERNI;
		default:
			break;
		}

		// terzo check se l'affetto e' gia'  al massimo, non si puo' piu' dare carezze
		if (getAffetto() >= MAX_VALORI_INTERNI)

			return ERR_TAMAGOTCHI_AFFETTO_MAX;
		/**
		 * questi due try catch servono se viene lanciata un eccezione da
		 * <h1>checkErrBuild</h1> per capire meglio leggere il suo specifico javaDoc
		 */
		try {
			// lanciata eccezione se si prova ad impostare la sazieta' a meno di
			// MIN_VALORI_INTERNI
			setSazieta(getSazieta() - DIMINUZIONE);
		} catch (IllegalArgumentException e) {
			setSazieta(MIN_VALORI_INTERNI);
		}
		try {
			setAffetto((getAffetto() + numeroCarezze));
		} catch (IllegalArgumentException e) {

			setAffetto(MAX_VALORI_INTERNI);
		}
		if (getSazieta() == MIN_VALORI_INTERNI)
			error.append(WARNING_SAZIETA_LOW);

		if (getAffetto() == MAX_VALORI_INTERNI) {
			if (error.length() > 0)
				error.append('\t');
			error.append(WARNING_AFFETTO_HIGH);
		}
		return "\nIl valore di Sazieta' e' " + getSazietaFormattata() + "Il valore di Affetto e' "
				+ getAffettoFormattato() + error.toString();
	}

	/**
	 * metodo che dice se il tamabase e' triste
	 */
	public boolean isTriste() {
		if (getAffetto() < SOGLIA_TRISTEZZA || getSazieta() < SOGLIA_TRISTEZZA)
			return true;
		return false;
	}

	/**
	 * metodo che dice se il tamabase e' felice
	 */
	public boolean isFelice() {
		if (getAffetto() > SOGLIA_FELICITA && getSazieta() > SOGLIA_FELICITA)
			return true;
		return false;
	}

	/**
	 * metodo che in base a com'e' l'umore del tamabase restituisce un tipo di
	 * stringa
	 */
	public String feliceTriste() {

		if (isFelice())
			return getNome() + " e' felice " + HAPPY;

		if (isTriste())
			return getNome() + " e' triste " + SAD;

		return getNome() + " sta bene " + NORMAL;
	}

	public String getStatistiche() {
		return getSazietaFormattata() + getAffettoFormattato();

	}
}
