package Tamabase.TamaBase.src.it.unibs.ing.fp.tamabase;

public class Tamagotchi {

	
	private int soddisfazione;
	private int sazieta;
	private String nome;
	
	public static final int VALORE_MINIMO = 0;
	public static final int VALORE_MASSIMO = 100;
	
	private static final int GRADO_RIDUZIONE = 5;
	private static final int SOGLIA_SODDISFAZIONE = 80;
	private static final int SOGLIA_SAZIETA = 80;
	private static final int MIN_SODDISFAZIONE = 30;
	private static final int MIN_SAZIETA = 30;
	
	private static final String MESS_FELICE = "il tuo pet è felice".toUpperCase();
	private static final String MESS_TRISTE = "il tuo pet non è felice".toUpperCase();
	private static final String MESS_NEUTRO = "il tuo pet è in buone condizioni".toUpperCase();
	
	public Tamagotchi()
	{
		this.nome = "";
		this.soddisfazione = 0;
		this.sazieta = 0;
	}
	
	
	public void faiCarezza(int numeroCarezze)
	{
		if(soddisfazione + numeroCarezze <= VALORE_MASSIMO)
			soddisfazione += numeroCarezze;
		
		if(sazieta - GRADO_RIDUZIONE >= VALORE_MINIMO)
			sazieta -= GRADO_RIDUZIONE;
		
	}
	
	public void daiBiscotto(int numeroBiscotti)
	{
		if(sazieta + numeroBiscotti <= VALORE_MASSIMO)
			sazieta += numeroBiscotti;
		if(soddisfazione - GRADO_RIDUZIONE  >= VALORE_MINIMO)
			soddisfazione -= GRADO_RIDUZIONE;
	}
	
	public boolean isFelice()
	{
		return (soddisfazione > SOGLIA_SODDISFAZIONE && sazieta > SOGLIA_SAZIETA);
			
	}
	
	public boolean isTriste()
	{
		return (soddisfazione < MIN_SODDISFAZIONE || sazieta < MIN_SAZIETA);
	}
	
	
	

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getSoddisfazione() {
		return soddisfazione;
	}

	public void setSoddisfazione(int soddisfazione) {
		this.soddisfazione = soddisfazione;
	}

	public int getSazieta() {
		return sazieta;
	}

	public void setSazieta(int sazieta) {
		this.sazieta = sazieta;
	}

	public String toString()
	{
		if(isFelice())
			return MESS_FELICE;
		else if(isTriste())
			return MESS_TRISTE;
		else
			return MESS_NEUTRO;
		
		
	}
	
	
	
	
	
	
	
	
	
}
