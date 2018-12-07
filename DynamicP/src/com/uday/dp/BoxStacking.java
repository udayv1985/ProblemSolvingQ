package com.uday.dp;

public class BoxStacking {
	
	public int stackHeight(int n, int[] h_arr, int[] w_arr, int[] l_arr){
		int max_h = Integer.MIN_VALUE;
		
		if(n==1){
			return max(h_arr[n],w_arr[n], l_arr[n]);
		}
		/*if(n==2){
			if()
		}
		
		if(w_arr[n] < && l_arr[n] <  )
		
		int h1 = stackHeight(n-1,h_arr,w_arr,l_arr) + ;*/
	
		
		return max_h;
	}
	
	public int max(int a, int b, int c){
		return Math.max(a, Math.max(c, b));
	}

}
