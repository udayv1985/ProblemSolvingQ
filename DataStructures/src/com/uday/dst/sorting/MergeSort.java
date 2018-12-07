package com.uday.dst.sorting;

import java.util.Arrays;

public class MergeSort {
	
	public static int[] mergeSort(int[] arr){
		mergeSort(arr,0,arr.length-1);
		return arr;
	}

	private static void mergeSort(int[] arr, int l, int h) {
		if(h > l){
			int m = (l+h)/2;
			mergeSort(arr,l,m);
			mergeSort(arr,m+1,h);
			merge(arr,l,m,h);
		}
	}

	private static void merge(int[] arr, int l, int m, int h) {
		int t1[] = new int[m-l+1];
		int t2[] = new int[h-m];
		for(int a=0; a<t1.length; a++){
			t1[a]= arr[l+a];
		}
		for(int b=0; b<t2.length; b++){
			t2[b]= arr[m+b+1];
		}
		
		int i = 0, j = 0;
		int arr_index = l;
		while(i<t1.length || j <t2.length){
			if(j==t2.length || (i<t1.length && t1[i]<=t2[j])){
				arr[arr_index] = t1[i];
				i++;
			}
			else{
				arr[arr_index] = t2[j];
				j++;
			}
			arr_index++;
		}
	}
	
	public static void main(String[] args){
		int arr[] = {8,4,1,6,7,3,2,8,9,5};
		arr = mergeSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	

}
