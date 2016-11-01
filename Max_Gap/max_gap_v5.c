#include<iostream>
#include<dequeue>

int main(){
	int n,l;
	cin<<n<<l;
	
	int a[n];
	
	for(int i=0;i<n;i++){
		cin<<a[i];	
	}
	
	dequeue<int> minQ;
	
	int max=a[1]-a[0];

	for(int i=0;i<n;i++){

		while(!minQ.empty() && a[minQ.back()]>=a[i]){
			minQ.pop_back();		
		}	
	
		if(!minQ.empty() && minQ.front<i-l){
			minQ.pop_front();	//element out of window	
		}		
		
		minQ.push(i);
		//update max
		if(i-l>=0){
			if(a[i]-a[minQ.front()]>max){
				max=a[i]-a[minQ.front()];			
			}
		}
		
	}
	cout<<max;

}
