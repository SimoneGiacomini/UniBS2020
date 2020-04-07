package Tamabase.TamaBase.src.it.unibs.ing.fp.tamabase;

import it.unibs.fp.mylib.InputDati;

public class TamabaseUtils {
	
	private final static int MASSIMO_INSERIMENTO = 20;
	private final static int MINIMO_INSERIMENTO = 1;
	
	private final static int MIN_MENU = 0;
	private final static int MAX_MENU = 3;
	
	private final static String ERRORE_INS = "valore non valido, riprovare";
	
	
	public static Tamagotchi creaTamagotchi()
	{
		Tamagotchi tama = new Tamagotchi();
		inserisciNome(tama);
		inserisciSoddisfazione(tama);
		inserisciSazieta(tama);
		
		
		return tama;
	}
	
	private static void inserisciNome(Tamagotchi tama)
	{
		String nome = InputDati.leggiStringa("inserisci il nome del tuo pet: ");
		tama.setNome(nome);
	}
	
	private static void inserisciSoddisfazione(Tamagotchi tama)
	{
		int soddisfazione;
		do 
		{
			soddisfazione = InputDati.leggiIntero("inserisci soddisfazione inizale: ");
			
			if(soddisfazione < Tamagotchi.VALORE_MINIMO || soddisfazione > Tamagotchi.VALORE_MASSIMO)
				System.out.println(ERRORE_INS);
			
		}
		while(soddisfazione < Tamagotchi.VALORE_MINIMO || soddisfazione > Tamagotchi.VALORE_MASSIMO);
		
		tama.setSoddisfazione(soddisfazione);
	}
	
	private static void inserisciSazieta(Tamagotchi tama)
	{
		int sazieta;
		do 
		{
			sazieta = InputDati.leggiIntero("inserisci sazietà iniziale: ");
			
			if(sazieta < Tamagotchi.VALORE_MINIMO || sazieta > Tamagotchi.VALORE_MASSIMO)
				System.out.println(ERRORE_INS);
			
		}
		while(sazieta < Tamagotchi.VALORE_MINIMO || sazieta > Tamagotchi.VALORE_MASSIMO);
		
		tama.setSazieta(sazieta);
	}
	
	public static int sceltaMenu()
	{
		int opzioneScelta;
		do
		{
			opzioneScelta = InputDati.leggiIntero("scegli una voce del menu: ");
			if(opzioneScelta <  MIN_MENU || opzioneScelta > MAX_MENU)
				System.out.println(ERRORE_INS);
			
			
		}while(opzioneScelta <  MIN_MENU || opzioneScelta > MAX_MENU);
		
		
		return opzioneScelta;
	}
	
	public static void faiCarezze(Tamagotchi tama)
	{
		int numeroCarezze;
		
		do
		{
			numeroCarezze = InputDati.leggiIntero("quante carezze vuoi dare al tuo pet: ");
			
			if(numeroCarezze < MINIMO_INSERIMENTO || numeroCarezze > MASSIMO_INSERIMENTO)
				System.out.println(ERRORE_INS);
			
		}while(numeroCarezze < MINIMO_INSERIMENTO || numeroCarezze > MASSIMO_INSERIMENTO);
		
		tama.faiCarezza(numeroCarezze);
	}
	
	public static void daiBiscotti(Tamagotchi tama)
	{
		int numeroBiscotti;
		
		do
		{
			numeroBiscotti = InputDati.leggiIntero("quanti biscotti vuoi dare al tuo pet: ");
			
			if(numeroBiscotti < MINIMO_INSERIMENTO || numeroBiscotti > MASSIMO_INSERIMENTO)
				System.out.println(ERRORE_INS);
			
		}while(numeroBiscotti < MINIMO_INSERIMENTO || numeroBiscotti > MASSIMO_INSERIMENTO);
		
		tama.daiBiscotto(numeroBiscotti);
	}

}
