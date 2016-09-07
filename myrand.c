#include<stdio.h>
#include<stdlib.h>
#include<time.h>

int main(int argc, char* argv[]){

	FILE *fp=fopen(argv[1],"w");
	srand(time(NULL));
	//printf("%d",atoi(argv[2]));
	for(int i=0; i<atoi(argv[2]);i++){
		int r= rand();
		fprintf(fp,"%d\n",r);
	}
	

}
