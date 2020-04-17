package Tamagotchi;

/**
 * Classe che rappresenta un <a href="https://it.wikipedia.org/wiki/Tamagotchi"> Tamagotchi
 *      </a>
 * 
 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
 */
public class Tamagotchi {

	/**
	 * attributo {@linkplain String} che rappresenta il {@linkplain #nome} del
	 * {@linkplain Tamagotchi}
	 */
	private String nome;
	/**
	 * attributo float che rappresenta l'{@linkplain #affetto} del
	 * {@linkplain Tamagotchi}
	 */
	private float affetto;
	/**
	 * attributo float che rappresenta la {@linkplain #sazieta} del
	 * {@linkplain Tamagotchi}
	 */
	private float sazieta;

	/**
	 * {@linkplain String} autoFormattata, recante il nome del progetto, che
	 * inserisco in tutti i miei lavori
	 * 
	 * @author Simone Giacomini s.giacomini008@studenti.unibs.it
	 * 
	 */
	public static final String BIG_TAMAGOTCHI = "######    ##    ##   ##   ##      ####    ###   ######    ####  ##  ##   ####   \n"
			+ "# ## #   ####   ### ###  ####    ##  ##  ## ##  # ## #   ##  ## ##  ##    ##    \n"
			+ "  ##    ##  ##  ####### ##  ##  ##      ##   ##   ##    ##      ##  ##    ##    \n"
			+ "  ##    ##  ##  ####### ##  ##  ##      ##   ##   ##    ##      ######    ##    \n"
			+ "  ##    ######  ## # ## ######  ##  ### ##   ##   ##    ##      ##  ##    ##    \n"
			+ "  ##    ##  ##  ##   ## ##  ##   ##  ##  ## ##    ##     ##  ## ##  ##    ##    \n"
			+ " ####   ##  ##  ##   ## ##  ##    #####   ###    ####     ####  ##  ##   ####    by Simone Giacomini";
	/** Massimo numero di biscotti e di carezze */
	public static final byte MAX_INPUT_STIMOLI = 20;

	/** Massimo numero possibile di {@linkplain #affetto} o {@linkplain #sazieta} */
	public static final byte MAX_VALORI_INTERNI = 100;

	/** Minor numero possibile di {@linkplain #affetto} o {@linkplain #sazieta}� */
	public static final byte MIN_VALORI_INTERNI = 0;

	/**
	 * E' un valore <b>consigliato </b>per quando si istanzia un {@linkplain Tamagotchi}.
	 */
	public static final byte VAL_INIZ_RECOMMEND = 20;

	/** faccina felice {@value} */
	public static final String HAPPY = "(^w^)";

	/** faccina triste {@value} */
	public static final String SAD = "(T^T)";

	/** faccina normale {@value} */
	public static final String NORMAL = "(^_^)";

	/** faccina morta {@value} */
	public static final String DIE = "(X_X)";//
	/** Soglia della TRISTEZZA */
	private static final byte SOGLIA_TRISTEZZA = 30;

	/** Soglia della Felicita' */
	private static final byte SOGLIA_FELICITA = 80;

	/**
	 * Soglia della {@linkplain #sazieta}, oltre alla quale, il
	 * {@linkplain Tamagotchi} muore perche' troppo sazio
	 */
	private static final byte SOGLIA_SAZIETA = 90;

	/**
	 * fattore utilizzato per <b>DIVIDERE</b> le <b>carezze </b> ricevute nel metodo
	 * {@linkplain #daiCarezze}
	 * 
	 * @see #daiCarezze
	 */
	private static final byte FATTORE_CAREZZE = 2;
	/**
	 * percentuale che aumenta la {@linkplain #sazieta} quando si danno
	 * <b>biscotti</b>
	 * 
	 * @see #daiBiscotti
	 */
	private static final byte PERCENTUALE_AUMENTA_BISCOTTI = 10;

	/**
	 * fattore utilizzato per <b>DIVIDERE</b> i <b>biscotti</b> ricevuti nel metodo
	 * {@linkplain #daiBiscotti}
	 * 
	 * @see #daiBiscotti
	 */
	private static final byte FATTORE_BISCOTTI = 4;

