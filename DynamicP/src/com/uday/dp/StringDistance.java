package com.uday.dp;

import java.util.HashMap;
import java.util.Map;

public class StringDistance {
	
	static Map<Key,Integer> mem = new HashMap<>();

	public static int minChangesReq(String s1, String s2, int x, int y){
		int r = 0;
		if(mem.containsKey(new Key(x,y))){
			return mem.get(new Key(x,y));
		}
		if(x==0){
			r = y;
		}
		else if(y==0){
			r = x;
		}
		else {
			if(s1.charAt(x-1)==s2.charAt(y-1)){
				r = minChangesReq(s1,s2,x-1,y-1);
			}
			else{
				r = 1+Math.min(
						minChangesReq(s1,s2,x-1,y), // delete  
						Math.min(
								minChangesReq(s1,s2,x-1,y-1), // replace  
								minChangesReq(s1,s2,x,y-1) // insert 
								));
			}
		}
		mem.put(new Key(x,y), r);
		return r;
	}
	
	public static void main(String[] args){
		  String str1 = "sunday"; 
	      String str2 = "saturday"; 
	   
	      System.out.println( 
	    		  minChangesReq(str1,str2,str1.length(),str2.length()));
	      mem.forEach((k,v)->System.out.println(k.toString()+" : "+v));
	     // mem.entrySet().stream().forEach(action);
	}

}
