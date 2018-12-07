package com.uday.dst.sorting;

import java.util.Arrays;

public class BasicSortAlgos {
	
	public static int[] selectionSort(int[] arr){
		for(int i=0; i < arr.length-1; i++){
			int min_index = i;
			for(int j = i+1;j<arr.length;j++){
				if(arr[j]<arr[min_index]){
					min_index = j;
				}
			}
			if(i!=min_index){
				swayArrayElements(arr,i,min_index);
			}
		}
		return arr; 
	}
	
	public static int[] bubbleSort(int[] arr){
		for(int i=0; i < arr.length-1; i++){
			for(int j = 0;j<arr.length-1-i;j++){
				if(arr[j]>arr[j+1]){
					swayArrayElements(arr,j,j+1);
				}
			}
		}
		return arr; 
	}
	
	public static int[] insertionSort(int[] arr){
		for(int i=1; i < arr.length; i++){
			
			int j = i-1; 
			int key = arr[i];
			while(j>-1 && arr[j]>key){
				
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
	
		}
		return arr; 
	}
	
	public static void swayArrayElements(int arr[], int i, int min_index) {
		int temp = arr[i];
		arr[i] = arr[min_index];
		arr[min_index] = temp;
	}

	public static void main(String args[]){
		int arr[] = {8,4,1,6,7,3,2,8,9,5};
		arr = insertionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