	/** {@linkplain String} di {@linkplain #affetto} */
	public static final String AFFETTO = "affetto";
	/** {@linkplain String} di {@linkplain #sazieta} */
	public static final String SAZIETA = "saziet\u00e0";

	private static final String ERR_STRINGA_VUOTA = "ATTENZIONE IL PARAMETRO NON PU\u00d2 ESSERE UNA STRINGA VUOTA";
	private static final String ERR_TAMAGOTCHI_AFFETTO_MAX = "ATTENZIONE, IL TAMAGOTCHI ti adora al massimo <3. NON Puoi dare pi\u00f9 CAREZZE";
	private static final String ERR_TAMAGOTCHI_SAZIO_AL_MAX = "ATTENZIONE, IL TAMAGOTCHI \u00e8 Sazio al massimo! NON Puoi dare pi\u00f9 BISCOTTI";

	// tutti gli AVVERTIMENTI che si possono avere
	private static final String WARNING_LOW = "ATTENZIONE!! Il valore %s \u00e8 al minimo!!";
	private static final String WARNING_HIGH = "ATTENZIONE!! Il valore %s \u00e8 al massimo!!";

	/**
	 * <b>Costruttore con attributi</b>
	 */
	public Tamagotchi(String nome, float affetto, float sazieta) {

		setNome(nome);
		setAffetto(affetto);
		setSazieta(sazieta);
	}

	/**
	 * <h1>Costruttore vuoto</h1> viene istanziato un oggetto di tipo
	 * {@linkplain Tamagotchi}, con rispettivi valori:
	 * <p>
	 * {@linkplain #nome}=<code>null</code>
	 * </p>
	 * <p>
	 * {@linkplain #affetto}={@linkplain #VAL_INIZ_RECOMMEND}
	 * </p>
	 * <p>
	 * {@linkplain #sazieta}={@linkplain #VAL_INIZ_RECOMMEND}
	 * </p>
	 */
	public Tamagotchi() {
		nome = null;
		sazieta = affetto = VAL_INIZ_RECOMMEND;
	}

	/** Ritorna il valore di {@linkplain #nome} */
	public String getNome() {
		return nome;
	}

	/**
	 * viene assegnato all'attributo {@linkplain #nome} la {@linkplain String}
	 * passata in ingresso
	 * 
	 * @throws IllegalArgumentException
	 *             se la stringa passata e' vuota o nulla
	 * @param nome
	 */
	public void setNome(String nome) {
		if (nome.isEmpty() || nome.equalsIgnoreCase(null))
			throw new IllegalArgumentException(ERR_STRINGA_VUOTA);

		this.nome = nome;
	}

	/** Ritorna il valore di {@linkplain #affetto} */
	public float getAffetto() {
		return affetto;
	}

	/**
	 * Imposta il numero dato in ingresso all'attributo {@linkplain #affetto}.
	 * 
	 * @param affetto
	 * @see UtilTamagotchi#checkErrInBuild
	 */
	public void setAffetto(float affetto) {

		UtilTamagotchi.checkErrInBuild(affetto, MAX_VALORI_INTERNI, MIN_VALORI_INTERNI);
		this.affetto = affetto;

	}

	/** Ritorna il valore di {@linkplain #sazieta} */
	public float getSazieta() {
		return sazieta;
	}

	/**
	 * imposta il numero dato in ingresso all'attributo {@linkplain #sazieta}
	 * 
	 * @see UtilTamagotchi#checkErrInBuild
	 * 
	 * @param sazieta
	 */
	public void setSazieta(float sazieta) {
		UtilTamagotchi.checkErrInBuild(sazieta, MAX_VALORI_INTERNI, MIN_VALORI_INTERNI);
		this.sazieta = sazieta;

	}

	/**
	 * Ritorna una {@linkplain String} tipo
	 * ({@linkplain #sazieta}/{@linkplain #MAX_VALORI_INTERNI})
	 */
	public String getSazietaFormattata() {
		return "(" + getSazieta() + "/" + MAX_VALORI_INTERNI + ") \n";
	}

	/**
	 * Ritorna una {@linkplain String} tipo
	 * ({@linkplain #affetto}/{@linkplain #MAX_VALORI_INTERNI})
	 */
	public String getAffettoFormattato() {
		return "(" + getAffetto() + "/" + MAX_VALORI_INTERNI + ") \n";
	}

