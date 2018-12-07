package com.uday.dp;

import java.util.HashMap;
import java.util.Map;

public class MaxSumNo3Adj {
	
	static Map<Integer,Integer> mem = new HashMap<>();
	
	public static int maxSum(int a[], int n){
		int m = 0;
		
		if(n==1){
			return a[n-1];
		}
		else if(n==2){
			return a[n-1]+a[n-2];
		}
		else if(n<1){
			return 0;
		}
		
		int s1 = maxSum(a,n-1);
		int s2 = maxSum(a,n-2) + a[n-1];
		int s3 = maxSum(a,n-3) + a[n-2] + a[n-1];
		m = Math.max(s1, Math.max(s2, s3));
		
		return m; 
	}
	
	 public static void main(String[] args) 
	    { 
	        int arr[] = { 100, 1000, 100, 1000, 1 }; 
	        int n = arr.length; 
	        System.out.println(maxSum(arr,n)); 
	    } 
	
	public static int maxSumBottomUp(int a[]){
		int m = 0;
		mem.put(0, 0);
		mem.put(1, a[0]);
		mem.put(2, a[0]+a[1]);
		for(int i =3; i <=a.length; i++){
			m = Math.max(mem.get(i-1), 
					Math.max(mem.get(i-2)+a[i-1], mem.get(i-3)+a[i-2]+a[i-1]));
			mem.put(i, m);
		}
		return m; 
	}
	

}
