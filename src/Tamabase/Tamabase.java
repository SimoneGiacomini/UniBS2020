package Tamabase;

import java.util.InputMismatchException;

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
	public static final String BIG_TAMABASE = "######    ##    ##   ##   ##    ######    ##     ####   #######\r\n"
			+ "# ## #   ####   ### ###  ####    ##  ##  ####   ##  ##   ##   #\r\n"
			+ "  ##    ##  ##  ####### ##  ##   ##  ## ##  ##  ###      ## #\r\n"
			+ "  ##    ##  ##  ####### ##  ##   #####  ##  ##   ###     ####\r\n"
			+ "  ##    ######  ## # ## ######   ##  ## ######     ###   ## #\r\n"
			+ "  ##    ##  ##  ##   ## ##  ##   ##  ## ##  ##  ##  ##   ##   #\r\n"
			+ " ####   ##  ##  ##   ## ##  ##  ######  ##  ##   ####   ####### by Simone Giacomini \n";
	/**
	 * Massimo numero di biscotti e di carezze
	 */
	public static final byte MAX_INPUT_STIMOLI = 20;
	/**
	 * Unit√† di affetto/sazieta' che si sottraggono quando si danno o
	 * carezze/biscotti
	 */
	public static final byte DIMINUZIONE = 5;
	/**
	 * Massimo numero possibile di affetto/sazieta'
	 */
	public static final byte MAX_VALORI_INTERNI = 100;

	/**
	 * Minor numero possibile di affetto/sazieta'†
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

	// TUTTI GLI ERRORI
	private static final String ERR_STRINGA_VUOTA = "ATTENZIONE IL PARAMETRO NON PUO' ESSERE UNA STRINGA VUOTA";
	private static final String ERR_NUM_INSERT_TOO_HIGHT = "ATTENZIONE, IL NUMERO INSERITO e' TROPPO ALTO, IL MASSIMO e' ";
	private static final String ERR_NUM_INSERT_TOO_LOW = "ATTENZIONE, IL NUMERO INSERITO e' TROPPO BASSO, MINIMO ";
	private static final String ERR_TAMAGOTCHI_AFFETTO_MAX = "ATTENZIONE, IL TAMAGOTCHI ti adora al massimo <3\n NON Puoi dare piu' CAREZZE";
	private static final String ERR_TAMAGOTCHI_SAZIO_AL_MAX = "ATTENZIONE, IL TAMAGOTCHI e' Sazio al massimo! NON Puoi dare piu' BISCOTTI";
	// private static final byte
	private static final byte ERR_TOO_LOW = -1;
	private static final byte ERR_TOO_HIGH = +1;
	private static final byte OK = 0;

	private static final String WARNING_AFFETTO_LOW = "ATTENZIONE!! Il valore d'affetto e' al minimo!!";

	
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
		sazieta = affetto = MIN_VALORI_INTERNI;
	}

	// metodi attributi nome
	public String getNome() {
		return nome;
	}

	/**
	 * viene assegnato all'attributo nome la stringa passata in ingresso
	 * 
	 * @throws IllegalArgumentException
	 *             se la stringa passata Ë vuota o nulla
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
	 * @param sazieta
	 */
	public void setSazieta(int sazieta) {
		checkErrInBuild(sazieta, MAX_VALORI_INTERNI, MIN_VALORI_INTERNI);
		this.sazieta = (byte) sazieta;

	}

	/**
	 * controlla se numeroInput Ë all'interno di un range
	 * 
	 * @throws IllegalArgumentException
	 *             se il numero passato Ë maggiore del massimo
	 * @throws IllegalArgumentException
	 *             se il numero passato Ë minore del minimo
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
	 * controlla se numeroInput Ë all'interno di un range
	 * 
	 * @return +1 se il numero passato Ë maggiore del massimo, -1 se il numero
	 *         passato Ë minore del minimo, 0 se il numero Ë all'interno del range
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
	 * dando in input X biscotti essi aumenteranno di X l'attributo sazieta e
	 * faranno scendere di 5 l affetto. In pi˘ questo metodo controlla tutte le
	 * possibili combinazioni possibili, per non settare a un valore, stabilito da
	 * noi, troppo alto o basso gli attributi interni
	 * 
	 * @param int numeroBiscotti
	 * @return String output
	 */
	public String daiBiscotti(int numeroBiscotti) {
			StringBuffer output = new StringBuffer();
		// check input
		switch (checkErrInput(numeroBiscotti, MAX_INPUT_STIMOLI, MIN_VALORI_INTERNI)) {
		case ERR_TOO_HIGH:
			return ERR_NUM_INSERT_TOO_HIGHT + MAX_INPUT_STIMOLI;
		case ERR_TOO_LOW:
			return ERR_NUM_INSERT_TOO_LOW + MIN_VALORI_INTERNI;
		default:
			break;
		}

		// terzo check se la saziet√† √® gi√† al massimo, non si pu√≤ pi√π dare biscotti
		if (getSazieta() >= MAX_VALORI_INTERNI)

			return ERR_TAMAGOTCHI_SAZIO_AL_MAX;

		// quarto check, se la somma tra la saziet√† precedente e i biscotti passati
		// sar√†
		// maggiore di MAX_VALORI_INTERNI, si setta la saziet√† al suo valore massimo
		try {
			setAffetto(getAffetto()-DIMINUZIONE);
			
		}catch( IllegalArgumentException e) {
			setAffetto(MIN_VALORI_INTERNI);
			output.append( WARNING_AFFETTO_LOW + MIN_VALORI_INTERNI+")");
		}
	try {
			setSazieta(numeroBiscotti);
	}catch(IllegalArgumentException e) {
		setSazieta(MAX_VALORI_INTERNI);
		output.append("ATTENZIONE!! I valori ");//<--qui finire
	}
		return "";
	}

	/**
	 * dando in input X carezze esse aumenteranno di X l'attributo affetto e faranno scendere di 5 la sazieta. In pi˘
	 * questo metodo controlla tutte le possibili combinazioni possibili, per non
	 * settare in un valore, stabilito da noi, troppo alto o basso gli attributi interni
	 * 
	 * @param numeroCarezze
	 */
	public void daiCarezze(int numeroCarezze) {

		//check su input
				checkErrInput(numeroCarezze);
				
		// check se l' Affetto √® gi√† al massimo, non si pu√≤ pi√π dare CAREZZE
		if (getAffetto() >= MAX_VALORI_INTERNI)
			
				return ERR_TAMAGOTCHI_AFFETTO_MAX);

		// quarto check, se la somma tra l Affetto precedente e le CAREZZE passate sar√†
		// maggiore di MAX_VALORI_INTERNI, si setta l Affetto al suo valore massimo
		if (getAffetto() + numeroCarezze >= MAX_VALORI_INTERNI && getSazieta() - DIMINUZIONE >= MIN_VALORI_INTERNI) {
			setSazieta((byte) (getSazieta() - DIMINUZIONE));
			setAffetto(MAX_VALORI_INTERNI);
			System.out.println("l'attributo Affetto Ë stato impostato a " + MAX_VALORI_INTERNI
					+ " in quanto e' il valore massimo dei valori interni");
		} 
		else if (getAffetto() + numeroCarezze >= MAX_VALORI_INTERNI
				&& getSazieta() - DIMINUZIONE < MIN_VALORI_INTERNI) {
			setSazieta((byte) (MIN_VALORI_INTERNI));
			setAffetto(MAX_VALORI_INTERNI);
			System.out.println("l'attributo Affetto Ë stato impostato a " + MAX_VALORI_INTERNI
					+ " in quanto e' il valore massimo dei valori interni;\nMentre l'attributo sazieta' e' stato impostato a "
					+ MIN_VALORI_INTERNI + "in qunato valore minimo dwgli attributi interni");
		}

		// altrementi, si esegue il calcolo dettato
		else {
			System.out.println("WEWE");
			setSazieta((byte) (getSazieta() - DIMINUZIONE));
			setAffetto((byte) (getAffetto() + numeroCarezze));
		}

	}

	public boolean isTriste() {
		if (getAffetto() < SOGLIA_TRISTEZZA || getSazieta() < SOGLIA_TRISTEZZA)
			return true;
		return false;
	}

	public boolean isFelice() {
		if (getAffetto() > SOGLIA_FELICITA && getSazieta() > SOGLIA_FELICITA)
			return true;
		return false;
	}
		
	
	

}
