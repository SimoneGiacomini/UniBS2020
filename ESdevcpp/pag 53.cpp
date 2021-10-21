#include <stdio.h>
#include <stdlib.h>
#define DIMR 5
#define DIMC 12

int main(void){
	
	int mat[DIMR][DIMC], i, j, somma=0;
	
	for(i=0; i<DIMR; ++i)
	{
		for(j=0; j<DIMC; ++j)
		{
			mat[i][j]= rand()%101-20;
			printf("%d\t", mat[i][j]);
			
		}
		printf("\n");
	}
	for(i=0;i<DIMC;i++)
	{
		somma=0;
		for(j=0;j<DIMR;j++)
		{
			somma=somma+mat[j][i];
			
		}
		printf("la somma della colonna %d e' %d \n",i,somma);
	}
	
	return 0;
}
