package com.uday.dp;

import java.util.HashMap;
import java.util.Map;

public class AlphaCode {
	
	static Map<String,Integer> mem = new HashMap<>(); 
	
	public static int seqCount(String code){
		int count = 0;
		if(mem.containsKey(code)){
			return mem.get(code);
		}
		if(code.startsWith("0")){
			count = 0;
		}
		else if(code.length()==1){
			if(Integer.valueOf(code)==0){
				count = 0;
			}
			else{
				count =1;
			}
		}
		else if (code.length() == 2){
			if(Integer.valueOf(code)<=26 
					&& Integer.valueOf(code)!=10
					&& Integer.valueOf(code)!=20){
				count = 2;
			}
			else if(!code.endsWith("0") 
					|| (Integer.valueOf(code)==10) 
					|| Integer.valueOf(code)==20){
				count = 1; 
			}
		}
		else{
			count = seqCount(code.substring(1));
			if(Integer.valueOf(code.substring(0, 2))<=26){
				count += seqCount(code.substring(2));
			}
		}
		mem.put(code, count);
		return count;
	}
	
	public static void main (String[] args){
		System.out.println(seqCount("21"));
	}

}
