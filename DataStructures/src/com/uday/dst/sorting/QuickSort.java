package com.uday.dst.sorting;

import java.util.Arrays;

public class QuickSort {
	
	public static int[] quickSort(int[] arr, int l, int h){
		if(l<h){
			int p = partition(arr,l,h);
			arr = quickSort(arr,l,p-1);
			arr = quickSort(arr,p+1,h);
		}
		return arr;
	}

	private static int partition(int[] arr, int l, int h) {
		int pivot = arr[h];
		int i = l-1;
		for(int j = l; j < h; j++){		
			if(arr[j]<=pivot){
				i++;
				if(i!=j){
					BasicSortAlgos.swayArrayElements(arr, i, j);
				}
			}
		}
		if((i+1)!=h){
			BasicSortAlgos.swayArrayElements(arr, i+1, h);
		}
		return i+1;
	}
	
	public static void main(String args[]){
		int arr[] = {8,4,1,6,7,3,2,8,9,5};
		arr = quickSort(arr,0,arr.length-1);
		System.out.println(Arrays.toString(arr));
	}

}
