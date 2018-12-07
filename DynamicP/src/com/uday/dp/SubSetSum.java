package com.uday.dp;

import java.util.LinkedHashMap;
import java.util.Map;

public class SubSetSum {
	
	static Map<Key,Boolean> mem = new LinkedHashMap<>();
	
	public static boolean subSetSum(int[] a, int s){
		return subSetSum(a,s,a.length);
	}

	private static boolean subSetSum(int[] a, int s, int n) {
		boolean r = false;
		if(mem.containsKey(new Key(s,n))){
			return mem.get(new Key(s,n));
		}
		if(n==0 && s >0){
			return false;
		}
		if(s==0){
			return true;
		}
		if(a[n-1]==s){
			return true;
		}
		else{
			r =  subSetSum(a,s,n-1);
			if(!r && a[n-1]<s){
				r = subSetSum(a,s-a[n-1],n-1);
			}
		}
		mem.put(new Key(s,n), r);
		return r;
	}
	
	public static void main(String args[]){
		int set[] = {3, 34, 4, 12, 5, 2}; 
        int sum = 9; 
 
        if (subSetSumBottomUp(set,sum,set.length) == true) 
            System.out.println("Found a subset"
                          + " with given sum"); 
        else
            System.out.println("No subset with"
                               + " given sum"); 
        mem.entrySet().stream().forEach(
        		e -> System.out.println(e.getKey().toString()+" : " + e.getValue()));
	}
	
	public void printAllSubSetSums(int[] a, int s){
		
	}
	
	private static boolean subSetSumBottomUp(int[] a, int s, int n){
		
		for(int i =0;i<=n;i++){
			mem.put(new Key(0,i), true);
		}
		for(int i=1;i<=s;i++){
			mem.put(new Key(i,0), false);
		}
		
		for(int i =1; i<=s; i++){
			for(int j = 1; j<=n; j++){
				Key k = new Key(i,j);
				boolean r = mem.get(new Key(i,j-1)); 
				if(!r && a[j-1]<=i){
					r = mem.get(new Key(i-a[j-1],j-1));
				}
				mem.put(k, r);
			}
		}
		
		return mem.get(new Key(s,n));
	}

}
