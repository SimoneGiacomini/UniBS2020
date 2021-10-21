#include <stdio.h>
#include <stdlib.h>
#define DIMR 5
#define DIMC 12

int main(void){
	
	int mat[DIMR][DIMC], i, j, somma=0,num;
	
	for(i=0; i<DIMR; ++i)
	{
		for(j=0; j<DIMC; ++j)
		{
			mat[i][j]= rand()%80-40;
			printf("%d\t", mat[i][j]);
			
		}
		printf("\n");
	}
	
	for(i=0;i<DIMC;i++)
	{
		num=0;
		somma=0;
		for(j=0;j<DIMR;j++)
		{
			if(m[j][i]>0){
			somma=somma+mat[j][i];
			num++;
			}
			if(num>0)
			printf("%.2f\n",(float)somma/num);
			
			
		}
		printf("la somma della colonna %d e' %d \n",i,somma);
	}
	
	return 0;
}
