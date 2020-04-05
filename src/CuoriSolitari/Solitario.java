package CuoriSolitari;

class Solitario {

	public String pseudonimo;
	public byte eta;
	public Sesso sesso;
	public SegnoZodiacale segnoSolitario;
	public SegnoZodiacale segnoPartner;
	// COSTANTI UTILI
	public final static byte SOGLIA_DIFF_MIN_ETA = 6;
	public final static String CUORE1 = "CUORE SOLITARIO";
	public final static String CUORE2 = "CUORI SOLITARI";
	/**
	 * E' una stringa autoFormattata, recante il nome del progetto, che metto in tutti i miei lavori
	* @author Simone Giacomini s.giacomini008@studenti.unibs.it
	* 
	 */
  public final static String BIG_CUORE= "  ¶¶¶¶  ¶¶  ¶¶    ¶¶¶   ¶¶¶¶¶¶   ¶¶¶¶            ¶¶¶¶     ¶¶¶   ¶¶¶¶     ¶¶¶¶   ¶¶¶¶¶¶    ¶¶    ¶¶¶¶¶¶   ¶¶¶¶\r\n" + 
  		" ¶¶  ¶¶ ¶¶  ¶¶   ¶¶ ¶¶   ¶¶  ¶¶   ¶¶            ¶¶  ¶¶   ¶¶ ¶¶   ¶¶       ¶¶    ¶ ¶¶ ¶   ¶¶¶¶    ¶¶  ¶¶   ¶¶\r\n" + 
  		"¶¶      ¶¶  ¶¶  ¶¶   ¶¶  ¶¶  ¶¶   ¶¶            ¶¶¶     ¶¶   ¶¶  ¶¶       ¶¶      ¶¶    ¶¶  ¶¶   ¶¶  ¶¶   ¶¶\r\n" + 
  		"¶¶      ¶¶  ¶¶  ¶¶   ¶¶  ¶¶¶¶¶    ¶¶             ¶¶¶    ¶¶   ¶¶  ¶¶       ¶¶      ¶¶    ¶¶  ¶¶   ¶¶¶¶¶    ¶¶\r\n" + 
  		"¶¶      ¶¶  ¶¶  ¶¶   ¶¶  ¶¶ ¶¶    ¶¶               ¶¶¶  ¶¶   ¶¶  ¶¶   ¶   ¶¶      ¶¶    ¶¶¶¶¶¶   ¶¶ ¶¶    ¶¶\r\n" + 
  		" ¶¶  ¶¶ ¶¶  ¶¶   ¶¶ ¶¶   ¶¶  ¶¶   ¶¶            ¶¶  ¶¶   ¶¶ ¶¶   ¶¶  ¶¶   ¶¶      ¶¶    ¶¶  ¶¶   ¶¶  ¶¶   ¶¶\r\n" + 
  		"  ¶¶¶¶  ¶¶¶¶¶¶    ¶¶¶   ¶¶¶  ¶¶  ¶¶¶¶            ¶¶¶¶     ¶¶¶   ¶¶¶¶¶¶¶  ¶¶¶¶    ¶¶¶¶   ¶¶  ¶¶  ¶¶¶  ¶¶  ¶¶¶¶ by Simone Giacomini";
	public final static byte MAGGIORENNE = 18;
	public final static byte ETA_MASSIMA = 120;
	static final byte PERCENTUALE_AFFINITA[] = { 100, 50, 25, 5 };

	// COSTRUTTORI

	public Solitario() {
		setEta((byte) 18);
		setPseudonimo(null);
		setSesso(null);
		setSegnoSolitario(null);
		setSegnoPartner(null);
	}

	

	public Solitario(String _pseudonimo, int _eta, Sesso _sesso, SegnoZodiacale _segnoSolitario,
			SegnoZodiacale _segnoPartner) {
		setEta((byte) _eta);
		setPseudonimo(_pseudonimo);
		setSesso(_sesso);
		setSegnoSolitario(_segnoSolitario);
		setSegnoPartner(_segnoPartner);
	}



	// METODI PER L'ATTRIBUTO pseudonimo
	public String getPseudonimo() {
		return pseudonimo;
	}

	public void setPseudonimo(String pseudonimo) {
		this.pseudonimo = pseudonimo;
	}

	// METODI PER L'ATTRIBUTO eta
	public short getEta() {
		return (short) eta;
	}

	public void setEta(byte _eta) {

		this.eta = _eta;
	}

