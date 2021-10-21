/*Si consideri una sequenza di 10 interi pseudo-casuali compresi tra 500 e
2000, una seconda sequenza di 20 reali pseudo-casuali compresi tra 0.5 e 2.0
(si utilizzi una precisione di 2 cifre dopo la virgola). Si aggreghi le due
sequenze; si visualizzi la sequenza aggregata; infine si visualizzi il più piccolo
dato tra quelli nella sequenza considerando che i reali sono delle misurazioni
in metri mentre gli interi sono delle misurazioni in millimetri. Per svolgere
questo compito si definiscano ed utilizzino 4 funzioni C con le seguenti
finalità.
• Riempire una data sequenza di variabili miste interi/reali con i reali di una
data sequenza di n1 variabili reali e gli interi in una data sequenza di n2
variabili intere, producendo la lunghezza della sequenza risultante
• Visualizzare una data variabile mista intera/reale
• Produrre 1 se una data variabile mista intera/reale è minore di una
seconda data variabile mista intera/reale; produrre 0 altrimenti
• Produrre la variabile mista intera/reale più piccola in un dato vettore di n
variabili miste intere/reali  */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>


#define DIM1 10
#define DIM2 20
#define DIM3 30
#define MM 0
#define M 1

typedef struct{
	
	union{
	 int mm;//tanto non può essere negativo
	 float m;
		}u;
int tipo;
	}Statura;
	
int aggrega(Statura vs[], int vi[], int n1,float vf[], int n2){
	int i,j;
	for(i=0;i<n1;i++){
		vs[i].u.mm=vi[i];
		vs[i].tipo=MM;
	}
	for(j=0;j<n2;j++,i++){
		vs[i].u.m=vf[j];
		vs[i].tipo=M;
	}
	return i;
}
	
void visualizza(Statura s){
	if(s.tipo==MM){
		printf("%d\n",s.u.mm);
	}
	else{
		printf("%.02f\n",s.u.m);
		
	}
}

int minore(Statura s1, Statura s2){
	int misuraRimodulata1, misuraRimodulata2;
	switch(s1.tipo){
	
	case 1:{
		if(s2.tipo==MM)
			{
			misuraRimodulata1=s1.u.m*1000;
			misuraRimodulata2=s2.u.mm;
		}
		else {
			misuraRimodulata1=s1.u.m*1000;
			misuraRimodulata2=s2.u.m*1000;
		}
		break;
			}
		case 0:{
			if(s2.tipo==M){
				misuraRimodulata2=s2.u.m*1000;
				misuraRimodulata1=s1.u.mm;
			}
			else{
				misuraRimodulata1=s1.u.mm;
				misuraRimodulata2=s2.u.mm;
			}
			break;
				}
				
	}
	if(misuraRimodulata1<misuraRimodulata2)
	return 1;
	else return 0;
	
}
	
void ordina(Statura v[], int m){
	
	int i,j;
	Statura x;
	
	for(i=0;i<m-1;i++){
		for(j=m-1;j>i;j--)
		
		{
			 if(minore(v[j],v[j-1])==1)
			 { 	x=v[j-1];
			 	v[j-1]=v[j];
			 	v[j]=x; 
			 }
		}
	
	}
	
}
 
 Statura piuMinore(Statura v[], int dimensioneV){
		
		int i;
		Statura min=v[0];
		for(i=1;i<dimensioneV;i++){
			if(minore(v[i],min)==1)
			min=v[i];
		}
		return min;
		
		
	}
	
	
int main(void){
	
	int i, misuraMilli[DIM1], n;
	float misuraMetri[DIM2];
	Statura misuraMetriMilli[DIM3];
	
	for(i=0;i<DIM1;++i){
		
		misuraMilli[i]=rand()%1501+500;
	//	printf("%d\n",misuraMilli[i]);
		}
		
	for(i=0;i<DIM2;++i){
	
		misuraMetri[i]=(rand()%1501+500) /1000.0;//il valore che rand restituisce viene promosso a float
	//	printf("%.02f\n",misuraMetri[i]);
	}
	
	
	
	n= aggrega(misuraMetriMilli, misuraMilli, DIM1, misuraMetri, DIM2);
	
	for(i=0;i<n;i++)
	visualizza(misuraMetriMilli[i]);
	
	printf("\n");
	for(i=0;i<10;i++)
	printf("CIAO");
		printf("\n");
		printf("\n");

	ordina(misuraMetriMilli,n);
	for(i=0;i<n;i++){
		visualizza(misuraMetriMilli[i]);
	}
	printf("\n\nLa misura piu' piccola e': ");
	visualizza(piuMinore(misuraMetriMilli,n));
	
	return 0;
}
