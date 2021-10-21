#include <stdio.h>
#include <stdlib.h>

int main(void)
{
	int n,i, n_primi=0, n_div;
	
	do{
		printf ("inserisci n\n");
		scanf ("%d", &n);
		
		n_div=0;
		
		for(i=0;i<=n;i++)
		{
			if(n%i==0)
			n_div=n_div+1;
		}
			if(n_div==2)
			n_primi=n_primi+1;
		
	}while(n!=0);	
	
	printf("Hai acquisito %d numeri primi\n",n_primi);
	
	
	return 0;
}