	/**
	 * Ritorna una {@linkplain String} con {@linkplain #nome}, {@linkplain #umore()}, ed
	 * {@linkplain #sazieta} e {@linkplain #affetto} formattate
	 * 
	 * @see {@linkplain #getSazietaFormattata()},
	 *      {@linkplain #getAffettoFormattato()}
	 */
	public String toString() {
		return String.format(
				System.lineSeparator() + "%s " + System.lineSeparator() + "%s %s" + System.lineSeparator() + "%s %s",
				umore(), SAZIETA.toUpperCase(), getSazietaFormattata(), AFFETTO.toUpperCase(), getAffettoFormattato());
	}

	/**
	 * dando in input X biscotti essi<b> aumenteranno del
	 * {@linkplain #PERCENTUALE_AUMENTA_BISCOTTI} l'attributo {@linkplain #sazieta}
	 * per OGNI BISCOTTO DATO</b> e <b>diminuira' l'{@linkplain #affetto} con la
	 * formula: {@code affetto=affetto-(numerobiscotti/4)}</b>. In piu' questo
	 * metodo <b>controlla tutte le possibili combinazioni possibili</b> per non
	 * settare a un valore, stabilito da noi, troppo alto
	 * ({@linkplain #MIN_VALORI_INTERNI}) o basso ({@linkplain #MIN_VALORI_INTERNI})
	 * gli attributi
	 * 
	 * @param numeroBiscotti
	 * @return {@linkplain String} con i parametri aggiornati e tutti i messaggi
	 *         d'errore del caso
	 * @see {@linkplain UtilTamagotchi#checkErrInBuild}, {@linkplain Tamagotchi#toString()}
	 */
	public String daiBiscotti(int numeroBiscotti) {
		StringBuffer error = new StringBuffer();
		switch (UtilTamagotchi.inRange(numeroBiscotti, MAX_INPUT_STIMOLI, MIN_VALORI_INTERNI)) {
		case UtilTamagotchi.ERR_TOO_HIGH:
			return UtilTamagotchi.ERR_NUM_INSERT_TOO_HIGHT + MAX_INPUT_STIMOLI;
		case UtilTamagotchi.ERR_TOO_LOW:
			return UtilTamagotchi.ERR_NUM_INSERT_TOO_LOW + MIN_VALORI_INTERNI;
		default:
			break;
		}

		// terzo check se la sazieta'� e' gia'� al massimo, non si puo' piu' dare
		// biscotti
		if (getSazieta() >= MAX_VALORI_INTERNI)

			return ERR_TAMAGOTCHI_SAZIO_AL_MAX;

		try {
			// lanciata eccezione se si prova ad impostare l'affetto a meno di
			// MIN_VALORI_INTERNI
			setAffetto((float) (getAffetto() - (float) (numeroBiscotti / FATTORE_BISCOTTI)));
		} catch (IllegalArgumentException e) {
			setAffetto(MIN_VALORI_INTERNI);
		}
		try {
			for (int i = 0; i < numeroBiscotti; i++) {
				setSazieta(getSazieta() + UtilTamagotchi.percentuale(PERCENTUALE_AUMENTA_BISCOTTI, getSazieta()));
			}
		} catch (IllegalArgumentException e) {
			setSazieta(MAX_VALORI_INTERNI);
		}
		if (getAffetto() == MIN_VALORI_INTERNI)
			error.append(String.format(WARNING_LOW, AFFETTO));

		if (getSazieta() == MAX_VALORI_INTERNI) {
			if (error.length() > 0)
				error.append('\t');
			error.append(String.format(WARNING_HIGH, SAZIETA));
		}
		return error.toString()+ toString() ;
	}


