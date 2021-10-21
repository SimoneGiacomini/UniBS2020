#include <stdio.h>
#include <stdlib.h>

#define RIGA 10
#define COLONNE 12

void somma (int v[], int Dimensione, int *somma_positivi, int *somma_negativi)
{
	int i;
	*somma_positivi=0;
	*somma_negativi=0;
	for (i=0;i<Dimensione;i++)
	{
		if(v[i]>0)
		*somma_positivi=*somma_positivi+v[i];
		else {
		*somma_negativi=*somma_negativi+v[i];	
		}
		
	}
}

int main ()
{
	int i, j, mat[RIGA][COLONNE], sommaP=0, sommaNeg=0;
	
	for(i=0;i<RIGA; i++)
	{
		for(j=0;j<COLONNE; j++)
		{	mat[i][j]=rand()%101-50;
			printf("%4d",mat[i][j]);
		}
		printf("\n");
	}
	for (i=0;i<RIGA;i++){
		somma(mat[i],COLONNE, &sommaP, &sommaNeg);
		printf("%da riga\n", i+1);
		printf("La somma dei numeri positivi e' %d\nLa somma dei numeri negativi e' %d\n",sommaP, sommaNeg);
		
		printf("\n");	
	}
	
	
	
	return 0;
}
