/* ao,a1,a2,...an-1 is the given sequence
 * find : max(ai-aj) where CONSTRAINT j-i<=l where l>0 holds , sell within l days or i<=j<=i+l
 * Stock Buy Sell Problem
 * Approach : keep updating i as j increments, sort of a queue discard the last element, include the new element
 * Complexity : O(n^2) :Sort of Brute force, not exactly
 */

#include<stdio.h>
#include<stdlib.h>
#include<limits.h>
int max_gap(int[],int,int);
int find_min(int a[],int start,int l,int max);
int main(){
	printf("enter number of elements");
	int n;
	scanf("%d",&n);
	printf("enter number of days within which to sell stocks");
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

int find_min(int a[],int start,int l, int max){

	int f=0;
	for(int k=start;k<l;k++){
			if(a[l]-a[k]>max){
				max=a[l]-a[k];
				f=k;//f is the index which gives max profit in first slot, it is essentially the min i in first slot
			}
		}
return f;
}
int max_gap(int a[],int n,int l){
	
	int max=INT_MIN;
	int b,c;	
	int f=find_min(a,0,l,max);
	printf("f is %d\n",f);
	int i=f;//i contains the min elligible so far
	for(int j=l+1;j<n;j++){
		if(i<j-l){
			int puranamax=max;
			if(a[i]>a[j-1]){
			i=j-1;
		}
		else {
			i=find_min(a,i+1,l,max);
		}

		}
		if(a[j]-a[i]>max){
			max=a[j]-a[i];
			b=a[j];
			c=a[i];
		}
		if(a[i]>a[j-1]){
			i=j-1;
		}
	}
	printf("%d %d",b,c);
	return max;


}
