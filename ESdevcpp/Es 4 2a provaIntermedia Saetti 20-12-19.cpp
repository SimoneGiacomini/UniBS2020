#include <stdlib.h>
#include <stdio.h>
#define NC 5
#define LUN 20

/*creare un email formata da un dominio e un nome utente (definire un nuovo tipo di dato)
->creare una funzione che controlli che il dominio sia fatto da un punto e prima del punto da almeno 2 lettere (es. fe.com, oppure GH.LLL!, GHFUVVUDYU.KKKKK$4) restituisce 1 se è valida, 0 altrimenti
->controllare e cancellare in un array di email, le email errate*/

typedef struct{
	char utente[LUN], dominio[LUN];
}Email; 

int domValido(Email e){
	int n=0,contaP=0;
	for(n;n<2;n++)if(e.dominio[n]=='.')return 0;
	
	for(n=2;e.dominio[n-1]!='\0'&&contaP<2;n++)
		if(e.dominio[n]=='.')contaP++;
	if (contaP==1)return 1;
	return 0;
}

int uteValido(Email e){
	int n=0;
	for(n=0;e.utente[n]!='\0';n++){
		if(e.utente[n]=='.'||e.utente[n]==':'||e.utente[n]==','||e.utente[n]==';')return 0;
		return 1;
	}
}

int valido(Email e[], int dimE){
	int i;
	for(i=0;i<dimE;i++){
		if(domValido(e[i])==0||uteValido(e[i])==0){
			for(int j=i;j<dimE;j++){
				e[j]=e[j+1];
			}
			dimE--;}
	}
	return dimE;
	
}

int main(){
	
	Email array[NC];
	for(int i=0;i<NC;i++){
		printf("\n%d\nInserisci il nome utente ",i+1);
		scanf("%s",&array[i].utente);
		printf("inserisci il dominio ");
		scanf("%s",&array[i].dominio);
		fflush(stdin);
	}
	int dim=valido(array,NC);
	for(int i=0;i<dim;i++){
		printf("\n%s@%s",array[i].utente,array[i].dominio);
	}
	
	return 0;
}

