package com.uday.dp;

import java.util.LinkedHashMap;
import java.util.Map;

public class KnapSack {
	
	static Map<Key,Integer> mem = new LinkedHashMap<>();
	
	public static int maxVal(int[] w, int[] v, int n, int maxW){
		if(maxW==0){
			return 0;
		}
		if(n<1){
			return 0;
		}
		Key k = new Key(n,maxW);
		Integer m = mem.get(k);
		if(null!=m){
			return m.intValue();
		}
		int maxV = 0;
		maxV = maxVal(w,v,n-1,maxW);
		if(w[n-1]<=maxW){
			maxV = Math.max(maxV,v[n-1] + maxVal(w,v,n-1,maxW-w[n-1]));
		}
		mem.put(k, maxV);		
		return maxV;
	}
	
	public static void main(String[] args){
		int val[] = new int[]{60, 100, 120}; 
        int wt[] = new int[]{10, 20, 30}; 
        int  W = 50; 
        int n = val.length; 
        System.out.println(maxVal(wt, val, n,W)); 
        mem.entrySet().stream().forEach(
        		e->System.out.println(e.getKey().toString()+":"+e.getValue()));
	}

}
