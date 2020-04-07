package Tamabase.TamaBase.src.it.unibs.ing.fp.tamabase;



public class TamabaseMain {

	public static void main(String[] args) {
		
		salutoIniz();
		int sceltaUtente;
		
		Tamagotchi tama = TamabaseUtils.creaTamagotchi();
		
		
		do
		{
			menu();
			sceltaUtente = TamabaseUtils.sceltaMenu();
			
			switch (sceltaUtente)
			{
				case 1: {
					TamabaseUtils.faiCarezze(tama);
					break;
				}
				case 2: {
					TamabaseUtils.daiBiscotti(tama);
					break;
				}
				case 3: {
					System.out.println(tama.toString());
					break;
				}
			}
			
		}while(sceltaUtente != 0);

		salutoFin();
		
	}
	
	public static void salutoIniz()
	{
		final String SALUTO = "Ciao, benvenuto nel gioco\nCreazione del tuo pet...\n";
		System.out.println(SALUTO);
	}
	
	public static void salutoFin()
	{
		final String SALUTO = "Arrivederci...";
		System.out.println(SALUTO);
	}
	
	public static void menu()
	{
		final String MENU = "-------------\n"
							+ "1- dai carezze\n2- dai biscotti\n3- visualizza lo stato\n0-esci\n"
							+ "-------------";
			
		System.out.println(MENU);
	}

}
