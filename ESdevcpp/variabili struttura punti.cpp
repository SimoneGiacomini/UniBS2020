#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

#define DIM 10

typedef struct{
	int X,Y;
 float distanzaDaOrigine=distanzaTra2punti(X,0,Y,0);
}Punto;


//distanza tra 2 punti dando come parametri due punti
float distanzaTra2puntiP(Punto p1,Punto p2){
	
	float d= sqrtf(powf((p1.X -p2.X),2)+powf((p1.Y - p2.Y),2));
	return d;
}

//distanza tra due coordinate, dando in ingresso i 
float distanzaTra2punti(float x1,float x2,float y1, float y2){
	
	
	float d= sqrtf(powf((x1-x2),2)+powf((y1-y2),2));
	return d;
}

//vari visualizza
void visualizzaPunto(Punto p){
	printf("\n(%d;%d)",p.X,p.Y);
}

void visualizzaPuntoEdistanza(Punto p){
	printf("\n(%d;%d), distanza dall'origine %.05f",p.X,p.Y,p.distanzaDaOrigine);
}

void visualizzaPunti(Punto p[], int dimensioneP){
	for(int i=0;i<dimensioneP;i++){
		visualizzaPunto(p[i]);
	}
}
void visualizzaPuntiEdistanza(Punto p[], int dimensioneP){
	for(int i=0;i<dimensioneP;i++){
		visualizzaPuntoEdistanza(p[i]);
	}
}

//invece che farlo nel main ho voluto creare una funzione apposita per l'estrazione casuale dei punti
Punto estraiPunto(){
	Punto p;
	
	p.X=rand()%2001-1000;
	p.Y=rand()%2001-1000;
	p.distanzaDaOrigine = distanzaTra2punti(p.X,0,p.Y,0);
	return p;
	
}


//Bubble sort con distanza in forma crescente
void ordinaDistanza(Punto p[], int dimensioneP){
	int i,j;
	Punto x;
	for(i=0;i<dimensioneP-1;i++){
		for(j=dimensioneP-1;j>i;j--){
			if(p[j-1].distanzaDaOrigine>p[j].distanzaDaOrigine){
			
				x=p[j-1];
				p[j-1]=p[j];
				p[j]=x;}
		}
	}
}
  
/**
Questa è la funzione che appunto dovrebbe darmi il punto più vicino A (il quale è all'interno di un array), rispetto ad un punto B
*/
Punto puntoPiuVicino(Punto arrayP[], int dimensioneArray, Punto confronta){
	
	Punto piuV;
	 piuV=arrayP[0];
	int i; 
	float d1,d2;
	for(i=1;i<dimensioneArray;i++)
	{
		if(distanzaTra2puntiP(arrayP[i],confronta) < distanzaTra2puntiP(piuV,confronta))
		{		
			piuV=arrayP[i];
		}
	}
	return piuV;
}



int main(){
	
	Punto arrayP[DIM], pInsert;
	int n=0;
	while(n<DIM){//potevo benissimo fare un for ma ho voluto farlo in un altro modo
		arrayP[n]=estraiPunto();
		n++;
	}
	arrayP[n-1]={160,719};
	ordinaDistanza(arrayP,n);
	visualizzaPunti(arrayP,n);			
	printf("\n\nInserisci ora un punto: ");
	printf("\nX: 160");
	printf("\nY: 720");
	pInsert={160,720};//ho velocizzato la parte di acquisizione
	
	// non ho definito una funzione per la valorizzazione di distanzaDaOrigine perché tecnicamente il programmatore non dovrebbe riassegnarla
	printf("\nLa sua distanza dall' origine e': %f\n",pInsert.distanzaDaOrigine=distanzaTra2punti(pInsert.X,0,pInsert.Y,0));

	arrayP[n]=pInsert; //ora aggiungo il punto acquisito nell'array nell'ultima posizione
	n++;//la dimensione dell'array ora è più grande
	
	visualizzaPuntiEdistanza(arrayP,n);
	printf("\n\nIl punto piu' vicino al punto inserito," );
	visualizzaPunto(puntoPiuVicino(arrayP,n,pInsert));
		
	return 0;
}
