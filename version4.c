/* Version4 : N numbers(10^10), select K smallest of them
 * Approach : Maintain an array of size 2*K, find A RANDOM PIVOT(NOT MEDIAN), the elements ahead of it are not candidates,so we discard them 	and take next elements(they can be any number<=k)
 * Now the randomly chosen pivot can lie on either side of median(index K),
 * if it lies to right, then Ok
 * but if it lies to left, I will loose the K numbers I got
 * So, in such a case, I discard this pivot and chose a frsh pivot
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
	}
	
	int pivot=call(input,0,2*K-1,fp);
	
	printf("IN MAIN pivot is %d\n",pivot);
	
	for(int i=0;i<K;i++){
		printf("%d\n",input[i]);	
	}

}

int call(int input[],int start,int end, FILE* fp){

	int pivot=partition(input,start,end);
	printf("IN CALL pivot is %d",pivot);
	
	while(pivot<K){
		pivot=partition(input,0,2*K-1);
		printf("FIRST PIVOT FOUND INSIDE WHILE %d\n",pivot);
	}
	
	int k=pivot+1;
	printf("ou of first while k is %d",k);
	while(k<2*K && fscanf(fp,"%d",&input[k++])!=EOF ){
		printf(" k inside while %d and value is %d \n",k-1,input[k-1]);
		while(k<2*K){
			fscanf(fp,"%d",&input[k++]);
		}
		call(input,start,end,fp);
	}
	return pivot;


}	
	
int partition(int arr[], int start, int end)
{
        if (start == end)
                return start;

        int i, j, pos;
        i = start - 1;
        j = start;
        pos = pivot(arr, start, end);
        swap(arr, pos, end);
        while (j < end) 
        {
                if (arr[j] <= arr[end]) 
                {
                        i = i + 1;
                        swap(arr, i, j);
                }
                j++;
        }
        i = i + 1;
        swap(arr, i, end);
	printf("pivot after partition is %d\n",i);
        return i;
}

int pivot(int arr[], int start, int end)
{
	//if(end-start+1>0){
		int p = start + rand() % (end - start + 1);
		/*printf("start is %d end is %d and second part gives %d\n",start,end,rand()%(end-start+1));
		fflush(stdout);*/
		printf("pivot index %d\n",p);
		fflush(stdout);
		return p;
//	}
	/*else{
		printf("ok %d", (end-start+1));
		fflush(stdout);
		return -1;
			
	}*/
}

void swap(int arr[], int p1, int p2) 
{
        int t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
}
