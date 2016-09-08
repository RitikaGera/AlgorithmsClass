/* Version4 : N numbers(10^10), select K smallest of them
 * Approach : Maintain an array of size 2*K, find A RANDOM PIVOT(NOT MEDIAN), the elements ahead of it are not candidates,so we discard them 	and take next elements(they can be any number<=k)
 * Now the randomly chosen pivot can lie on either side of median(index K),
 * if it lies to right, then Ok
 * but if it lies to left, I will loose the K numbers I got
 * So, in such a case, I discard this pivot and chose a fresh pivot
 * We repeat until all elements are covered,
 * Space Complexity : O(2*K)
 * Time Complexity : O(N*K)
 */
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<math.h>

#define K 5

int partition(int arr[], int start, int end);
int pivot(int arr[], int start, int end);
void swap(int arr[], int pos1, int pos2);
int call(int[],int,int,FILE*);

int main(int argc, char* argv[]){

	FILE *fp=fopen(argv[1],"r");
	int input[2*K];
	
	for(int i=0;i<2*K;i++){
		fscanf(fp,"%d",&input[i]);
		printf("input %d\n",input[i]);
		fflush(stdout);	
	}
	
	int pivot=call(input,0,2*K-1,fp);
	
	printf("IN MAIN pivot is %d\n",pivot);
	
	for(int i=0;i<K;i++){
		printf("%d\n",input[i]);	
	}
}

int call(int input[],int start,int end, FILE* fp){
	//printf("FILE*",fp);

	int pivot=partition(input,start,end);
	printf("IN CALL pivot is %d\n",pivot);
	
	printf("printing array after partitioning in call out\n");
	for(int i=0;i<2*K;i++){
		printf("%d\n", input[i]);	
		fflush(stdout);
	}
	
	
	while(pivot<K){
		pivot=partition(input,start,end);
		
		printf("printing array after partitioning in frist while\n");
		for(int i=0;i<2*K;i++){
			printf("%d\n", input[i]);	
			fflush(stdout);
		}
		printf("FIRST PIVOT FOUND INSIDE WHILE %d\n",pivot);
	}
	
	int k=pivot+1;
	printf("out of first while k is %d",k);
	if(k<2*K){
		while(fscanf(fp,"%d",&input[k++])!=EOF ){
			printf(" k inside while %d and value is %d \n",k-1,input[k-1]);
			while(k<2*K ){
			
				fscanf(fp,"%d",&input[k++])!=EOF)
				printf("inside while k is %d and value is %d\n",k-1,input[k-1]);
				 //changes to be done here, check for EOF without scanning anything somehow
			}
			call(input,start,end,fp);
		}
	}
	return pivot;


}	
	
int partition(int arr[],int start,int end){

        if(start==end)
                return start;

        int i,j,pos;
        i = start-1;
        j = start;
        pos=pivot(arr,start,end);
        swap(arr,pos,end);
        for(int j=start;j<end;j++){
		if(arr[j]<=arr[end]){
			i=i+1;	
			swap(arr,i,j);	
		}	
		
	}
	swap(arr,i+1,end);
	return i+1;
}

int pivot(int arr[], int start, int end)
{
	//if(end-start+1>0){
		int p = start + rand() % (end - start + 1);
		/*printf("start is %d end is %d and second part gives %d\n",start,end,rand()%(end-start+1));
		fflush(stdout);*/
		//printf("pivot index %d\n",p);
		//fflush(stdout);
		return p;
//	}
	/*else{
		printf("ok %d", (end-start+1));
		fflush(stdout);
		return -1;
			
	}*/
}

void swap(int num[], int a ,int b){
	int temp=num[a];
	num[a]=num[b];
	num[b]=temp;
}