	// METODI PER L'ATTRIBUTO sesso
	public Sesso getSesso() {
		return sesso;
	}

	public void setSesso(Sesso sesso) {

		this.sesso = sesso;
	}

	// METODI PER L'ATTRIBUTO SegnoSolitario
	public SegnoZodiacale getSegnoSolitario() {
		return segnoSolitario;
	}

	public void setSegnoSolitario(SegnoZodiacale segnoS) {
		this.segnoSolitario = segnoS;
	}

	// METODI PER L'ATTRIBUTO segnoPartner
	public SegnoZodiacale getSegnoPartner() {
		return segnoPartner;
	}

	public void setSegnoPartner(SegnoZodiacale segnoPartner) {
		this.segnoPartner = segnoPartner;
	}

	// TO_STRING
	public String toString() {

		return getPseudonimo() + "; " + getEta() + "; " + getSesso() + "; " + getSegnoSolitario() + "; "
				+ getSegnoPartner() + ';';

	}

	public String belToString() {

		String risultato = (getSesso().equals(Sesso.FEMMINA)) ?

				"La signora " : "Il signor ";
		risultato += getPseudonimo() + ", del segno " + getSegnoSolitario() + ", che ha " + getEta()
				+ " anni, a cui interessano ";

		if (getSesso().equals(Sesso.FEMMINA))
			risultato += "gli uomini";
		else
			risultato += "le donne";
		risultato += " di segno " + getSegnoPartner();

		return risultato;

	}

	// METODi PER IL CALCONO DELL'AFFINITA'
	public boolean affinita0_0(Solitario s) {

		if (getSesso() != s.getSesso()) {
			if ((Math.abs(getEta() - s.getEta())) <= Solitario.SOGLIA_DIFF_MIN_ETA)
				return true;
			return false;
		}
		return false;
	}

	public byte affinita0_2(Solitario s) {

		if (affinita0_0(s))// check iniziale, controlla se almeno i sessi sono diversi e la soglia minima
							// d'età è rispettata
		{
			if (getSegnoPartner().equals(s.getSegnoSolitario()))// primo check, controlla se per il nostro solitario
																// esiste un secondo solitario col segno ricercato
			{
				if (s.getSegnoPartner().equals(getSegnoSolitario())) // continuo del primo check ora si controlla se
																		// anche il secondo solitario ricerca il segno
																		// del nostro solitario
					return PERCENTUALE_AFFINITA[0];// in caso sia così hanno il 100% di piacersi

				return PERCENTUALE_AFFINITA[1];// altrementi hanno il 50% di piacersi

			}

			return PERCENTUALE_AFFINITA[2];// sono comunque di sesso diverso e vicini d'età, chissà, non si sa' mai
		}
		return PERCENTUALE_AFFINITA[3];// forse si piacciono in amicizia, chi lo sa'
	}

	// METODO PER L'ACCESSO AI MAGGIORENNI E CONTROLLI SULL'ETA'

	public boolean etaMaggiorenne() {
		if (getEta() >= MAGGIORENNE && getEta() < ETA_MASSIMA)
			return true;
		return false;
	}

	/*private boolean etaInventata(byte anni) {
		if (anni <= ETA_MINIMA || anni > ETA_MASSIMA)
			return true;
		return false;

	}*/
		
	

	public void belAffinita0_2(Solitario s) {
		
		switch (affinita0_2(s)) {
		case 100:
			System.out.println("Tra "+getPseudonimo()+" e "+s.getPseudonimo()+" c'e' un affinita' del "+affinita0_2(s)+"%, potrebbe facilmente scattare l'amore❤");
			break;
			
		case 50:
			System.out.println("Tra "+getPseudonimo()+" e "+s.getPseudonimo()+" c'e' un affinita del "+affinita0_2(s)+"%, se giochi bene le tue carte, potresti farcela ;) ");
			break;
			
		case 25:
			System.out.println("Tra "+getPseudonimo()+" e "+s.getPseudonimo()+" c'e' un affinita del "+affinita0_2(s)+"%, forse non siete fatti l'uno con l'altro, ma tentar non nuoce...");
			break;
		
		case 5:
			System.out.println("Tra "+getPseudonimo()+" e "+s.getPseudonimo()+" c'e' un affinita del "+affinita0_2(s)+"%, quindi forse, piu' che l'amore trovi un amico =)");
			break;
		}
	}
	
}
