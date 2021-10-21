#include <stdio.h>
#include <stdlib.h>

#define RIGA 4
#define COLONNE 4 

int somma(const int v[], int Dimensione){
	int i, somma=0;
	for(i=0;i<Dimensione;i++ )
	somma=somma+v[i];
		
		return somma;
}

int main(void){
	
	int i, j, mat[RIGA][COLONNE];
	
	for(i=0;i<RIGA; i++)
	{
		for(j=0;j<COLONNE; j++)
		{	mat[i][j]=rand()%101-50;
			printf("%4d",mat[i][j]);
		}
		printf("\n");
	}
	for(j=0;j<RIGA; j++)
		{
			printf("%4d\n",somma(mat[j], ));
}
	return 0;
}
