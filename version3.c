/* Given n numbers(10^6), find K smallest numbers
 * Approach : Random pivot
 * Take an array of size 2*k
 * We find element of rank k as in version 2
 * Now choose a random pivot, instaed of deterministic, (chosing a deterministic pivot takes time)
 * Space Complexity : O(2*K)
 * Time Complexity : O(n)
 */

#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define K 10

int myselect(int num[],int start,int end,int rank);
void swap(int[],int,int);
int pivot(int[],int,int);
int partition(int[],int,int,int);

int main(int argc, char* argv[]){

	FILE *fp=fopen(argv[1],"r");
	int input[2*K];
	
	for(int i=0;i<2*K;i++){
		fscanf(fp,"%d",&input[i]);	
	}
	int median_pos=myselect(input,0,2*K-1,K);
	printf("\nin main pivot %d and value is %d ",median_pos,input[median_pos]);
	int k=median_pos+1;
	while(fscanf(fp,"%d",&input[k++])!=EOF){
		
		printf("inside %d %d",k,input[k]);
		fflush(stdout);
		//k=median_pos+1;
		for(int i=median_pos+2;i<2*K;i++){
			printf("index i %d	",i);
			fscanf(fp,"%d",&input[i]);
			printf("%d",input[i]);
		}	
		median_pos=myselect(input,0,2*K-1,K);	
		k=median_pos+1;
	}
	printf("%d\n",median_pos);
	printf("******************");
	for(int i=0;i<K;i++){
		printf("%d\n",input[i]);
	}

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
	printf("Desired rank %d",rank);
	printf("rank r %d",r);
	fflush(stdout);
	if(rank==r){
		return pivot_pos;	
	}
	else if(rank<r){	//the element I am looking for is in right
		myselect(num,pivot_pos+1,end,rank);
	}
	else{//element is left of pivot_pos, now since interval changed and right part thrown away has elements affecting rank, we update rank
		printf("LEFT");
		fflush(stdout);			
		myselect(num,start,pivot_pos-1,rank- (end-pivot_pos+1));//not end-pivot_pos because we never assumed pivot is one of the 									                	element of numarray	
	}

}

int pivot(int num[],int start,int end){
	
	
		int p = start + rand() % (end - start + 1);
		printf("start is %d end is %d and second part gives %d\n",start,end,rand()%(end-start+1));
		fflush(stdout);
		printf("pivot index %d\n",p);
		fflush(stdout);
		return p;
	

}

int partition(int num[],int start,int end,int pos){	//Coreman, not Hoare's original version
		if (start == end)
			return start;

		int i, j;
		i = start - 1;
		//pos=pivot(num,start,end);
		swap(num, pos, end);//so that from now on I can continue my normal partition function
		for(int j=start;j<end;j++){
			if(num[j]<=num[end]){
				i=i+1;
				swap(num,i,j);
			}	
		}
		swap(num,i+1,end);
		printf("%d",i);
		return i+1;
}

void swap(int num[],int a, int b){
	int temp=num[a];
	num[a]=num[b];
	num[b]=temp;
}
