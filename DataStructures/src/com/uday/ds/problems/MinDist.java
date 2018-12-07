package com.uday.ds.problems;

//min distance bw 2 numbers in an array 
public class MinDist {
	
	public static int minDist(int[] arr, int x, int y){
		int min = Integer.MAX_VALUE;
		int idx_x = -100;
		int idx_y = -100;
		for(int i =0; i<arr.length; i++){
			if(arr[i]==x){
				//processFind(idx_x,idx_y,i,min);
				idx_x = i;
				int diff = idx_x-idx_y;
				if(diff<min){
					min = diff;
				}
			}
			else if(arr[i]==y){
				//processFind(idx_y,idx_x,i,min);
				idx_y = i;
				int diff = idx_y-idx_x;
				if(diff<min){
					min = diff;
				}
			}
		}
		return min;
		
	}
	
	
	public static void main(String[] args){
		 int arr[] = {3, 5, 4, 2, 6, 5, 6, 6, 5, 4, 8, 3}; 
	        int n = arr.length; 
	        int x = 3; 
	        int y = 6; 
	  
	        System.out.println("Minimum distance between " + x + " and " + y  
	                + " is " + minDist(arr,x, y)); 
	}
}
