#include <stdio.h>


int main(void){
	
	int dividendo;
	int divisore, quoz_int=0,somma;
	
	do{
		printf("->");
		scanf("%d%d",&dividendo,&divisore);
	} while(dividendo<=0||divisore<=0);
	//termine dividendo >0 && divisore >0 se
	
	somma=divisore;
	while (dividendo>=somma)
	{
		somma=somma+divisore;
		quoz_int=quoz_int+1;
	}
	printf("%d\n",quoz_int);
	
	
	
	return (0);
}
