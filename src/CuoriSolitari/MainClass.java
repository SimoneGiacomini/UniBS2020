package CuoriSolitari;


class MainClass {

		
	public final static String SALUTO_INIZIALE="Salve, questo è un programma per far trovare l'amore a DUE " + Solitario.CUORE2 + " ";
	public final static String ERR_ON_FINAL_AGE="LEI E' TROPPO GIOVANE o HA INSERITO UN'ETA' TROPPO ALTA";
	//public final static String ERR_ON_NEW_SOLITARIO = "Qualcosa e' andato storto...RIPROVA";
	public final static String OK_NEW_SOLITARIO="Tutto e' proceduto per il meglio e quindi... diamo il benvenuto a ";
	
	public static void distanziamento(int n_di_righe_vuote) {
		for (int i = 0; i < n_di_righe_vuote; i++) {
			System.out.println("\n");
		}
	}
	
	public static void main(String[] args) {

		Solitario s1 = new Solitario(), s2 = new Solitario();
		
		System.out.println(Solitario.BIG_CUORE+'\n');
		System.out.println(SALUTO_INIZIALE);
	
		System.out.println("Lei è il primo a provarlo,\n Prego inserisca i suoi dati: ");
		
				UtilCuoreSolitario.acquisisciSolitario(s1);
		
			System.out.println(OK_NEW_SOLITARIO);
			System.out.println(s1.belToString());
		
			distanziamento( 5);
			
			System.out.println(SALUTO_INIZIALE);
			System.out.println("Mi parli un po' di lei...");
		
			UtilCuoreSolitario.acquisisciSolitario(s2);
				
					System.out.println(OK_NEW_SOLITARIO);
					System.out.println(s2.belToString());
			
			
			distanziamento( 5);
			
			s1.belAffinita0_2(s2);
			
			}
			

	}


