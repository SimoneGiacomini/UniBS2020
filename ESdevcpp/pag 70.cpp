#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int dividendo, divisore, quoz, resto;
	for (int i=1; i<=5; i++)
	{
	printf ("inserisci dividendo e divisore\n");
	scanf ("%d %d",&dividendo, &divisore);
	quoz=dividendo/divisore;
	resto=dividendo%divisore;
	printf ("il quoz e' %d\n", quoz);
	printf ("il resto e' %d\n", resto);
	}
	return 0;
}
