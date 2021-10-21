#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define RIGA 10

int primo(int x){
	int i;
	for (i=2;i<x;x++)
		if(x%i==0) return 0;
	return 1;
	
}

int primoInfdi(int x){
	int i;
	i=x-1;
	while(primo(i)==0){
		i--;}
	return i;
}

int primoSupdi(int x){
	int i;
	i=x+1;
	while(primo(i)==0){
		i++;}
	return i;
}

int main(void){

int i, vet[RIGA];

for( i=0;i<RIGA;i++){
	
	vet[i]=rand()%91+10;
	printf("%4d",vet[i]);
	}
	
	for(i=0;i<RIGA;i++){
	printf("%d %d %d", vet[i],primoInfdi(vet[i]), primoSupdi(vet[i]));
	}
	
	

	return 0;
}
