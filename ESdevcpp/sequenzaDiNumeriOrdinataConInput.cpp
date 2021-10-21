#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define DIM 10

int cerca(float v[], int dimensioneVet, float nCercato){	//Questa funzione
	int i;													
		
	for(i=0;i<dimensioneVet;i++)
		if(v[i]==nCercato) return i;					//ritorna la posizione di un numero cercato all'interno di un vettore, se trovato.
		return -1;											//altrimenti ritorna -1(in quanto un vettore ha posizioni maggiori di 0)
}

int inserisci(float v[], int dimensioneVet, float nDaInserire){ //Questa fuzione
	int i, pos= cerca(v, dimensioneVet, nDaInserire); 			//cerca nel vettore se il numero da inserire è già presente.
	if(pos<0)													//In caso non trovi il numero	
	{for(i=dimensioneVet-1;i>=0 && v[i]>nDaInserire;--i)		//sposta partendo dal fondo ogni elemento maggiore di quello che si vuole 
		v[i+1]=v[i];											//inserire una posizione avanti, per fare posto a lui, all'interno del vettore.
 																//Una volta trovato un elemento più piccolo di quello che si vuole inserire
 	v[i+1] =nDaInserire;										//si inserisce in posizione i+1(per via del ciclo for precedente) il numero da inserire
		dimensioneVet++;										//infine si aumenta la dimensione 
																//del vettore di uno(in quanto ora contiene un elemento in più)
		}	
		return dimensioneVet;									//ritorna ora la nuova OPPURE ancora quella vecchia, dimensione del vettore
}

void visualizza(float v[], int dimensioneVet){
	int i;
	printf("\n");
	for(i=0;i<dimensioneVet;++i){
		printf("%.2f\t", v[i]);
	}
	printf("\n");
	printf("\n");

}

float insertNumeroRealeEstremiInclusi(float estremoMinore, float estremoMaggiore){
	float realeInput;
	do{
	printf("\nInserisci un numero reale compreso tra %.2f ed %.2f --> ",estremoMinore,estremoMaggiore);
	scanf("%f",&realeInput);
	fflush(stdin);
		if(realeInput<estremoMinore||realeInput>estremoMaggiore)
			printf("\nNumero inserito non consentito");
	
	}while(realeInput<estremoMinore||realeInput>estremoMaggiore);
	return realeInput;
}
 int possoInserireInVet(float v[], int dimensioneVet, float nDaInserire){
 	
 	int controlDimVet=dimensioneVet;
 	dimensioneVet=inserisci(v,dimensioneVet,nDaInserire);
 	if(controlDimVet!=dimensioneVet)
 	 printf("\nNumero inserito nel vettore");
 	else printf("\nNumero da inserire gia' presente nel vettore!");
 	return dimensioneVet;
 }

int main(void){
	
	int n=0, nuovaDimensioneVet;
	float reali[DIM], realeCasuale, realeInput;
	
	do {
		realeCasuale= rand() % 101 /100.0;//divido per 100.0 in modo che faccia il casting del numero rand rimodulato in float
		n=inserisci(reali, n, realeCasuale);	
	} while(n<DIM);
	
	
	do{
		visualizza(reali,n);
		
		realeInput=insertNumeroRealeEstremiInclusi(0,1);
		
		nuovaDimensioneVet=possoInserireInVet(reali,n,realeInput);
		
	} while(nuovaDimensioneVet<n+1);
	
	visualizza(reali,nuovaDimensioneVet);
	
	return 0;
}
