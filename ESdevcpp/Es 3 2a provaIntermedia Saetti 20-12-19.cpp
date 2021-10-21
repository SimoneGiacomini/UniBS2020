#include <stdlib.h>
#include <stdio.h>
#define DIM 100

void somma(int v[], int dimV, int &p, int &d){
	
	int i;
	for(i=0;i<dimV;i++){
		if(v[i]%2==0){
			p=p+v[i];
		}
		else {
			d=d+v[i];
		}
	}
}
int main(){
	
	int v[DIM];
	int dim=0,spari=0,sdispari=0;
	v[0]=10;
	do{
		printf("->");
		scanf("%d",&v[dim]);
		dim++;
	}
	while(dim<DIM &&v[dim-1]>0);
	dim--;
	somma(v,dim,spari,sdispari);
	printf("%d\t%d",spari,sdispari);	
	return 0;
	
}
