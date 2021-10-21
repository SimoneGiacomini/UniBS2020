#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define RIGA 10
#define COLONNE 21

int contaSegueLessicograficamente( char *Destinazione,  char *sorgente)
{
	int conta=0;
	if(strcmp(Destinazione, sorgente)>0)
		conta=conta+1;
		return conta;
}

int main(void){
	
	char parola[RIGA][COLONNE],ris[RIGA*COLONNE]=" ";
	int i,conta=0, n=0;
	
	do{
		printf("Inserisci la %da parola-> ",n+1);
		scanf("%20s",parola[n]);
		n++;
	}
	while ((n>RIGA) || (strcmp(parola[n-1],"fine")!=0) );
	
	if(strcmp(parola[n-1],"fine")==0)n--;
	
	for(i=0; i<n;i++)
	{
		if(strcmp(parola[i],parola[0])>0){
			strcat(strcat(ris,parola[i]),"");
			conta++;
		}
	}
	
	if(conta!=0){
		printf("%d\n",conta);
		printf("%s",ris);}
	else{
		printf("Non esiste alcuna parola inserita che venga lessicograficamente prima della prima parola");
	}
	return 0;
}
