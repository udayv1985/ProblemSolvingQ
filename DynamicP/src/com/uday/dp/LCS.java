package com.uday.dp;

import java.util.HashMap;
import java.util.Map;

public class LCS {
	
	static Map<String,Integer> mem = new HashMap<>();
	
	public static int lcs(String s1, String s2){
		int l1 = s1.length();
		int l2 = s2.length();
		return lcs(s1.toCharArray(),s2.toCharArray(),l1,l2);
	}
	
	public static int lcs(char[] s1, char[] s2, int l1, int l2){
		int lcs = 0; 
		
		if(l1==0 || l2==0){
			return 0;
		}
		if(mem.containsKey(getKey(s1,s2))){
			return mem.get(getKey(s1,s2));
		}
		if(s1[l1-1]==s2[l2-1]){
			lcs = lcs(s1,s2,l1-1,l2-1) + 1;
		}
		else{
			lcs = Math.max(lcs(s1,s2,l1,l2-1),lcs(s1,s2,l1-1,l2));
		}
		mem.put(getKey(s1,s2), lcs);
		return lcs; 
	}
	
	public static String getKey(char[] s1, char[] s2){
		return new String(s1)+","+new String(s2);
	}
	
	public static void main(String[] args){
		System.out.println(lcs("AGGTAB","GXTXAYB"));
	}

}
