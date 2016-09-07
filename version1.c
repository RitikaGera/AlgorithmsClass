/* Given n numbers(n=10^10), find the smalles K numbers (K=10000)
 * Approach 1 : Heap
 * Make a max heap of first K numbers, if next(K+1)th number is greater than or equal to root, then discard it
 * if it is less than root,replace root with this new number, and DownHeapify on root
 * Space Complexity : O(K) storing K numbers in heap at any time 
 * Time Complexity : O(K) for building heap, then for n-K elements we call down heapify, that takes O(logk) time
 * So O(K+n*log(K))
 */
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>

#define K 10000


void buildmaxheap(int[],int);
void restoreDown(int[],int i, int size);

int main(int argc, char* argv[]){
	FILE *fp=fopen(argv[1],"r");
	int current[K];
	char c;
	int k=0;//actual numbers of numbers read, because i nthe last chunk there may not be 'K' numbers to be read
	for(int i=0;i<K;i++){//no check imposed on what happens if the file doesnt have K numbers, in this garbage output is coming, rectify 						it
		fscanf(fp,"%d",&current[k++]);
	}
	
	buildmaxheap(current,k);
	int max=current[0];
	int new;
	//fscanf(fp,"%d",&new);
	while(fscanf(fp,"%d",&new)!=EOF){
		while(new>=current[0]){
		
			fscanf(fp,"%d",&new);	
		}
		current[0]=new;
		restoreDown(current,0,k);
		printf("new %d\n",current[0]);
	}
	printf("K smallest numbers are");
	for(int i=0;i<K;i++){
		printf("%d\n",current[i]);
	}
	

}

void buildmaxheap(int current[],int size){//BottomUpApproach :O(n), had I used Top down Approach for building heap, I would have taken O(nlogn)
	for(int i=(size/2);i>=0;i--){
		restoreDown(current,i,size);	//taking root at index 0
	}
	for(int i=0;i<5;i++){
		printf("heap %d\n",current[i]);	
	}
	
	
}

void restoreDown(int current[],int i, int size){

	int lchild=2*i;
	int rchild=lchild+1;
	int num=current[i];
	while(rchild<size){//we are checking if right child is not null, but it necessarily has one child since I picked first non-leafnode 					(gotta be left: str prop)
		if(num>=current[lchild] && num >= current[rchild]){
			current[i]=current[i];//do no changes
			return;
		}
		else if(current[lchild]>= current[rchild]){
			current[i]=current[lchild];
			i=lchild;				
		}
		else{
			current[i]=current[rchild];
			i=rchild;		
		}
		lchild=2*i;
		rchild=2*i+1;			
	}
	//if number of nodes is even means if 1 node has only left child, in that case while loop is exited but we have one node left unchecked
	if(lchild==size-1 && current[lchild]>num){
		current[i]=current[lchild];
		i=lchild;	
	}
	current[i]=num;

}
