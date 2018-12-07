package com.uday.dp;

public class PartitionSetForMinSumDiff {
	
	public static int sumDiff(int[] a, int n){
		int d = 0;
		if(n==2){
			d = Math.abs(a[0]-a[1]);
		}
		else{
			d = Math.abs(sumDiff(a,n-1)-a[n-1]);
		}
		return d;
	}
	
	public static int partitionSumDiff(int[] a, int n, int sum1, int sum2){
		int d = 0;
		if(n==2){
			d = Math.abs(a[0]-a[1]);
		}
		else{
			d = Math.abs(sumDiff(a,n-1)-a[n-1]);
		}
		return d;
	}
	
	public static void main(String[] args){
		 int arr[] = {3, 1, 4, 2, 2, 1}; 
	        int n = arr.length; 
	        System.out.print("The minimum difference"+ 
	                        " between two sets is " +  
	                         sumDiff(arr, n)); 
	}

}
