package com.uday.dp;

import java.util.LinkedHashMap;
import java.util.Map;

/*
The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.
Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. 
We make a few assumptions:

…..An egg that survives a fall can be used again.
…..A broken egg must be discarded.
…..The effect of a fall is the same for all eggs.
…..If an egg breaks when dropped, then it would break if dropped from a higher floor.
…..If an egg survives a fall then it would survive a shorter fall.
…..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.

If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. 
Drop the egg from the first-floor window; if it survives, drop it from the second-floor window. 
Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. 
What is the least number of egg-droppings that is guaranteed to work in all cases?
The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that the total number of
trials are minimized.
*/

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
