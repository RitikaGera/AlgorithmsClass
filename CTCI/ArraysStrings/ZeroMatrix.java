package ArraysStrings;

import java.util.Scanner;

public class ZeroMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int n= sc.nextInt();
		int[][] a=new int[n][n];
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				a[i][j]=sc.nextInt();
			}
		}
		ZeroMatrix(a);
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	

	}
	//using first row and ist column to store which row and which column to nullify
	private static void ZeroMatrix(int[][]a){
		boolean colhasZero=false;
		boolean rowhasZero=false;
		if(a.length!=a[0].length){
			System.out.println("not a square matrix");
			//if the matrix is not square, it cant be rotated
		}
		//checking the first column for zero values
		for(int i=0;i<a.length;i++){//a.length gives no of rows
			if(a[i][0]==0){
				colhasZero=true;
				break;
			}
		}
	    //checking the first row for zero values
		for(int i=0;i<a[0].length;i++){//a[0].length gives no of columns
			if(a[0][i]==0){
				rowhasZero=true;
				break;
			}
		}
		int n=a.length;//doesnt matter since row and col length is same, so using n
		for(int i=1;i<n;i++){
			for(int j=1;j<n;j++){
				System.out.println(i+" "+j);
				if(a[i][j]==0){
					a[0][j]=0;//setting that ele(col) of first row to be zero
					a[i][0]=0;
				}	
			}
		}
		//nullifying rows on the basis of first col
		for(int i=0;i<n;i++){
			if(a[i][0]==0){
				nullifyRow(a,i);
			}
		}
		
		//nullifying columns on the basis of first row
		for(int i=0;i<n;i++){
			if(a[0][i]==0){
				nullifyColumn(a,i);
			}
		}
		
		if(rowhasZero==true){
			System.out.println("nullify row called for row zero");
			nullifyRow(a,0);
		}
		

		if(colhasZero==true){
			System.out.println("nullify row called for column zero");
			nullifyColumn(a,0);
		}
		
	}
	
	private static void nullifyRow(int[][] a,int row){
		System.out.println("nullify row called for row"+ row);
		for(int i=0;i<a[0].length;i++){
			a[row][i]=0;
		}
	}
	
	private static void nullifyColumn(int[][] a,int column){
		System.out.println("nullify row called for column "+ column);
		for(int i=0;i<a.length;i++){
			a[i][column]=0;
		}
	}

}
