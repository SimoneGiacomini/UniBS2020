#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#define LUN 60
/*
acquisire una parola, se ci sono lettere min uscole mettile maiuscole sennò fai il contrario
*/


char trasforma(char s){

		if(s>='A'&&s<='Z')
		{		s=s+32;
		}	
		else if (s>='a'&& s<='z'){
			s=s-32;
		}

	return s;
}
int main(){
	char s[LUN];
	printf("-> ");
	scanf("%60s", s);
	int i=0;
		printf("%s\n",s);
	while(s[i]!='\0'){
		s[i]=trasforma(s[i]);
		i++;
	}	
	printf("%s",s);
	
	return 0;
}
