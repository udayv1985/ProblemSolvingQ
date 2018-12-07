package com.uday.dp;

public class MaxProductCut {
	
	public static int maxProductCut(int n){
		int r = Integer.MIN_VALUE;
		if(n==2){
			return 1; 
		}
		for(int i=1;i<n;i++){
			r = Math.max(r, Math.max((n-i)*i,maxProductCut(n-i)*i));
		}
		return r;
	}
	
	public static void main(String[] args){
		System.out.println(maxProductCutBottomUp(10));
	}
	
	public static int maxProductCutBottomUp(int n){
		int mem[] = new int[n+1];
		for(int i = 1; i <=n; i++){
			mem[i]= 0;
		}
		mem[2]=1;
		for(int i=3;i<=n;i++){
			for(int j=1;j<i;j++){
				mem[i] = Math.max(mem[i],Math.max((i-j)*j,mem[i-j]*j));
			}
			System.out.println(i+" - "+mem[i]);
		}
		return mem[n];
	}

}