	/**
	 * dando in input X carezze esse<b> aumenteranno di X l'attributo
	 * {@linkplain #affetto}</b> e <b>diminuiranno la {@linkplain #sazieta} tramite
	 * la formula: {@code sazieta=sazieta-(numeroCarezze/2)}</b>. In piu' questo
	 * metodo <b>controlla tutte le possibili combinazioni possibili</b>, per non
	 * settare a un valore, stabilito da noi, troppo alto
	 * ({@linkplain #MIN_VALORI_INTERNI}) o basso ({@linkplain #MIN_VALORI_INTERNI})
	 * gli attributi
	 * 
	 * @param numeroCarezze
	 * @return {@linkplain String} con i parametri aggiornati e tutti i messaggi
	 *         d'errore del caso
	 * @see {@linkplain UtilTamagotchi#checkErrInBuild}, {@linkplain Tamagotchi#toString()}
	 * 
	 */
	public String daiCarezze(int numeroCarezze) {
		StringBuffer error = new StringBuffer();

		switch (UtilTamagotchi.inRange(numeroCarezze, MAX_INPUT_STIMOLI, MIN_VALORI_INTERNI)) {
		case UtilTamagotchi.ERR_TOO_HIGH:
			return UtilTamagotchi.ERR_NUM_INSERT_TOO_HIGHT + MAX_INPUT_STIMOLI;
		case UtilTamagotchi.ERR_TOO_LOW:
			return UtilTamagotchi.ERR_NUM_INSERT_TOO_LOW + MIN_VALORI_INTERNI;
		default:
			break;
		}
		// terzo check se l'affetto e' gia'� al massimo, non si puo' piu' dare carezze
		if (getAffetto() >= MAX_VALORI_INTERNI)
			return ERR_TAMAGOTCHI_AFFETTO_MAX;
		try {
			// lanciata eccezione se si prova ad impostare la sazieta' a meno di
			// MIN_VALORI_INTERNI
			setSazieta((getSazieta() - (float) (numeroCarezze / FATTORE_CAREZZE)));
		} catch (IllegalArgumentException e) {
			setSazieta(MIN_VALORI_INTERNI);
		}
		try {
			setAffetto((float) (getAffetto() + numeroCarezze));
		} catch (IllegalArgumentException e) {

			setAffetto(MAX_VALORI_INTERNI);
		}
		if (getSazieta() == MIN_VALORI_INTERNI)
			error.append(String.format(WARNING_LOW, SAZIETA));

		if (getAffetto() == MAX_VALORI_INTERNI) {
			if (error.length() > 0)
				error.append('\t');
			error.append(String.format(WARNING_HIGH, AFFETTO));
		}
		return error.toString()+ toString();
	}

	/**
	 * metodo che dice se il {@linkplain Tamagotchi} e' triste
	 * 
	 * @return boolean
	 */
	public boolean isTriste() {
		if (getAffetto() < SOGLIA_TRISTEZZA || getSazieta() < SOGLIA_TRISTEZZA || getSazieta() > SOGLIA_SAZIETA)
			return true;
		return false;
	}

	/**
	 * metodo che dice se il {@linkplain Tamagotchi} e' felice
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isFelice() {
		if (getAffetto() > SOGLIA_FELICITA && getSazieta() > SOGLIA_FELICITA)
			return true;
		return false;
	}

	/**
	 * metodo che capisce se il {@linkplain Tamagotchi} e' morto
	 * 
	 * @return {@linkplain boolean}
	 */
	public boolean isMorto() {

		if (UtilTamagotchi.inRange(sazieta, MAX_VALORI_INTERNI - 1, MIN_VALORI_INTERNI + 1) != 0 || affetto == MIN_VALORI_INTERNI)
			return true;
		return false;
	}

	/**
	 * capisce com'e' l'umore del {@linkplain Tamagotchi}, descrivendolo
	 * 
	 * @return {@linkplain String}
	 */
	public String umore() {

		if (isMorto())
			return getNome() + " \u00e8 morto " + DIE;

		if (isFelice())
			return getNome() + " \u00e8 felice " + HAPPY;

		if (isTriste())
			return getNome() + " \u00e8 triste " + SAD;

		return getNome() + " sta bene " + NORMAL;
	}

	/**
	 * restituisce una {@linkplain String} con le statistiche del
	 * {@linkplain Tamagotchi}
	 * 
	 * @see {@link #getAffettoFormattato()} , {@link #getSazietaFormattata()}
	 */
	public String getStatistiche() {
		return getSazietaFormattata() + getAffettoFormattato();

	}

}
