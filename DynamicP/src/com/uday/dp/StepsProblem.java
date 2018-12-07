package com.uday.dp;

import java.util.HashMap;
import java.util.Map;

public class StepsProblem {
	
	static Map<Integer,Integer> mem = new HashMap<>();
	
	public static int totalWays(int d){
		int t = 0;
		if(mem.containsKey(d)){
			return mem.get(d);
		}
		if(d<0){
			t = 0;
		}
		else if(d==1 || d==0){
			t = 1;
		}
		else {
			t = totalWays(d-1)+totalWays(d-2)+totalWays(d-3);
		}
		mem.put(d, t);
		return t;
	}
	
	public static void main(String[] args){
		System.out.println(totalWays(6));
		mem.forEach((k,v) -> System.out.println(k+":"+v));
	}

}
