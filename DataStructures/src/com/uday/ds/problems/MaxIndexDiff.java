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
				return;
			}
			else if(a[i+1]<a[j]){
				System.out.println((i+1)+" , "+j);
				return;
			}
			else if(a[i]<a[j-1]){
				System.out.println(i+" , "+(j-1));
				return;
			}
			else{
				i++;
				j--;
			}
		}
	}

}
