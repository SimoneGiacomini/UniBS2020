#include <stdio.h>


int main(void){
	
	int n_input;//n è il numero che si acquisisce, è un numero naturale
	int n_inv=0,n/* è n_input, variabile di supporto*/,cifra;
	
	
	
	scanf("%d", &n_input);
	
	n=n_input;
	do	{
		cifra=n%10;
		n_inv= n_inv*10+cifra;
		n=n/10;
		}
	while(n>0);
	
	if(n_input>n_inv)
	{
		printf("%d e' maggiore di %d",n_input, n_inv);
	}
	 else{
	 	printf("%d e' maggiore di %d", n_inv,n_input);
	 }
	
	return (0);
}
