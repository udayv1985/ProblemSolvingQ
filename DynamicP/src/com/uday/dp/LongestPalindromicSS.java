package com.uday.dp;

public class LongestPalindromicSS {
	
	static int[][] mem;
	
	public static int longest(char str[], int s, int n){
		int r = 0;
		
		if(s>n){
			return 0;
		}
		
		if((n-s+1)==1){
			return 1;
		}
		
		if(str[s]==str[n]){
			r = longest(str,s+1,n-1) + 2; 
		}
		else{
			r = Math.max(longest(str,s+1,n), longest(str,s,n-1));
		}
		return r;
	}
	
	public static void main(String[] args){
		String str = "GEEKSFORGEEKS";
		int n = str.length();
		System.out.println(longest(str.toCharArray(),0,str.length()-1));
		mem = new int[n][n];
	}
	
	public static int longestBottomUp(char str[], int s, int n){
		int r = 0;
		
		if(s>n){
			return 0;
		}
		if((n-s+1)==1){
			return 1;
		}
		mem[0][0] = 1;
		for(int i =0;i<s;i++){
			mem[i][0]=0;
		}
		
		for(int i =0; i<n; i++){
			for(int k =0; k<i; k++){
				mem[i][k] = mem[i+1][k-1] +2;
				Math.max(mem[i+1][k], mem[i][k-1]);
			}
		}
		
		if(str[s]==str[n]){
			r = longest(str,s+1,n-1) + 2; 
		}
		else{
			r = Math.max(longest(str,s+1,n), longest(str,s,n-1));
		}
		return r;
	}

}
