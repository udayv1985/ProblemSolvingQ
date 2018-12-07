package com.uday.dp;

public class LongIncrSubSeq {
	
	public static int liss(int[] a, int n){
		int r = 0;
		if(n==1){
			return 1;
		}
		if(a[n-1]>a[n-2]){
			r = 1 + liss(a,n-1);
		}
		else {
			r = liss(a,n-1);
		}
		return r;
	}
	
	public static void main(String args[]) 
    { 
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60, 42, 81 }; 
        int arr2[] = {10, 2, 3, 4, 5, 6, 7, 20,9,10,40};
        int n = arr2.length; 
        System.out.println("Length of lis is "
                           + liss(arr2, n) + "n"); 
    } 

}
