//You are given n activities with their start and finish times. Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time.

import java.util.Scanner;

public class ActivitySelection{

	class Activity{

		int start, finish;
		
	}

	public static void main(Strng[] args){
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Activity[] activities = new Activity[n];
		
		
		for( int i = 0; i < n; i++){
			activities[i] = new Activity();
			activities[i].start = sc.nextInt();
			activities[i].finish = sc.nextInt();
		}

		Activity activity = new Activity(start, finish);
		// get indices of activites that can be scheduled
		ArrayList<Integer> list = select(activity);
		Iterator it = list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());

		}

	}

	public Arraylist select(Activity[] activities){
		Arraylist<Integer> list = new Arraylist();
		list.add(0);
		for( int i = 1; i < activities.length; i++){
			if( activities[i].start >= activities[i - 1].finish ){
				list.add(i);
			}
		}
		return list;

	}
}