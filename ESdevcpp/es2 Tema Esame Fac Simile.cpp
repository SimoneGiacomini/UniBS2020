/*Scrivere un programma C che visualizzi la quantità di divisori di 10 numeri naturali
acquisiti da tastiera. Per svolgere questo compito si definisca ed utilizzi una funzione che produca
la quantità di divisori di un dato intero.
*/
#include <stdio.h>
#include <stdlib.h>

#define DIM 4

int divisori(int numero){
	int  i,conta=0;
	for(i=1;i<=numero;i++){
		if(numero%i==0) conta++;
	}
	return conta;
}

int main(void){
	
	int naturali[DIM]={0}, i;
	for(i=0;i<DIM;i++){
		printf("Inserisci il %d' numero NATURALE: ",i+1);
		scanf("%d", &naturali[i]);
	}
		for(i=0;i<DIM;i++){
		printf("\n%d ha %d divisori ",naturali[i],divisori(naturali[i]));
		
	}
	
	return 0;
}
