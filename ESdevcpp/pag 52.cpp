//pag 52
#include <stdio.h>
#include <stdlib.h>
#define DIMR 5
#define DIMC 12

int main (void){
	int mat[DIMR][DIMC], i, j, somma;
	
	for(i=0;i<DIMR;++i)
	{
		for(j=0;j<DIMC;++j)
		{
			mat[i][j]=rand()%81-40;
			printf("%4d", mat[i][j]);
			
		}
		printf("\n");
		
	}
	for(i=0;i<DIMR;++i)
	{	
		somma=0;
		for(j=0;j<DIMC;++j)
		{
			somma=somma+mat[i][j];
			
		}
		printf("%d\n",somma);
	}
return 0;
}
