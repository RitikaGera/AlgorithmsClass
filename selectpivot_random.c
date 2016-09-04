/* Given two arrays, A (array of numbers-10^6 integers) and B(array of ranks-10^4 integers),
 * for each rank in B, find the element with that rank in A
 * Complexity : O(n)
 * Approach : Random Select of pivot
 */

#include<stdio.h>
#include<stdlib.h>
#include<time.h>

#define NUMARRAY_SIZE 100
#define RANKARRAY_SIZE 10

int myselect(int num[],int start,int end,int rank);
void swap(int[],int,int);
int pivot(int[],int,int);
int partition(int[],int,int,int);

int main(int argc, char* argv[]){

	FILE *n=fopen(argv[1],"r");//argv[0] represents name of executable
	FILE *r=fopen(argv[2],"r");
	FILE *o=fopen("output.txt","w");

	int num[NUMARRAY_SIZE];
	int rank[RANKARRAY_SIZE];

	srand(time(NULL));//In order to generate random-like numbers, srand is usually initialized to some distinctive runtime value, like the 					value returned by function time 

	for(int i=0;i<NUMARRAY_SIZE;i++){
		fscanf(n,"%d",&num[i]);
	}

	for(int i=0;i<RANKARRAY_SIZE;i++){
		fscanf(r,"%d",&rank[i]);
	}
	
	for(int i=0;i<RANKARRAY_SIZE;i++){
		int num_index=myselect(num,0,(RANKARRAY_SIZE)-1,rank[i]);//num_index is the index of the number in number array of rank r[i]
		fprintf(o,"%d",num[num_index]);
		fflush(o);
		printf("i %d\n",i);
		fflush(stdout);
		
	}

	return 0;


}


int myselect(int num[],int start,int end,int rank){
	if(start==end){
		return start;	
	}
	
	int pivot_orgpos=pivot(num,start,end);//the pivot function will return a random index since it is an index between the 								specified range only, the pivot exists in the array
	int pivot_pos=partition(num,start,end,pivot_orgpos);//elements are now partiotioned acc to pivot selected,pivot at 											this posn now	
	printf("new %d\n",pivot_pos);
	fflush(stdout);
	int r= end - pivot_pos + 1;
	if(rank==r){
		return pivot_pos;	
	}
	else if(rank<r){	//the element I am looking for is in right
		myselect(num,pivot_pos+1,end,rank);
	}
	else{//element is left of pivot_pos, now since interval changed and right part thrown away has elements affecting rank, we update rank
		myselect(num,start,pivot_pos-1,rank- (end-pivot_pos+1));//not end-pivot_pos because we never assumed pivot is one of the 									                	element of numarray	
	}

}

int pivot(int num[],int start,int end){
	
	//if(end-start+1>0){
		int p = start + rand() % (end - start + 1);
		printf("start is %d end is %d and second part gives %d\n",start,end,rand()%(end-start+1));
		fflush(stdout);
		printf("pivot index %d\n",p);
		fflush(stdout);
		return p;
//	}
/*	else{
		printf("ok %d", (end-start+1));
		fflush(stdout);
		return -1;
			
	}*/

}

int partition(int num[],int start,int end,int pivot_orgpos){	//Coreman, not Hoare's original version
	if (start == end)
		        return start;

		int i, j, pos;
		i = start - 1;
		
		swap(num, pivot_orgpos, end);//so that from now on I can continue my normal partition function
		for(int j=start;j<end;j++){
			if(num[j]<=num[end]){
				i=i+1;
				swap(num,i,j);
			}	
		}
		swap(num,i+1,end);
		return i+1;
}

void swap(int num[],int a, int b){
	int temp=num[a];
	num[a]=num[b];
	num[b]=temp;
}
