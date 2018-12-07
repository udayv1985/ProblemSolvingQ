package com.uday.ds.problems;

// find the maximum j – i such that arr[j] > arr[i]
//where j and i are array indexes from 2 ends
public class MaxIndexDiff {
	
	public static void maxDiff(int[] a){
		int i = 0;
		int j = a.length-1;
		boolean r = true;
		while(i>j){
			if(a[i]<a[j]){
				System.out.println(i+" , "+j);
			}
			
		}
	}

}
