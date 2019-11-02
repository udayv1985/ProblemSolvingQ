package com.uday.dp;

import java.util.LinkedHashMap;
import java.util.Map;

public class EggDropProblem {
	
	static Map<Key,Integer> mem = new LinkedHashMap<>();
	
	public int floor(int n_floors, int eggs){
		if(eggs==1 || n_floors ==1 || n_floors ==0){
			return n_floors;
		}
		int a;
		int b = Integer.MAX_VALUE;
		for(int i = 1; i <=n_floors; i++){
			a = Math.max(floor(i-1,eggs-1),floor(n_floors-i,eggs));
			b = Math.min(b, a);
		}
		
		return b+1;
	}

	public int findBottomUp(int floors, int eggs){
		int[][] count = new int[floors][eggs];
		for(int i=0;i<floors;i++){
			count[i][0] = i;
		}
		for(int i=0;i<eggs;i++){
			count[i][0] = 1;
		}
		for(int i =1;i<floors;i++){
			//count[i][j] = Integer.MAX;
			for(int j=1; j<eggs; j++){
				count[i][j] = 1+ Math.max(count[i-1][j-1],count[floors-i][j]);

			}
		}
		return count[floors-1][eggs-1];
	}

}
