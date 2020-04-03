package Tamabase;

/**@author Simone Giacomini s.giacomini008@studenti.unibs.it
 * */
public class Tamabase {

	private String nome;
	private byte affetto;

	private byte sazieta;

	/**
	 * E' una stringa autoFormattata, recante il nome del progetto, che metto in tutti i miei lavori
	* @author Simone Giacomini s.giacomini008@studenti.unibs.it
	* 
	 */
	public static final String BIG_TAMABASE="######    ##    ##   ##   ##    ######    ##     ####   #######\r\n" + 
			"# ## #   ####   ### ###  ####    ##  ##  ####   ##  ##   ##   #\r\n" + 
			"  ##    ##  ##  ####### ##  ##   ##  ## ##  ##  ###      ## #\r\n" + 
			"  ##    ##  ##  ####### ##  ##   #####  ##  ##   ###     ####\r\n" + 
			"  ##    ######  ## # ## ######   ##  ## ######     ###   ## #\r\n" + 
			"  ##    ##  ##  ##   ## ##  ##   ##  ## ##  ##  ##  ##   ##   #\r\n" + 
			" ####   ##  ##  ##   ## ##  ##  ######  ##  ##   ####   ####### by Simone Giacomini \n";
	/**
	 * Massimo numero di biscotti e di carezze
	 */
	public static final byte MAX_INPUT_STIMOLI = 20;
	/**
	 * Unità di affetto/sazieta che si sottraggono quando si danno o
	 * carezze/biscotti
	 */
	public static final byte DIMINUZIONE = 5;
	/**
	 * Massimo numero possibile di affetto/sazietà possibile
	 */
	public static final byte MAX_VALORI_INTERNI = 100;

	/**
	 * Soglia della TRISTEZZA
	 */
	public static final byte SOGLIA_TRISTEZZA = 30;

	/**
	 * Soglia della Felicità
	 */
	public static final byte SOGLIA_FELICITA = 80;

	/*
	 * Costruttore a cui si passano tutti gli attributi
	 */
	public Tamabase(String nome, byte affetto, byte sazieta) {
		super();
		this.affetto = affetto;
		this.sazieta = sazieta;
		this.nome = nome;
	}

	/*
	 * Costruttore vuoto
	 */
	public Tamabase() {
		this.affetto = 30;
		this.sazieta = 30;
		this.nome = null;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAffetto() {
		return (int) affetto;
	}

	public void setAffetto(byte affetto) {
		this.affetto = affetto;
	}

	public int getSazieta() {
		return (int) sazieta;
	}

	public void setSazieta(byte sazieta) {
		this.sazieta = sazieta;
	}

	public void daiBiscotti(int numeroBiscotti) {
		// primo check, se il numero passato e' maggiore di 20, si lancia una nuova
		// eccezione
		if (numeroBiscotti > MAX_INPUT_STIMOLI)
			throw new IllegalArgumentException(

					"ATTENZIONE, IL NUMERO INSERITO e' TROPPO ALTO, IL MASSIMO e'" + MAX_INPUT_STIMOLI);
		// secondo check se il numero di biscotti e' negativo
		if (numeroBiscotti <= 0)
			throw new IllegalArgumentException("ATTENZIONE, IL NUMERO INSERITO e' TROPPO BASSO, MINIMO 1");

		// terzo check se la sazietà è già al massimo, non si può più dare biscotti
		if (getSazieta() >= MAX_VALORI_INTERNI)
			throw new IllegalArgumentException(
					"ATTENZIONE, IL TAMAGOTCHI e' Sazio al massimo! NON Puoi dare piu' BISCOTTI");

		// quarto check, se la somma tra la sazietà precedente e i biscotti passati sarà
		// maggiore di MAX_VALORI_INTERNI, si setta la sazietà al suo valore massimo
		if (getSazieta() + numeroBiscotti >= MAX_VALORI_INTERNI) {
			setSazieta(MAX_VALORI_INTERNI);
			setAffetto((byte) (getAffetto() - DIMINUZIONE));
		}

		// altrementi, si esegue il calcolo dettato
		else {
			System.out.println("WEWE");
			setSazieta((byte) (getSazieta() + numeroBiscotti));
			setAffetto((byte) (getAffetto() - DIMINUZIONE));
		}
	}

	public void daiCarezze(int numeroCarezze) {
		// primo check, se il numero passato è maggiore di 20, si lancia una nuova
		// eccezione
		if (numeroCarezze > MAX_INPUT_STIMOLI)
			throw new IllegalArgumentException(

					"ATTENZIONE, IL NUMERO INSERITO e' TROPPO ALTO, IL MASSIMO e' " + MAX_INPUT_STIMOLI);
		// secondo check se il numero di CAREZZE è negativo
		if (numeroCarezze <= 0)
			throw new IllegalArgumentException("ATTENZIONE, IL NUMERO INSERITO e' TROPPO BASSO, MINIMO 1");

		// terzo check se l' Affetto è già al massimo, non si può più dare CAREZZE
		if (getAffetto() >= MAX_VALORI_INTERNI)
			throw new IllegalArgumentException(
					"ATTENZIONE, IL TAMAGOTCHI ti adora al massimo <3\n NON Puoi dare piu' CAREZZE");

		// quarto check, se la somma tra l Affetto precedente e le CAREZZE passate sarà
		// maggiore di MAX_VALORI_INTERNI, si setta l Affetto al suo valore massimo
		if (getAffetto() + numeroCarezze >= MAX_VALORI_INTERNI) {
			setSazieta((byte) (getSazieta() - DIMINUZIONE));
			setAffetto(MAX_VALORI_INTERNI);
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
