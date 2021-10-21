#include <stdio.h>

int main (void){
	
	int n;//numero naturale
	
	scanf("%d",&n);
	
	printf("\n");
	printf("\n");
	
	for(int i=1;i<=n;++i)
	{
		for(int j=1;j<=i;++j)
		{
		printf("%d",i);
		
		}
		printf("\n");
	}	
return (0);
}
