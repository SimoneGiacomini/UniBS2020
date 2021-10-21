#include <stdio.h>
#include <stdlib.h>

#define DIM 10

typedef struct{
	int ore, minuti;
} Orario;

Orario estraiOra(void){
	Orario o;
	o.ore=rand()%24;
	o.minuti=rand()%60;
	return o;
}

int  minore(Orario o1, Orario o2){
	if(o1.ore<o2.ore|| o1.minuti<o2.minuti&& o1.ore==o2.ore)return 1;
	else return 0; 
}

void visualizza(Orario v[], int dimensioneV){
	int i;
	
	for(i=0;i<dimensioneV;i++) printf("%02d:%02d",v[i].ore,v[i].minuti);
}

int cancella(Orario v[], int dimensioneV, Orario minor, Orario massimo){
	int i, j;
	while(i<dimensioneV){
		if(minore(v[i],minor)==1||minore(massimo,v[i])==1){
			for(j=i;j<dimensioneV-1;j++){
				v[j]=v[j+1];
			}
			dimensioneV--;}
			else {
				i++;
			}
		
	}	

	
	
}

int main(void){
	int i,dimensioneArray=10;
	Orario arrayOrario[10], o1,o2;
	for(i=0;i<dimensioneArray;i++){
		arrayOrario[i]=estraiOra();
	}
	scanf("%d:%d", &o1.ore,&o1.minuti);
	scanf("%d:%d", &o2.ore,&o2.minuti);
	
	dimensioneArray=cancella(arrayOrario,dimensioneArray,o1,o2);
	visualizza(arrayOrario,dimensioneArray);
	
	return 0;
	
}
