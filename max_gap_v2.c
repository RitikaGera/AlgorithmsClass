/* ao,a1,a2,...an-1 is the given sequence
 * find : max(ai-aj) where i<j
 * Stock Buy Sell Problem
 * Approach : update i to point to min element found so far
 * Complexity : O(n)
 */

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
int max_gap(int[],int);
int main(){
	printf("enter number of elements");
	int n;
	scanf("%d",&n);
	
	printf("enter elements");
	int a[n];
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	
	printf("Gap is %d",max_gap(a,n));
	return 0;


} 


int max_gap(int a[],int n){
	int i=0;
	int max=INT_MIN;
	for(int j=i+1;j<n;j++){
		if(a[j]-a[i]>max)
			max=a[j]-a[i];
		if(a[j]<a[i])
			i=j;
	}
return max;

	
}

