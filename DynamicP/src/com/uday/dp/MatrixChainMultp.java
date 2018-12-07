package com.uday.dp;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/*Given an array p[] which represents the 
 * chain of matrices such that the ith matrix Ai is of dimension p[i-1] x p[i]. 
 * We need to write a function MatrixChainOrder() that should return the 
 * minimum number of multiplications needed to multiply the chain.*/
public class MatrixChainMultp {
	
	static Map<Key,Integer> mem = new LinkedHashMap<>();
	
	public static int matrixChainOrder(int[] p, int s, int n){
		Key k = new Key(s,n);
		Integer r = mem.get(k);
		if(null!=r){
			System.out.println("Mem Used");
			return r.intValue();
		}
		if((n-s+1)==3){
			return p[s]*p[s+1]*p[s+2];
		}
		int a = matrixChainOrder(p,s,n-1) + p[s]*p[n-1]*p[n];
		int b = matrixChainOrder(p,s+1,n) + p[s]*p[s+1]*p[n];
		r = Integer.min(a, b);
		mem.put(k, r);
		return r.intValue();
	}
	
	public static void main(String[] args){
		int[] p = {10, 20, 30, 40, 30, 50, 40, 60, 30}   ;
		System.out.println(matrixChainOrder(p,0,p.length-1));
		mem.forEach((k,v) -> System.out.println(k.toString()+" ; "+v));
	}

}
