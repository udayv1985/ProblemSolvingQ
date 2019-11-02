package com.uday.dp;

// same as max sum without consecutive two elements problem
public class SticklerThief {
	
	public static int maxAmt(int[] a, int n){
		int s = 0;
		if(n==1){
			return a[n-1];
		}
		else if(n==2){
			return Math.max(a[n-1], a[n-2]);
		}
		//s = Math.max(maxAmt(), b)
		return s;
	}

}
