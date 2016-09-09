/* ao,a1,a2,...an-1 is the given sequence
 * find : max(ai-aj) where CONSTRAINT j-i<=l where l>0 holds or i<=j<=i+l
 * Stock Buy Sell Problem
 * Approach : 
 * Complexity : O(n)
 */

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
int max_gap(int[],int,int);
int find_min(int a[],int start,int l);
int main(){
	printf("enter number of elements");
	int n;
	scanf("%d",&n);
	printf("enter minimum number of days to wait");
	int l;
	scanf("%d",&l);
	
	printf("enter elements");
	int a[n];
	for(int i=0;i<n;i++){
		scanf("%d",&a[i]);
	}
	
	printf("Gap is %d",max_gap(a,n,l));
	return 0;


} 

