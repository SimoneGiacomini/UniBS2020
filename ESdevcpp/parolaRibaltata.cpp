#include <stdio.h>
#include <stdlib.h>
#include<String.h>
#define DIM 21

int main (void)
{
	char parola[DIM];
	int lunghezza;
	
	scanf("%20s",parola);
	lunghezza=strlen(parola);
		
	printf("la parola ribaltata e' ");
	for (int i=lunghezza; i>=0; i--)
	{
		printf("%c",parola[i-1]);
		
		}
		
	
	
	return 0;
}
