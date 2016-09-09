/* ao,a1,a2,...an-1 is the given sequence
 * find : max(ai-aj) where CONSTRAINT j-i>=l where l>0 holds
 * Stock Buy Sell Problem
 * Cant cant sell before l days
 * Approach : 
 * Complexity : O(n)
 */

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
int max_gap(int[],int,int);
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

int max_gap(int a[],int n,int l){
	int max=INT_MIN;
	int i=0;
	int b,c;
	for(int j=l+1;j<n;j++){
		if(a[j]-a[i]>max){
			max=a[j]-a[i];
			//printf("%d",max);	
			b=a[j];
			c=a[i];	
		}
		if(a[i]>a[j-l]){
			i=j-l;
		//	printf(" \ni \n%d",i);		
		}
	}
	printf("%d %d",b,c);
	return max;


}
