#include <stdio.h>
#include <stdlib.h>
#include <time.h>

#define DIM 10

int cerca(float v[], int dimensioneVet, float nCercato){
	int i;
		
	for(i=0;i<dimensioneVet;i++)
		if(v[i]==nCercato) return i;
		return -1;
}

int inserisci(float v[], int dimensioneVet, float nDaInserire){
	int i, pos= cerca(v, dimensioneVet, nDaInserire);
	if(pos<0)
	{for(i=dimensioneVet-1;i>=0 && v[i]>nDaInserire;--i)
		v[i+1]=v[i];
 	v[i+1] =nDaInserire;
		dimensioneVet++;
		}	
		return dimensioneVet;
}

void visualizza(float v[], int dimensioneVet){
	int i;
	for(i=0;i<dimensioneVet;++i){
		printf("%.2f\t", v[i]);
	}
	
}

int main(void){
	
	int n=0;
	float reali[DIM], realeCasuale;
	
	do {
		realeCasuale= rand() % 101 /100.0;//divido per 100.0 in modo che faccia il casting del numero rand rimodulato in float
		n=inserisci(reali, n, realeCasuale);	
	} while(n<DIM);
	
	visualizza(reali,n);
	
	return 0;
}
