package com.uday.dp;

import java.util.LinkedHashMap;
import java.util.Map;

public class EggDropProblem {
	
	static Map<Key,Integer> mem = new LinkedHashMap<>();
	
	public int floor(int n_floors, int eggs){
		if(eggs==1 || n_floors ==1 || n_floors ==0){
			return n_floors;
		}
		
		int a = Integer.MIN_VALUE;
		int b = Integer.MAX_VALUE;
		for(int i = 1; i <=n_floors; i++){
			a = Math.max(floor(i-1,eggs-1),floor(n_floors-i,eggs));
			b = Math.min(b, a);
		}
		
		return b+1;
	}

}
