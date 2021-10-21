/*Scrivere un programma C (funzione main) che acquisisca da tastiera una successione
di numeri naturali che termina con il primo naturale x positivo e inferiore o uguale a 20; 
successivamente visualizzare una sequenza di 100 numeri interi pseudo-casuali compresi tra 1 e 20 ed
infine il numero di occorrenze di x presenti nella sequenza. Per svolgere questo compito si definisca
esclusivamente la funzione principale main.
*/
#include <stdio.h>
#include <stdlib.h>

#include <unistd.h>


#define delay 10
#define millisecondo 100000



int main (void){
	int num, i=0, nRandom, occ=0, aspetta=delay* millisecondo;
	do {
		   printf("\nInserire  un numero naturale, per terminare la seq inserire un numero minore o uguale a 20: ");
		   scanf("%d",&num);
		   
	}while(num>20);
	
	while(i<100){//potevo fare anche un for
		
		nRandom=rand()%20+1;
		printf("\n%d",nRandom);
		usleep(aspetta);
		if(num==nRandom){
			occ++;
		}
		i++;
	}
	printf("\nIl numero di occorrenze e' %d",occ);
	return 0;
}
