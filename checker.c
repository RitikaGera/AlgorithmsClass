#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<math.h>

int cmpfn(const void *p1, const void *p2){
	return (*(int*)p1-*(int*)p2);	
}

int main(int argc, char* argv[]){
	FILE *fp=fopen(argv[1],"r");
	int size=atoi(argv[2]);
	int input[size];
	for(int i=0;i<size;i++){
		fscanf(fp,"%d",	&input[i]);
	}
	qsort(input,size,sizeof(int),cmpfn);
	FILE *fp2=fopen("expectedout.txt","w");
	for(int i=0;i<size;i++){
		fprintf(fp2,"%d\n",input[i]);	
	}






}
