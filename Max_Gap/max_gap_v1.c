/* ao,a1,a2,...an-1 is the given sequence
 * find : max(ai-aj) where i<j
 * Approach : Brute Force
 * Complexity : O(n^2)
 */

#include<stdio.h>
#include<stdlib.h>
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
int max=0;
int b,c;
for(int i=0;i<n;i++){
	for(int j=i+1;j<n;j++){
		if(a[j]-a[i]>max){
			max=a[j]-a[i];
			b=a[i];
			c=a[j];
		}
	}
}
printf("%d %d",b,c);
return max;
	                                 
}
