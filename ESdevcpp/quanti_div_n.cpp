#include <stdio.h>
#include <stdlib.h>

int main (void){
	
	int n=0,i,j, div=0;
	
	for(i=0;i<=5;++i)
	{
		printf("Inserire il %d numero\n",i+1);
		scanf("%d",&n );
		div=0;
		for(j=1;j<=n;j++)
		{
		if(n%j==0)
		{
		++div;
		}
		
		}
		printf("La quantita' di divisori di %d sono %d\n",n, div);
	}
	
	
	return (0);
}
