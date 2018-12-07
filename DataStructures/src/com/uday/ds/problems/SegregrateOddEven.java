package com.uday.ds.problems;

import java.util.Arrays;

import com.uday.dst.sorting.BasicSortAlgos;

public class SegregrateOddEven {
	
	public static int[] separateOE(int[] a){
		int i = 0;
		int j = a.length-1;
		while(i<j){
			if(isOdd(a[i]) && isEven(a[j])){
				swapArrayElements(a,i,j);
				i++;
				j--;
			}
			else if(isEven(a[i])){
				i++;
			}
			else if(isOdd(a[j])){
				j--;
			}
		}
		return a;
	}
	
	private static void swapArrayElements(int[] a, int i, int j) {
		BasicSortAlgos.swayArrayElements(a, i, j);
		
	}

	private static boolean isEven(int n){
		return (n%2==0);
	}
	
	private static boolean isOdd(int n){
		return !isEven(n);
	}
	
	public static void main(String[] args){
		int[] a = {10,13,23,24,37,26,42};
		a = separateOE(a);
		System.out.println(Arrays.toString(a));
	}
	

}
