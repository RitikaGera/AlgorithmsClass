/* find the smallest subarray which contains all the numbers from 1 to k atleast once
 * Complexity : O(n)
 * Approach: 
 */
#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
int allK(int[],int,int);
int main(){

	printf("enter n");
	int n;
	scanf("%d",&n);
	printf("enter array");
	int a[n];
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);	
	}
	printf("enter k");
	int k;
	scanf("%d",&k);
	
	printf("starting index is %d",allK(a,n,k));
}

int allK(int a[],int n, int k){
	
	int max=INT_MIN;
	int dcount=0;
	for(int i=0;i<n;i++){
		if(max<a[i]){
			max=a[i];
		}	
	}
	//printf("max is %d",max);
	int counter[max+1];
	for(int i=0;i<=max;i++){
		counter[i]=0;	
	}
	int i;
	for(i=0;i<n;i++){	
		if(a[i]<=k && a[i]>=1){
			if(counter[a[i]]==0){
				dcount++;
							
			}
			
			counter[a[i]]++;
			if(dcount==k){
					break;				
				}
			//printf("counter[%d] is %d\n",a[i],counter[a[i]]);		
		}
	}
	if(i>=n){
		printf("no solution exists\n");
		return -1;
	}
	printf("ending index is %d\n",i);
	for(int i=0;i<n;i++){
		if(a[i]>=1 && a[i]<=k){
						
			if(counter[a[i]]>=1){
				counter[a[i]]--;
				if(counter[a[i]]==0){
					return i;
				}			
			}	
				
		}
	}


}
