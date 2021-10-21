/*Riempire una sequenza con 10 orari, i minuti e le ore di ciascun dei quali
è un intero pseudo-casuale compreso rispettivamente tra 0 e 59 e tra 0 e
23. Successivamente acquisire da tastiera un orario. Visualizzare l’orario
della sequenza immediatamente precedente e l’orario immediatamente
successivo all'orario acquisito. Per svolgere questo compito si
definiscano 4 funzioni con le seguenti finalità.
• Produrre un orario valido casualmente definito
• Produrre 1 se un dato orario precede un secondo dato orario;
produrre 0 altrimenti
• Produrre il numero di minuti trascorsi tra due dati orari
• Inizializzare gli orari puntati da due dati puntatori con gli orari di un
sequenza di n orari che sono immediatamente precedente e successivo
ad un dato orario

*/
#include <stdio.h>
#include <stdlib.h>


#define DIM 10

typedef struct{
	int ore, minuti;
} Orario;

Orario estraiOra(void){
	Orario o;
	o.ore=rand()%24;
	o.minuti=rand()%60;
	return o;
}

bool precede(Orario o1,Orario o2){
	if (o1.ore<o2.ore|| 
	o1.ore==o2.ore && o1.minuti<o2.minuti)	return true;
	else return false;	
}

int minutiTrascorsi(Orario o1,Orario o2){

int  minuti = (o2.ore-o1.ore)*60+(o2.minuti-o1.minuti);

if(precede(o1,o2)==true)

	return minuti;
	
	else return -minuti;

}

void orarioPrecSucc(Orario seq[], int quantitaOrariDentroSeq, Orario rif, Orario *prec, Orario *succ){
	
	prec->ore=-1;
	succ->ore=-1;
	
	
	int i;
	for(i=0;i<quantitaOrariDentroSeq;i++){
		if(precede(seq[i],rif)==true){
			if(prec->ore < 0 || minutiTrascorsi(seq[i], rif) <= minutiTrascorsi(*prec, rif))
			*prec=seq[i];
		}
		if(precede(rif,seq[i])==true){ 
		if (succ->ore < 0 || minutiTrascorsi(seq[i], rif) <= minutiTrascorsi(*succ,rif))
			
			*succ=seq[i];
		}
	}
	
	
	
}
int main (void){
	
	int i;
	Orario v[DIM], oraRif, oraPrec,oraSucc;
	for (i=0;i<DIM;i++){
		v[i]=estraiOra();
		printf("%02d:%02d\n",v[i].ore,v[i].minuti);//si richiede al compilatore che si visualizzino almeno 2 cifre
	}
	printf("Inserisci un orario di riferimento: ");
	scanf("%d:%d",&oraRif.ore,&oraRif.minuti);
	
	orarioPrecSucc(v, DIM,oraRif,&oraPrec,&oraSucc);
	if(oraPrec.ore>0&&oraSucc.ore>0)
		{printf("Orario appena precedente: %02d:%02d\n",oraPrec.ore,oraPrec.minuti);
		printf("Orario appena successivo: %02d:%02d\n",oraSucc.ore,oraSucc.minuti);}
	else if(oraPrec.ore<0){
		printf("Orario appena precedente: Nessun orario disponibile\n");
	   	printf("Orario appena successivo: %02d:%02d\n",oraSucc.ore,oraSucc.minuti);}
	else{
		 printf("Orario appena precedente: %02d:%02d\n",oraPrec.ore,oraPrec.minuti);
		 printf("Orario appena successivo: Nessun orario disponibile\n");}
		
	
	return 0;
}
