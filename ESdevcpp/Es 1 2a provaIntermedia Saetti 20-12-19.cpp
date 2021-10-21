#include <stdlib.h>
#include <stdio.h>
#define DIM 6
int main (){
	int v[DIM],n=0,n1,n2;
	while(n<DIM){
		n1=n2=-1;
		printf("inserisci un numero Naturale ");
		scanf("%d",&n1);
		
		if(n1%2==0 && n1>0){
			
			while(n2%2==0 && n2<0){
			printf("inserisci un Numero naturale ");
			scanf("%d",&n2);
				
				 if(n2%2 ==0 && n2>0){
					n1=n2;
				}
			}
			v[n]=n1;
			v[n+1]=n2;
			n+=2;
		}
		
	}
	for(int i=0;i<DIM;i+=2){
		
		int a=v[i]+v[i+1];
		printf("\nla somma tra il numero pari e il suo precedente numero dispari e' %d",a);
	}
	return 0;
	
}
