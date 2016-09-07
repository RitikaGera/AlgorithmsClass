/* Version2 : N numbers(10^10), select K smallest of them
 * Approach : Maintain an array of size 2*K, find median determinsiatically , the last K are not candidates,so we discard them and take next k,
 * We repeat until all elements are covered, so find median is called N/K times roughly
 * Space Complexity : O(2*K)
 * Time Complexity : O(N*K)
 */
#include<stdio.h>
#include<stdlib.h>
#include<ctype.h>
#include<math.h>

#define K 10

int partition(int arr[], int start, int end);
int pivot(int arr[], int start, int end);
int median5(int arr[], int start, int end);
void swap(int arr[], int pos1, int pos2);
int myselect(int arr[], int start, int end, int rank);

int main(int argc, char* argv[]){

	FILE *fp=fopen(argv[1],"r");
	int input[2*K];
	
	for(int i=0;i<2*K;i++){
		fscanf(fp,"%d",&input[i]);	
	}
	printf("hi1\n");
	fflush(stdout);
	int median_pos=myselect(input,0,2*K-1,K);
	printf("\nin main pivot %d and value is %d ",median_pos,input[median_pos]);
	
	int k=median_pos+1;
	printf(" k is %d\n",k);
	printf("#####YAHAN TAK DEKHO");
	fflush(stdout);
//yahan hai problem
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



int myselect(int arr[], int start, int end, int rank)
{
        if (start == end)
                return start;
        int pos = partition(arr, start, end);
        int r = end - pos + 1;
        if (r == rank) 
                return pos;
        if (r<rank)
                return myselect(arr, start, pos-1, rank-r);
        else
                return myselect(arr, pos+1, end, rank);

}


int partition(int arr[], int start, int end)
{

        int i, j, pos;
        i = start - 1;
        j = start;
        pos = pivot(arr, start, end); 
	printf("pivot as in partition is %d %d\n",pos,arr[pos]);
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
	printf("i is %d and a[i] is %d \n",i,arr[i]);
        return i;
}

int pivot(int arr[], int start, int end)
{
        if (end - start <= 5)
                return median5(arr, start, end);
        for (int i = start; i <= end; i = i + 5) 
        {
                int sub_end = i + 4;
                if (sub_end > end)
                        sub_end = end;
                int med_pos = median5(arr, i, sub_end);
                //swap to the beginning of the list
                int loc = start + ((i - start)/5);
                swap(arr, loc, med_pos);
		printf("***after swap***");
		for(int i=0;i<=sub_end;i++){
			printf("%d	",arr[i]);		
		}
        }
	printf("\nout of for %d %d\n",start, start + (int)(ceil((end - start)/5) - 1));
	fflush(stdout); 
        return pivot(arr, start, start + ceil((end - start)/5) - 1); 
}

int median5(int arr[], int start, int end)
{
	
        int p = (end - start)/2;
        for (int i = start; i <= end; ++i) 
        {
                int min = i;
                for (int j = i + 1; j <= end; ++j)
                        if (arr[j] < arr[min])
                                min = j;
                swap(arr, i, min);
        }
	printf("****IN MEDIAN********");
	for(int i=start;i<=end;i++){
		printf("%d	",arr[i]);	
	}
	printf("\nreturning this from median5 %d\n",start+p);
        return start+p;
}

void swap(int arr[], int p1, int p2) 
{
        int t = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = t;
}
