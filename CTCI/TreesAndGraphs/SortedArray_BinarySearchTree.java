// given a sorted (increasing) array with unique integer elements, build a binary search tree such that height is minimum
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;


public class SortedArray_BinarySearchTree{
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter elements in increasing order");
		// BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		// String[] input = bf.readLine().split("\\s");
		// int n = input[0];
		// int[] num = new int[input.size() - 1];
		// for( int i = 1; i < input.size(); i++){
		// 	num[i] = Integer.parseInt(input[i]);
		// }
		int n = sc.nextInt();
		int[] num = new int[n];
		for( int i = 0 ; i < n; i++){
			num[i] = sc.nextInt();
		}
		Arrays.sort(num);
		BinarySearchTree bst = new BinarySearchTree();
		SortedArray_BinarySearchTree obj = new SortedArray_BinarySearchTree();
		bst = obj.make_BST(bst, num, 0 , num.length - 1);
		System.out.println(bst.getRoot());
		bst.InOrderTraversal(bst.getRoot());
		
	}

	public BinarySearchTree make_BST(BinarySearchTree bst, int[] num, int low, int high){
		if( low > high){
			return null;
		}
		
			int mid = ( low + high )/2;
			bst.insert(num[mid]);
			System.out.println("here "+ bst.getRoot());
			make_BST(bst, num, 0, mid - 1);
			make_BST(bst, num, mid + 1, num.length - 1);
		
		
			return bst;
		
		
		
	}
}