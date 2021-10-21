#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>
#include <unistd.h>



int main (){
	
	int a,i=0;
	time_t b;
		
	//printf("%d\n",b);
	while(i<200){
	time ( &b);
	a=b%101;
	printf("NUMERO %d\n",a);
	i++;
	
	}	
	return 0;
}
