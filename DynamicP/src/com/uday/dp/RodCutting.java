package com.uday.dp;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces
 */
public class RodCutting {
	
	static Map<Integer,Integer> mem = new LinkedHashMap<>();
	
	public static int maxPrice(int[] a, int n){
		int p = 0;
		if(n<=0){
			return 0;
		}
		Integer r = mem.get(n);
		if(null!=r){
			return r.intValue();
		}
		for(int i=0; i<n; i++){
			p = Math.max(p,a[i] + maxPrice(a,n-i-1));
		}
		mem.put(n, p);
		return p;
	}
	
	public static int maxPriceBottomUp(int[] a, int n){
		
		mem.put(0, 0);
		for(int j=1;j<n+1;j++){
			int p = 0;
			for(int i=0; i<j; i++){
				p = Math.max(p,a[i] + mem.get(j-i-1));
			}
			mem.put(j, p);
		}
		return mem.get(n);
	}
	
	 public static void main(String args[]) 
	    { 
	        int arr[] = new int[] {3, 5, 8, 9, 10, 17, 17, 20,200};
	        int size = arr.length; 
	        System.out.println("Maximum Obtainable Value is " + 
	        		maxPriceBottomUp(arr, size));
	        mem.entrySet().stream().forEach(
	        		e->System.out.println(e.getKey()+":"+e.getValue()));
	    } 

}
